package com.example.config;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private final Properties properties = new Properties();

    public Configuration() {
        try (InputStream is = getClass().getClassLoader()
                .getResourceAsStream("application.properties")) {
            properties.load(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getServerUrl() {
        return properties.getProperty("server.url");
    }

    public int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}
