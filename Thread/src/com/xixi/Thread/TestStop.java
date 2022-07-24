package com.xixi.Thread;

public class TestStop {

    public static void main(String[] args) {
        ThreadStop ts = new ThreadStop();
        Thread t = new Thread(ts);
        t.start();

        //如果main线程输出值30以后，t线程结束运行
        for (int j = 0; j < 100; j++) {
            System.out.print("j="+j+"\t");
            if(j >= 30){
                break;
            }
        }

        ts.setStopFlag(true);

    }
}


class ThreadStop implements Runnable{

    private int i ;
    private boolean stopFlag = false;

    public void setStopFlag(boolean stopFlag){
        this.stopFlag= stopFlag;
    }

    @Override
    public void run() {
        while(!stopFlag){
            System.out.print("i="+i+"\t");
            i++;
            if(i> 500){
                i = 0;
            }
        }
    }
}