package com.yiban.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class Md5Utils {

    private Logger logger = LoggerFactory.getLogger(Md5Utils.class);

    private static final String salt = "ZQUYiBanJiShuBu666666";

    public String key(String yibanId) {
        String key = yibanId+'/'+salt;
        String md5 = DigestUtils.md5DigestAsHex(key.getBytes());
        logger.info("md5µÄÖµ£º{}", md5);
        return md5;
    }
}
