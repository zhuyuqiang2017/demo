package top.selfhelp;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class RateLimitServiceImpl {

    private RateLimiter rateLimiter = null;

    private long timeout = 0L;

    private TimeUnit timeUnit = TimeUnit.SECONDS;

    private static double PERMITS_PER_SECOND = 1D;

    public RateLimitServiceImpl(){
        this(PERMITS_PER_SECOND,0L,TimeUnit.SECONDS);
    }

    public RateLimitServiceImpl(double permitsPerSecond,long timeout,TimeUnit timeUnit){
        this.rateLimiter = RateLimiter.create(permitsPerSecond);
        this.timeout = timeout;
        this.timeUnit = timeUnit;
    }

    public RateLimitServiceImpl(double permitsPerSecond,long warmupPeriod, TimeUnit unit ,long timeout,TimeUnit timeUnit){
        this.rateLimiter = RateLimiter.create(permitsPerSecond,warmupPeriod,unit);
        this.timeout = timeout;
        this.timeUnit = timeUnit;
    }

    public double acquire() throws InterruptedException {
        long start = System.currentTimeMillis();
        if(timeout<=0){
            return rateLimiter.acquire(1);
        }else{
            boolean result = rateLimiter.tryAcquire(1,timeout,timeUnit);
            if(!result){
                throw new InterruptedException("获取令牌超时");
            }
            return timeUnit.toSeconds(System.currentTimeMillis()-start);
        }
    }

    public void setRate(double permitsPerSecond){
        rateLimiter.setRate(permitsPerSecond);
    }
}
