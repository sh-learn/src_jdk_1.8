package com.sh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author ACER
 * @description
 * @date 2019/3/31 21:27
 */
public class Handler implements InvocationHandler {
    private Object target;

    public Handler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //before
        System.out.println("before do something");
        Object result = method.invoke(target, args);
        //after
        System.out.println("after do something");
        //return what you want
        return result;
    }
}
