package com.xixi.Thread;

/**
 * @ClassName: TestProducterConsumer
 * @Author: macbook-xi
 * @Date: 2022/7/24
 * @Description: 生产者与消费者问题
 * 共享数据的不一致性，对象锁的概念
 * synchronized，wait(),notify()
 */
public class TestProducterConsumer {
    public static void main(String[] args) {
        Counters counters = new Counters();
        Producter producter = new Producter(counters);
        Consumer consumer = new Consumer(counters);
        Thread pt = new Thread(producter);
        Thread ct = new Thread(consumer);
        pt.start();
        ct.start();

    }
}

class Counters {
    private int count;   //当前拥有的产品数量

    public synchronized  int increase(int n ){
        count +=n; //生产出的产品数量
        this.notify();  //通知处于等待状态的线程（唤醒处于等待状态的消费者线程）
        System.out.println("生产了："+n+"，总数"+count);
        return count;
    }

    public synchronized  int decrease(int n){
        while(count < n ){     //如果消费的数量小于已有的产品数量
            try {
                this.wait();  //进入等待状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count -=n;
        System.out.println("消费了："+n+",剩余数量"+count);
        return  count;
    }



}

//生产类
class Producter implements Runnable{
    private Counters counters;    //共享数据/资源

    public Producter(Counters counters){
        this.counters = counters;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            counters.increase((int)(Math.random()*10));
            try {
                Thread.sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者类
class Consumer implements Runnable{

    private Counters counters;

    public Consumer(Counters counters){
        this.counters = counters;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            counters.decrease((int)(Math.random()*8));
            try {
                Thread.sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}