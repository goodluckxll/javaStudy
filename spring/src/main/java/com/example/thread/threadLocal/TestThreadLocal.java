package com.example.thread.threadLocal;

import org.junit.Test;

public class TestThreadLocal {
    private final static ThreadLocal<Integer> threadLocalCount=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return Integer.valueOf(0);
        }

    };

    @Test
    public void test() throws InterruptedException {
        Thread a=new Thread(new ABC());
        Thread b=new Thread(new ABC());
        Thread c=new Thread(new ABC());
        a.setName("A");
        b.setName("B");
        c.setName("C");
        a.start();
        b.start();
        c.start();
        a.join();
        b.join();
        c.join();


    }
    class ABC implements Runnable{

        @Override
        public void run() {
            if("A".equalsIgnoreCase(Thread.currentThread().getName())){
                threadLocalCount.set(Integer.valueOf(2));
            }else if("B".equalsIgnoreCase(Thread.currentThread().getName())){
                threadLocalCount.set(Integer.valueOf(4));
            }else{
                threadLocalCount.set(Integer.valueOf(6));
            }
            int count=threadLocalCount.get();
            for(int i=0;i<count;i++){
                System.out.println(Thread.currentThread().getName()+" :"+i);
            }

        }
    }
}
