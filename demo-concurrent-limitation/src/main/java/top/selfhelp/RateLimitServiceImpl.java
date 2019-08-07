package top.selfhelp;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class RateLimitServiceImpl {

    private RateLimiter rateLimiter = null;

    private static double PERMITS_PER_SECOND = 0.01D;

    public RateLimitServiceImpl(){
        this(PERMITS_PER_SECOND);
    }

    public RateLimitServiceImpl(double permitsPerSecond){
        this.rateLimiter = RateLimiter.create(permitsPerSecond);
    }

    public RateLimitServiceImpl(double permitsPerSecond,long warmupPeriod, TimeUnit unit ){
        this.rateLimiter = RateLimiter.create(permitsPerSecond,warmupPeriod,unit);
    }

    public double acquire(){
        return rateLimiter.acquire();
    }

    public double acquire(int permits){
        return rateLimiter.acquire(permits);
    }

    public boolean acquire(long timeout, TimeUnit unit){
        return rateLimiter.tryAcquire(timeout,unit);
    }

    public boolean acquire(int permits, long timeout, TimeUnit unit){
        return rateLimiter.tryAcquire(permits,timeout,unit);
    }

    public void setRate(double permitsPerSecond){
        rateLimiter.setRate(permitsPerSecond);
    }
}
