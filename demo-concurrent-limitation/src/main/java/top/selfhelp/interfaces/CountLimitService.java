package top.selfhelp.interfaces;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public interface CountLimitService {

    /**
     * 请求获取锁，未有效获取锁时，阻塞当前线程的执行
     * @throws InterruptedException 当线程被中断或获取锁失败，抛出线程中断异常
     */
    void acquire() throws InterruptedException;

    /**
     * 释放当前线程获取的锁
     */
    void release();
}
