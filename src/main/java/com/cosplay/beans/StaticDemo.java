package com.cosplay.beans;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StaticDemo {
    private static Dao dao;//不能在静态属性上直接注入

    @Resource(name = "dao")
    public void setter(Dao dao) {
        StaticDemo.dao = dao;
    }

    public void test() {
        dao.dao();
    }
}
