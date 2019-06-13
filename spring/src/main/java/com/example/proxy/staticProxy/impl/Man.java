package com.example.proxy.staticProxy.impl;

import com.example.proxy.staticProxy.IPerson;

public class Man implements IPerson {
    @Override
    public void say() {
        System.out.println("I am Man....");
    }
}
