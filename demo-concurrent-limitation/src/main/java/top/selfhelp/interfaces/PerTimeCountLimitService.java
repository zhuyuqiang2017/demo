package top.selfhelp.interfaces;

import java.util.concurrent.ExecutionException;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public interface PerTimeCountLimitService {

    /**
     * 判断单位时间内调用量是否超出限制
     * @param time 当前调用时间
     * @return 判断结果，true：未超出，false：已超出
     * @throws ExecutionException 调用异常，抛出执行异常
     */
    boolean isPermitted(long time) throws ExecutionException;
}
