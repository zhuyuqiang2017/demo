package top.selfhelp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import top.selfhelp.service.PerTimeCountLimitServiceImpl;
import top.selfhelp.annotations.PerTimeCountLimit;
import top.selfhelp.exception.LimitationException;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Component
@Aspect
public class PerTimeCountLimitAspect {

    private final Logger logger = LoggerFactory.getLogger(PerTimeCountLimitAspect.class);

    private final ConcurrentHashMap<String,PerTimeCountLimitServiceImpl> perTimeCountLimitMapper = new ConcurrentHashMap<>();

    @Pointcut("@annotation(top.selfhelp.annotations.PerTimeCountLimit)")
    public void perTimeCountLimitPointCut(){

    }

    @Around("perTimeCountLimitPointCut()")
    public Object permittedCheck(ProceedingJoinPoint joinPoint) throws LimitationException{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        try {
            Method targetMethod =
                    joinPoint.getTarget().getClass().getMethod(signature.getName(), signature.getParameterTypes());
            PerTimeCountLimit perTimeCountLimit = targetMethod.getDeclaredAnnotation(PerTimeCountLimit.class);
            String name = StringUtils.isEmpty(perTimeCountLimit.name())?targetMethod.getName():perTimeCountLimit.name();
            logger.debug("当前限流参数：名称：{}，允许最大并行数量：{}，最大时间间隔：{}，时间单位：{}",
                    name,perTimeCountLimit.permits(),perTimeCountLimit.duration(),perTimeCountLimit.timeUnit());
            PerTimeCountLimitServiceImpl perTimeCountLimitService = perTimeCountLimitMapper
                    .get(name);
            //并发数量控制器不存在，新建并发控制器
            if(perTimeCountLimitService == null){
                perTimeCountLimitService = new PerTimeCountLimitServiceImpl(perTimeCountLimit.permits(),
                        perTimeCountLimit.duration(),perTimeCountLimit.timeUnit());
                //添加并发控制器到内存中，供下次获取
                perTimeCountLimitMapper.put(name,perTimeCountLimitService);
            }
            long start = System.currentTimeMillis();
            if(perTimeCountLimitService.isPermitted(start)){
                logger.debug("当前请求线程id：{},尝试请求时间：{}",Thread.currentThread().getId(),start);
                return joinPoint.proceed(joinPoint.getArgs());
            }else{
                logger.debug("当前请求线程id：{}，超出请求次数，当前请求时间：{}",Thread.currentThread().getId(),start);
                throw new LimitationException("单位时间内超出允许请求的次数");
            }
        }  catch (Throwable throwable) {
            logger.error("并发数量控制异常",throwable);
            throw new LimitationException(throwable);
        }
    }

}
