package top.selfhelp;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class PerTimeCountLimitServiceImpl {

    private LoadingCache<Long, AtomicLong> counter = null;


    private long permits = 50L;

    private TimeUnit unit;

    public PerTimeCountLimitServiceImpl(long permits, long duration, TimeUnit unit) {
        counter = CacheBuilder.newBuilder()
                .expireAfterWrite(duration, unit)
                .build(new CacheLoader<Long, AtomicLong>() {
                    @Override
                    public AtomicLong load(Long seconds) throws Exception {
                        return new AtomicLong(0);
                    }
                });
        this.permits = permits;
        this.unit = unit;
    }

    public boolean isPermitted(long time) throws ExecutionException {
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
