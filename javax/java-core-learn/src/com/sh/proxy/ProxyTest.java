package com.sh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ACER
 * @description
 * @date 2019/3/31 21:31
 */
public class ProxyTest {
    public static void main(String[] args) {
        Action action = new ActionImpl();
        InvocationHandler handler = new Handler(action);
        Action actionProxy = (Action) Proxy.newProxyInstance(action.getClass().getClassLoader(), new Class[]{Action.class}, handler);
        actionProxy.doSomething();
    }
}
