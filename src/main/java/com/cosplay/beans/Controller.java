package com.cosplay.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.stereotype.Controller
public class Controller {
    public static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    //    @Resource(name = "service")
    private Service service;

    public Service getService() {
        return service;
    }

    //@Resource(name = "service")
    public void setService(Service service) {
        this.service = service;
    }

    //    @Autowired
//    public Controller(@Qualifier("service") Service service){
//        this.service = service;
//    }
    public void controller() {
        LOGGER.debug("控制层");
        service.service();
    }

    public void web() {
        LOGGER.debug("控制层调用服务层");
        service.service();
    }
}
