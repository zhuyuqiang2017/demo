package top.selfhelp;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class CountLimitServiceImpl {

    private Semaphore semaphore = null;

    private long timeout;

    private TimeUnit timeUnit;

    public CountLimitServiceImpl(){
        this(Integer.MAX_VALUE);
    }

    public CountLimitServiceImpl(int count){
        this(count,false);
    }

    public CountLimitServiceImpl(int count ,boolean fair){
        this(count,fair,60,TimeUnit.MICROSECONDS);
    }

    public CountLimitServiceImpl(int count , boolean fair, long timeout, TimeUnit timeUnit){
        this.semaphore = new Semaphore(count,fair);
        this.timeout = timeout;
        this.timeUnit = timeUnit;
    }

    public void acquire() throws InterruptedException {
        if(timeout<=0){
            semaphore.acquire();
        }else{
            boolean permit = semaphore.tryAcquire(timeout,timeUnit);
            if(!permit){
                throw new InterruptedException("获取令牌超时");
            }
        }
    }

    public void release(){
        semaphore.release();
    }
}
