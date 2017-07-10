package com.sunny.bugmanage.common.mapper;

import com.sunny.bugmanage.common.model.BaseModel;

import java.io.Serializable;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.mapper.BaseMapper
 * @date 2017-07-10 11:50
 * @description:
 */
public interface BaseMapper<T extends BaseModel<ID>, ID extends Serializable> {
    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
