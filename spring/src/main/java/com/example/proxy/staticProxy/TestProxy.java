package com.example.proxy.staticProxy;

import com.example.proxy.staticProxy.impl.Man;
import org.junit.Test;

public class TestProxy {
    @Test
    public void test(){
        IPerson iPerson=new Man();
        IPerson staticProxy=new StaticProxy(iPerson);
        staticProxy.say();

    }
}
