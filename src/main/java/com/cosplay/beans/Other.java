package com.cosplay.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class Other {
    public static final Logger LOGGER = LoggerFactory.getLogger(Other.class);

    public Other() {
        LOGGER.debug("实例化对象other");
    }

    @PostConstruct
    public void init() {
        LOGGER.debug("调用初始化方法");
    }

    @PreDestroy
    public void destroy() {
        LOGGER.debug("调用销毁方法");
    }
}
