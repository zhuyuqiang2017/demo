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

    String name() default "default";

    double permitsPerSecond() default 10;

    long warmupPeriod() default 200;

    TimeUnit unit() default TimeUnit.MILLISECONDS;

    boolean warmupMode() default true;

    long timeout() default 10;

    TimeUnit timeoutUnit() default TimeUnit.SECONDS;
}
