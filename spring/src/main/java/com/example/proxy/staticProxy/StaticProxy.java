package com.example.proxy.staticProxy;

public class StaticProxy implements IPerson{
    private IPerson iPerson;
    public StaticProxy(IPerson iPerson){
        this.iPerson=iPerson;
    }
    @Override
    public void say() {
        System.out.println("staticProxy.......begin");
        iPerson.say();
        System.out.println("staticProxy.......end");

    }
}
