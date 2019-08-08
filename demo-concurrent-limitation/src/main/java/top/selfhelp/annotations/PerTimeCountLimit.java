package top.selfhelp.annotations;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PerTimeCountLimit {

    String name() default "";

    long permits() default 50L;

    long duration() default 60;

    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
