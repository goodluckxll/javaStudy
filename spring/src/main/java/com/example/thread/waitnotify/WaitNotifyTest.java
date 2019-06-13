package com.example.thread.waitnotify;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

public class WaitNotifyTest {
    private boolean flag = true;

    public synchronized void shareMethod() {
        System.out.println(Thread.currentThread().getName()+"已经获取锁");
        while (flag && !Thread.currentThread().getName().contains("ab")) {
            try {
                System.out.println(Thread.currentThread().getName()+"被执行wait()....放弃锁，等待通知");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName()+"准备通知...");
        flag = false;
        notify();
    }
    @Test
    @Transactional
    public void test() throws InterruptedException {
        WaitNotifyTest waitNotifyTest=new WaitNotifyTest();
        Thread t1=new Thread(new ABC( waitNotifyTest));
        t1.setName("1");
        Thread t2=new Thread(new ABC( waitNotifyTest));;
        t2.setName("2");
        Thread t3=new Thread(new ABC( waitNotifyTest));;
        t3.setName("ab");
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(10000);

    }


    class ABC implements Runnable{
        private WaitNotifyTest waitNotifyTest;
        public ABC(WaitNotifyTest waitNotifyTest){
            this.waitNotifyTest=waitNotifyTest;

        }

        @Override
        public void run() {
            waitNotifyTest.shareMethod();

        }
    }

}
