package com.example.proxy.dynamicProxy.impl;

import com.example.proxy.dynamicProxy.IPerson;

public class Man implements IPerson {
    @Override
    public void say() {
        System.out.println("I am Man");
    }
}
