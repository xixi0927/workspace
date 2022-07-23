package com.xixi.Thread;

//sleep(time)：使当前线程进入睡眠模式（暂停指定的时间，单位为毫秒）
public class TestSleep {

    public static void main(String[] args) throws InterruptedException {
/*        Printer p = new Printer();
        Thread t = new Thread(p);
        t.start();

        Thread.sleep(1000);

        System.out.println("main线程自动唤醒");

        //唤醒正在睡眠状态中的线程
        t.interrupt();*/

        PrintThread pt = new PrintThread();
        Thread t = new Thread();
        t.start();
        for (int j = 0; j < 10; j++) {
            System.out.println();
        }

    }
}

class PrintThread implements Runnable{



    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("时间未到，但被唤醒。。。");
            }
            System.out.println("i+"+i+"\t");

        }
    }
}

class Printer implements Runnable{

    @Override
    public void run() {
        try{
            Thread.sleep(10000);   //睡眠100秒
        } catch (InterruptedException e) {
            System.out.println("被强制唤醒");

        }

        for (int i = 0; i < 10; i++) {
            System.out.println("i="+i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("1秒都不让睡");
            }
        }
    }
}
