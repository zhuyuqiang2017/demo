package top.selfhelp.interfaces;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public interface RateLimitService {

    /**
     * 请求获取令牌
     * @return 成功获取令牌情况下，返回获取当前令牌等待的时间
     * @throws InterruptedException 当线程被中断或获取令牌失败，抛出线程中断异常
     */
    double acquire() throws InterruptedException;

    /**
     * 设置令牌产生的速率
     * @param permitsPerSecond 单位时间产生的令牌数
     */
    void setRate(double permitsPerSecond);
}
