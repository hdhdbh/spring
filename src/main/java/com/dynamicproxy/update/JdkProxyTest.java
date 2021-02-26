package com.dynamicproxy.update;

import com.dynamicproxy.PersonDao;
import com.dynamicproxy.PersonDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class JdkProxyTest {
    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        Logger logger = new Logger();
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(transaction);
        interceptors.add(logger);
        MyInterceptor interceptor = new MyInterceptor();
        interceptor.setInterceptors(interceptors);
        PersonDao personDao = new PersonDaoImpl();
        interceptor.setTarget(personDao);
        JdkProxyTest jdk = new JdkProxyTest();
        PersonDao proxy = (PersonDao) jdk.getInstance(interceptor.getTarget(), interceptor);
        proxy.updatePerson();

    }

    public Object getInstance(Object target, InvocationHandler h) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), h);
    }
}
