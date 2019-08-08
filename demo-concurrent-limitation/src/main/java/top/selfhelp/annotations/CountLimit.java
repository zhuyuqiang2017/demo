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

    String name() default "";

    int count() default 10;

    long timeout() default 60;

    TimeUnit unit() default TimeUnit.SECONDS;
}
