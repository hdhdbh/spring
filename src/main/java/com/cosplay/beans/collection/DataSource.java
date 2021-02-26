package com.cosplay.beans.collection;

import java.util.Properties;

public class DataSource {
    private Properties properties;

    public DataSource(Properties properties) {
        this.properties = properties;
    }

    public DataSource() {
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
