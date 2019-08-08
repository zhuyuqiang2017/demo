package top.selfhelp.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import top.selfhelp.interfaces.PerTimeCountLimitService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class PerTimeCountLimitServiceImpl implements PerTimeCountLimitService {

    private volatile LoadingCache<Long, AtomicLong> counter = null;


    private long permits = 50L;

    private TimeUnit unit;

    private volatile AtomicLong numberChecker = new AtomicLong(0);

    public PerTimeCountLimitServiceImpl(long permits, long duration, TimeUnit unit) {
        counter = CacheBuilder.newBuilder()
                .expireAfterWrite(duration, unit)
                .build(new CacheLoader<Long, AtomicLong>() {
                    @Override
                    public AtomicLong load(Long seconds) throws Exception {
                        return numberChecker;
                    }
                });
        this.permits = permits;
        this.unit = unit;
    }

    @Override
    public boolean isPermitted(long time) throws ExecutionException {
        System.out.println("当前数量："+counter.get(getValidTime(time)).get());
        return counter.get(getValidTime(time)).getAndIncrement() <= permits;
    }

    private long getValidTime(long time) {
        switch (unit) {
            case DAYS:
                return unit.toDays(time);
            case HOURS:
                return unit.toHours(time);
            case MINUTES:
                return unit.toMinutes(time);
            case MILLISECONDS:
                return unit.toMillis(time);
            case MICROSECONDS:
                return unit.toMicros(time);
            case NANOSECONDS:
                return unit.toNanos(time);
            default:
                return unit.toSeconds(time);
        }
    }
}
