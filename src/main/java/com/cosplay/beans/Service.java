//package com.cosplay.beans;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Service {
//    public static  final Logger LOGGER = LoggerFactory.getLogger(Service.class);
//    private Dao mapper;
//
//    public Service() {
//    }
//
//    public Dao getDao() {
//        return mapper;
//    }
//
//    public void setDao(Dao mapper) {
//        this.mapper = mapper;
//    }
//
//    public Service(Dao mapper) {
//        this.mapper = mapper;
//    }
//
//    public void serrvice(){
//        LOGGER.debug("服务层....");
//        mapper.mapper();
//    }
//}
package com.cosplay.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

@org.springframework.stereotype.Service
@Lazy(true)
public class Service {
    @Autowired
    @Qualifier("dao")
    private Dao dao;

//    @Autowired
//    public void setDao(@Qualifier("mapper") Dao mapper) {
//        this.mapper = mapper;
//    }

    public Service() {
        System.out.println("service被创建");
    }

    public void service() {
        System.out.println("服务层调用数据层");
        dao.dao();
    }
}