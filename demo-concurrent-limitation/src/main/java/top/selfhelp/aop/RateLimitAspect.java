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
import top.selfhelp.RateLimitServiceImpl;
import top.selfhelp.annotations.RateLimit;
import top.selfhelp.exception.LimitationException;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Component
@Aspect
public class RateLimitAspect {

    private final Logger logger = LoggerFactory.getLogger(RateLimitAspect.class);

    private final ConcurrentHashMap<String,RateLimitServiceImpl> rateLimitMapper = new ConcurrentHashMap<>();

    @Pointcut(value = "@annotation(top.selfhelp.annotations.RateLimit)")
    public void rateLimitPointCut(){

    }

    @Around(value = "rateLimitPointCut()")
    public Object permittedCheck(ProceedingJoinPoint joinPoint) throws LimitationException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        try {
            Method targetMethod =
                    joinPoint.getTarget().getClass().getMethod(signature.getName(), signature.getParameterTypes());
            RateLimit rateLimit = targetMethod.getDeclaredAnnotation(RateLimit.class);
            String name = StringUtils.isEmpty(rateLimit.name())?targetMethod.getName():rateLimit.name();
            logger.debug("当前限流参数：名称：{}，允许最大并行数量：{}，最大等待时间：{}，时间单位：{}",
                    name,rateLimit.permitsPerSecond(),rateLimit.timeout(),rateLimit.unit());
            CountLimitServiceImpl countLimitService = countLimitMapper
                    .get(name);
            //并发数量控制器不存在，新建并发控制器
            if(countLimitService == null){
                countLimitService = new CountLimitServiceImpl(countLimit.count(),false,countLimit.timeout(),countLimit.unit());
            }
            long start = System.currentTimeMillis();
            logger.debug("当前请求线程id：{},尝试获取请求令牌时间：{}",Thread.currentThread().getId(),start);
            countLimitService.acquire();
            logger.debug("当前请求线程id：{}，请求令牌等待时间：{}",Thread.currentThread().getId(),(System.currentTimeMillis()-start));
            //添加并发控制器到内存中，供下次获取
            countLimitMapper.put(name,countLimitService);
            Object result = joinPoint.proceed(joinPoint.getArgs());
            countLimitService.release();
            return result;
        }  catch (Throwable throwable) {
            logger.error("并发数量控制异常",throwable);
            throw new LimitationException(throwable);
        }
    }
}
