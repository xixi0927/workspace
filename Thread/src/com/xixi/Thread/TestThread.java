package com.xixi.Thread;

/**
 * @author 孟凡喜
 * @version 1.0.0
 * @ClassName TestThread.java
 * @createTime 2022年07月16日 16:38
 */
public class TestThread {
    public static void main(String[] args) {
        
        //创建线程对象
        Thread t = new HelloThread();
        //t.run(); //多线程启动不能调用run（）方法
        t.start();//线程启动只能调用start()方法
        
        for (int j = 0; j < 10; j++) {
            System.out.print("j="+j+"\t");
        }
        System.out.println();
    }
}


class HelloThread extends  Thread{

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.print("i="+i+"\t");
        }
        System.out.println();
    }
}