package com.cosplay.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Lazy(true)//使用懒加载
@Scope("prototype")
public class Controller1 {
    @Resource(name = "service")
    private Service service;

    public Controller1() {
        System.out.println("Controller1创建...........");
    }

    public void web() {
        System.out.println("控制层调用服务层");
        service.service();
    }
}
