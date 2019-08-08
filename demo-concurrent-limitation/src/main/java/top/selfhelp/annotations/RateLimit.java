package top.selfhelp.annotations;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimit {

    /**
     * 控制器名称
     */
    String name() default "default";

    /**
     * 令牌生产速率
     */
    double permitsPerSecond() default 10;

    /**
     * 预热时间
     */
    long warmupPeriod() default 200;

    /**
     * 预热时间的时间单位
     */
    TimeUnit unit() default TimeUnit.MILLISECONDS;

    /**
     * 是否为预热模式
     */
    boolean warmupMode() default true;

    /**
     * 线程最大等待时间
     */
    long timeout() default 10;

    /**
     * 线程等待时间的时间单位
     */
    TimeUnit timeoutUnit() default TimeUnit.SECONDS;
}
