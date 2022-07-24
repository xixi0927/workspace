package com.xixi.Thread;

/**
 * @ClassName: TestCounter
 * @Author: macbook-xi
 * @Date: 2022/7/24
 * @Description: 有一个线程类，生命变量conuter,初始值为200
 *               在run方法中循环50次，每次对counter做-2的操作，睡眠10毫秒，并打印counter的值
 *               在测试类的main方法中，创建counter实例，并启动一个线程，观察counter值
 *
 *               在main方法中利用已有的counter实例对象创建第二个线程并启动，两个线程同时启动，观察count的值
 *
 */
public class TestCounter {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t = new Thread(counter);
        Thread t2 = new Thread(counter);
        t.start();
        t2.start();
    }



}


class Counter implements Runnable{

    private  int count = 200; //两个线程的共享数据

    public synchronized void print(){
        for (int i = 0; i < 50; i++) {
            count-=2;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(count+"\t");

        }
    }

    @Override
    public void run() {
        //在多线程中，设计一个共享数据的数据安全
        synchronized (this) {
            for (int i = 0; i < 50; i++) {
                count -= 2;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(count + "\t");

            }
        }
      //  this.print();
    }
}