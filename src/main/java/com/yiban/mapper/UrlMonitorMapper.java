package com.yiban.mapper;

import com.yiban.entity.UrlMonitor;

public interface UrlMonitorMapper {
    int deleteByPrimaryKey(Integer urlId);

    int insert(UrlMonitor record);

    int insertSelective(UrlMonitor record);

    UrlMonitor selectByPrimaryKey(Integer urlId);

    int updateByPrimaryKeySelective(UrlMonitor record);

    int updateByPrimaryKey(UrlMonitor record);
}