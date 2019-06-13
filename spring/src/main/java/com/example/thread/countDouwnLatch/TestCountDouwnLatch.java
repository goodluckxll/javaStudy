package com.example.thread.countDouwnLatch;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDouwnLatch {
    @Test
    public void test() throws InterruptedException {

            // 开始的倒数锁
            final CountDownLatch begin = new CountDownLatch(1);

            // 结束的倒数锁
            final CountDownLatch end = new CountDownLatch(10);

            // 十名选手
            final ExecutorService exec = Executors.newFixedThreadPool(10);

            for (int index = 0; index < 10; index++) {
                final int NO = index + 1;
                Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 如果当前计数为零，则此方法立即返回。
                            // 等待
                            begin.await();
                            Thread.sleep((long) (Math.random() * 10000));
                            System.out.println("No." + NO + " arrived");
                        } catch (InterruptedException e) {
                        } finally {
                            // 每个选手到达终点时，end就减一
                            end.countDown();
                        }
                    }
                };
                exec.submit(run);
            }
            System.out.println("Game Start");
            // begin减一，开始游戏
            begin.countDown();
            // 等待end变为0，即所有选手到达终点
            end.await();
            System.out.println("Game Over");
            exec.shutdown();
        }
    }

