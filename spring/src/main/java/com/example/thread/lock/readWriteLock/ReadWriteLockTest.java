package com.example.thread.lock.readWriteLock;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    private final ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    private final Lock readLock= readWriteLock.readLock();
    private final Lock writeLock= readWriteLock.writeLock();
    @Getter
    @Setter
    private String shareName="SHARENAME";
    public void reader(){
        readLock.lock();
        try{
            System.out.println("当前读线程名字:"+Thread.currentThread().getName());
            System.out.println("共享变量:"+this.getShareName());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }
    public void writer(){
        writeLock.lock();
        try{
            //修改共享变量
            System.out.println("当前写线程名字:"+Thread.currentThread().getName());
            this.setShareName(Thread.currentThread().getName());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }

    }
    @Test
    public void test() throws InterruptedException {
        ReadWriteLockTest readWriteLockTest=new ReadWriteLockTest();
        Thread r1=new Thread(new ExecuteRunable(readWriteLockTest));
        r1.setName("read-1");
        Thread r2=new Thread(new ExecuteRunable(readWriteLockTest));
        r2.setName("read-2");
        Thread r3=new Thread(new ExecuteRunable(readWriteLockTest));
        r3.setName("read-3");
        Thread w1=new Thread(new ExecuteRunable(readWriteLockTest));
        w1.setName("write-1");
        Thread w2=new Thread(new ExecuteRunable(readWriteLockTest));
        w2.setName("write-2");
        Thread w3=new Thread(new ExecuteRunable(readWriteLockTest));
        w3.setName("write-3");
        r1.start();
        w1.start();
        r1.join();
        w1.join();
        r2.start();
        w2.start();
        r2.join();
        w2.join();
        r3.start();
        w3.start();
        r3.join();
        w3.join();

    }
    @Test
    public void test2(){
        System.out.println(Runtime.getRuntime().availableProcessors());

    }

    class ExecuteRunable implements Runnable{
        private ReadWriteLockTest readWriteLockTest;
        public ExecuteRunable(ReadWriteLockTest readWriteLockTest){
            this.readWriteLockTest=readWriteLockTest;
        }

        @Override
        public void run() {
            if(Thread.currentThread().getName().contains("read")){
                readWriteLockTest.reader();
            }else{
                readWriteLockTest.writer();
            }

        }
    }
}
