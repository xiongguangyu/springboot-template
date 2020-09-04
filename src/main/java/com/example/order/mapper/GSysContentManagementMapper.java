package com.example.order.mapper;

import com.example.order.entity.GSysContentManagement;
import org.springframework.stereotype.Component;

@Component
public interface GSysContentManagementMapper {

    int insertSelective(GSysContentManagement record);

    GSysContentManagement selectByPrimaryKey(Long contentId);

    int updateByPrimaryKeySelective(GSysContentManagement record);

}