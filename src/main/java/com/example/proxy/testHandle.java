package com.example.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class testHandle implements InvocationHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(testHandle.class);

    private Object target;

    public testHandle(Class clazz) {
        try {
            this.target = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        LOGGER.info("handle before");
    }

    private void after() {
        LOGGER.info("handle after");
    }


    public  static  void main(String[] args) throws Exception{
      home test =  (home) Proxy.newProxyInstance(testHandle.class.getClassLoader(),new Class[]{home.class}, new testHandle(test.class));
      test.test();
    }
}
