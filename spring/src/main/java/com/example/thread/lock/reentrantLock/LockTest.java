package com.example.thread.lock.reentrantLock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private String shareName="SHARENAME";
    private final Lock lock=new ReentrantLock();
    public void updateShareName(String value){
        lock.lock();
        try{
            System.out.println("当前线程的名字:"+Thread.currentThread().getName());
            System.out.println("shareName is :"+shareName);
            this.setShareName(value);
            System.out.println("修改之后的shareName is :"+shareName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }
    @Test
    public void test() throws InterruptedException {
        LockTest lockTest=new LockTest();
        Thread t1=new Thread(new ExecuteRunable(lockTest));
        Thread t2=new Thread(new ExecuteRunable(lockTest));
        Thread t3=new Thread(new ExecuteRunable(lockTest));
        Thread t4=new Thread(new ExecuteRunable(lockTest));
        t1.setName("A");
        t2.setName("B");
        t3.setName("C");
        t4.setName("D");
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
    }

    class ExecuteRunable implements Runnable{
        private LockTest lockTest;
        public ExecuteRunable(LockTest lockTest){
            this.lockTest=lockTest;
        }

        @Override
        public void run() {
            System.out.println(lockTest.getShareName());
            lockTest.updateShareName(Thread.currentThread().getName());

        }
    }

}
