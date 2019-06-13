package com.example.thread.threadPoolExecutor;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class TestThreadPoolExecutor {
    @Test
    public void test() throws InterruptedException {
        BlockingQueue<Runnable> blockingQueue=new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(2,6,60, TimeUnit.SECONDS,blockingQueue, new ThreadPoolExecutor.DiscardPolicy());
        for(int i=0;i<50;i++){
            blockingQueue.offer(new ABC(i+""));
        }
        threadPoolExecutor.prestartAllCoreThreads();
        threadPoolExecutor.execute(blockingQueue.poll());
        Thread.sleep(100000);
    }

    class ABC implements Runnable{
        private String name;
        public ABC(String name){
            this.name=name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  :"+name);

        }
    }
}
