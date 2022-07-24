package com.xixi.Thread;

/**
 * @ClassName: TestDeadLock
 * @Author: macbook-xi
 * @Date: 2022/7/24
 * @Description: 死锁问题
 */
public class TestDeadLock {
    public static void main(String[] args) {
        DeadLockDemo td1 = new DeadLockDemo();
        DeadLockDemo td2 = new DeadLockDemo();
        td1.flag = 0;
        td2.flag = 1 ;
        Thread t = new Thread(td1);
        Thread t2 = new Thread(td2);
        t.start();
        t2.start();

    }
}
class DeadLockDemo implements Runnable{

    public  int flag = 1;
    static Object o1 =new Object(),o2 = new  Object();

    @Override
    public void run() {
        System.out.println("flag="+flag);
        if(flag ==1){
            synchronized (o1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){ //已锁定o1的情况下，在锁定o2
                    System.out.println("1");
                }
            }



        }

        if(flag == 0 ){
            synchronized (o2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){ //已锁定o2的情况下，在锁定o1
                    System.out.println("0");
                }
            }
        }
    }
}
