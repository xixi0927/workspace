package com.xixi.Thread;

public class TestJoin {
    public static void main(String[] args) {
        TestPrint test = new TestPrint("线程一");
        Thread t =new Thread(test);
        t.start();

        TestTh th = new TestTh("线程二");
        Thread t2 = new Thread(th);
        t2.start();

        //线程合并：线程二必须在main线程之前执行
        try {
            t2.join();   //将当前线程（Main）合并至指定的线程（线程二）后执行
        } catch (InterruptedException e) {   //线程唤醒异常
            e.printStackTrace();

        }


        for (int i = 0; i < 10; i++) {
            System.out.println("Main"+i+"  ");
        }
    }

}

class TestPrint implements Runnable{

    private String name;
    public TestPrint(String name){
        this.name = name;

    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name+":"+i+"  ");
        }
    }
}




class TestTh implements Runnable{
    private String name;
    public TestTh(String name){
        this.name=name;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name+":"+i+"  ");
        }
    }
}