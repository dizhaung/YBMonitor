package com.yiban.mapper;

import com.yiban.entity.MsgUser;

public interface MsgUserMapper {
    int deleteByPrimaryKey(String yibanId);

    int insert(MsgUser record);

    int insertSelective(MsgUser record);

    MsgUser selectByPrimaryKey(String yibanId);

    int updateByPrimaryKeySelective(MsgUser record);

    int updateByPrimaryKey(MsgUser record);
}