package com.example.proxy.dynamicProxy;

import com.example.proxy.dynamicProxy.impl.Man;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    @Test
    public void test(){
        IPerson man=new Man();
        InvocationHandler invocationHandler=new DynamicProxy<IPerson>(man);
        IPerson realProxy=(IPerson)Proxy.newProxyInstance(IPerson.class.getClassLoader(),new Class[]{IPerson.class},invocationHandler);
        realProxy.say();

    }
}
