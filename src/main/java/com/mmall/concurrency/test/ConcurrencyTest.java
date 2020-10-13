package com.mmall.concurrency.test;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author wucf
 * @description 大概描述所属模块和介绍
 * @date 2020-10-12 15:35
 **/
@Slf4j
@NotThreadSafe
public class ConcurrencyTest {
    //请求总数
    public  static int  clientCount=1000;
    //并发数
    public   static  int ThreadCount=50;

    public   static int count =0;




    public static void main(String[] args) throws InterruptedException {
        ExecutorService  executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore =new Semaphore(ThreadCount);
        final CountDownLatch countDownLatch=new CountDownLatch(clientCount);
        for(int i=0;i<clientCount;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });

        }
        countDownLatch.await();
        executorService.shutdown();
        log.info(String.valueOf(count));





    }

    private static void add() {
        count++;
    }
}
