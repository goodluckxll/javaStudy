package com.example.proxy.cglibProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class ProxyInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib.....begin");
        Object object =  methodProxy.invokeSuper(o,objects);
        System.out.println("cglib.....end");
        return object;
    }
}
