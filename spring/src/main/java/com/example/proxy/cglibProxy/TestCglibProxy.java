package com.example.proxy.cglibProxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class TestCglibProxy {
    @Test
    public void say(){
        //字节码增强器
        Enhancer enchancer = new Enhancer();
        //设置被代理类为父类
        enchancer.setSuperclass(Person.class);
        //设置回调
        enchancer.setCallback(new ProxyInterceptor());
        //创建代理实例
        Person proxy = (Person)enchancer.create();
        proxy.say();
    }
}
