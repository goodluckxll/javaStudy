package com.example.thread.lock.singleton;

public class Single1 {
    private static Single1 ourInstance = new Single1();

    public static Single1 getInstance() {
        return ourInstance;
    }

    private Single1() {
    }
}
