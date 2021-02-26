package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInterceptor implements InvocationHandler {
    private Object target;//潘金莲 西门庆
    private Transaction transaction;

    public MyInterceptor(Object target, Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();//获取执行方法名称
        if ("savePerson".equals(methodName) || "updatePerson".equals(methodName)) {
            System.out.println(method.getDeclaringClass().getName());
            this.transaction.beginTransaction();
            method.invoke(target, args);//通过java反射去执行方法
            this.transaction.commit();
        }
        return null;
    }
}
