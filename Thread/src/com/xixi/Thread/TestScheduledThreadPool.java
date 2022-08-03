package com.xixi.Thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: TestScheduledThreadPool
 * @Author: macbook-xi
 * @Date: 2022/7/29
 * @Description: 周期性执行的线程调度
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("=================");
            }
        },1000,5000, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.nanoTime());
            }
        },1000,2000,TimeUnit.MILLISECONDS);

    }
}
