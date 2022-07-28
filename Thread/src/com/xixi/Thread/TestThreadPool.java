package com.xixi.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: TestThreadPool
 * @Author: macbook-xi
 * @Date: 2022/7/29
 * @Description: 线程池
 */
public class TestThreadPool {
    public static void main(String[] args) {
    /*
    * Executor: 所有线程池的顶级接口
    *
    * ExecutrorService:线程池接口，可通过submit(Runnable task) 提交任务
    *
    * Executors:线程池工厂类
    * */

//        1.缓存线程池，线程数量由任务数量决定 (比较常用)
   ExecutorService es = Executors.newCachedThreadPool();


//        2.固定线程池，线程池中的线程对象的数量是固定的
//        ExecutorService es = Executors.newFixedThreadPool(3);

//        3.单线程池
//        ExecutorService es = Executors.newSingleThreadExecutor();

//        4.调度线程池
//          ExecutorService es =  Executors.newScheduledThreadPool(3);


        Runnable runnable = new Runnable() {
            private int ticket = 100;
            @Override
            public void run() {
                while(true){
                    if(ticket <= 0){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+"买了第"+ticket+"张票");
                    ticket--;
                }
            }
        };

        //提交任务
        for (int i = 0; i < 5; i++) {
            es.submit(runnable);
        }

        //关闭线程池
        es.shutdown();  //等待所有任务执行完毕之后关闭线程池，不再接受新任务。

    }
}
