package com.dynamicproxy.update;

public interface Interceptor {
    void before();//执行前作什么事情

    void after();//执行后做什么事
}
