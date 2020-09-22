package com.example.order.mapper;

import com.example.order.entity.GSysManage;

import java.util.List;

public interface GSysManageMapper {

    GSysManage getList(Long objId,String type);

    List<GSysManage> getInfo(String type);

    int deleteByPrimaryKey(Long objId);

    int insert(GSysManage record);

    int insertSelective(GSysManage gSysManage);

    int updateByPrimaryKey(GSysManage record);

    void updateByPrimaryKeySelective(GSysManage gSysManage);

    void updateIsdelByOId(String objId);

    GSysManage selectByPrimaryKey(Long objId);
}