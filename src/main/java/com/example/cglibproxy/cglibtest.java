package com.example.cglibproxy;

import com.example.proxy.test;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class cglibtest  implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======插入前置通知======");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("======插入后置通知======");
        return object;
    }
    public  static  void main(String[] args) throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(test.class);
        enhancer.setCallback(new cglibtest());
        test test = (test)enhancer.create();
        test.test();
    }


}