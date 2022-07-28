package com.xixi.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: TestReadWritLock
 * @Author: macbook-xi
 * @Date: 2022/7/24
 * @Description: 锁
 */
public class TestReadWritLock {
    public static void main(String[] args) {
        ReadWritLock rwl = new ReadWritLock();
        ExecutorService es = Executors.newFixedThreadPool(20);

        Runnable read = new Runnable() {
            @Override
            public void run() {
                rwl.getVal();
            }
        };

        Runnable writ = new Runnable() {
            @Override
            public void run() {
                rwl.setVal("张三");
            }
        };

        for (int i = 0; i < 2; i++) {
            es.submit(writ);
        }
        for (int i = 0; i < 18; i++) {
            es.submit(read);
        }
        es.shutdown();
    }
}


class ReadWritLock {
    //为了防止脏数据的产生，JDK提供了读写锁
/*    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock(); //读写锁
    private ReentrantReadWriteLock.ReadLock readLock = rwlock.readLock();   //根据读写锁对象获取读锁
    private ReentrantReadWriteLock.WriteLock writeLock = rwlock.writeLock();    //根据读写锁对象获取写锁*/

    private ReentrantLock lock = new ReentrantLock();

    private String val;
    public String getVal() {
      //  readLock.lock(); //加锁
        lock.lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("val+" + val);
            return this.val;
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
           // readLock.unlock();  //解锁
            lock.unlock();
        }
        return "";
    }


    public void setVal(String val){
       // writeLock.lock();
        lock.lock();
        try{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Write"+val);
            this.val = val;
        }finally {
          //  writeLock.unlock();
            lock.unlock();
        }
    }

}