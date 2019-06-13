package com.example.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy<T> implements InvocationHandler {
    //目标对象
    private T target;
    public DynamicProxy(T target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy....begin");
        Object result=method.invoke(target, args);
        System.out.println("dynamic proxy....end");
        return result;
    }
}
