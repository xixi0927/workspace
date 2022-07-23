package com.xixi.Thread;

/**
 * @author 孟凡喜
 * @version 1.0.0
 * @ClassName TestRunnable.java
 * @createTime 2022年07月16日 16:51
 */
public class TestRunnable {
    public static void main(String[] args) {

        HelloRunnable hello =new HelloRunnable();
        Thread t = new Thread(hello);
        t.start();


        for (int j = 0; j < 10; j++) {
            System.out.print("j="+j+"\t");
        }
        System.out.println();
    }

}

class HelloRunnable implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.print("i="+i+"\t");
        }
        System.out.println();
    }
}