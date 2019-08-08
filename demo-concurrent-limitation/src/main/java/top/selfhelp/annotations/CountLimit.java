package top.selfhelp.annotations;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CountLimit {

    /**
     * 限制器名称
     */
    String name() default "";

    /**
     * 允许最大的并发数量
     */
    int count() default 10;

    /**
     * 当前线程最大等待时间
     */
    long timeout() default 60;

    /**
     * 线程等待时间的单位
     */
    TimeUnit unit() default TimeUnit.SECONDS;
}
