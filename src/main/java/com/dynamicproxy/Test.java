package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        PersonDao personDao = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        MyInterceptor myInterceptor = new MyInterceptor(personDao, transaction);
        PersonDao personProxy = (PersonDao) test.getInstance(myInterceptor.getTarget(), myInterceptor);
        personProxy.savePerson();
        System.out.println(personProxy.getClass().getName());
    }

    public Object getInstance(Object target, InvocationHandler h) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), h);
    }
}
