package top.selfhelp;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuyuqiang
 */
public class SchedulerApplication {

    private static ScheduledThreadPoolExecutor executorService;
    public static void main(String[] args){
        executorService = new ScheduledThreadPoolExecutor(2);
        System.out.println("commit task...."+",time:"+String.valueOf(System.currentTimeMillis()));
        executorService.schedule(() ->{
            System.out.println("start task...."+",time:"+String.valueOf(System.currentTimeMillis()));
            closeThreadPool();
        },10000L, TimeUnit.MILLISECONDS);
    }

    private static void closeThreadPool(){
        if(executorService != null){
            executorService.shutdownNow();
        }
    }
}
