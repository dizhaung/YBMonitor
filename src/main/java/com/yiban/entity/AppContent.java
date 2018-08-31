package com.yiban.entity;

import com.yiban.exception.DataLossException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Éµ±Æ on 2018/1/24.
 */
public class AppContent {

    public static final String appKey;
    public static final String appSecret ;
    public static final String callbackUrl;
    static {
        Resource resource = new ClassPathResource("appContent.properties");
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            throw new DataLossException("appContent.properties import exception");
        }
        appKey = properties.getProperty("appKey");
        appSecret = properties.getProperty("appSecret");
        callbackUrl = properties.getProperty("callbackUrl");
    }
}
