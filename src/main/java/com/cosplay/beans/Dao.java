package com.cosplay.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class Dao {
    public static final Logger LOGGER = LoggerFactory.getLogger(Dao.class);

    public void dao() {
        LOGGER.debug("数据层....");
    }
}
