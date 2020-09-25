package com.example.order.mapper;

import com.example.order.entity.GSysEvaluate;
import org.springframework.stereotype.Component;

@Component
public interface GSysEvaluateMapper {

    int insertSelective(GSysEvaluate record);

    GSysEvaluate selectByPrimaryKey(Long evaluateId);

    int updateByPrimaryKeySelective(GSysEvaluate record);
}