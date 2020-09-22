package com.example.order.mapper;

import com.example.order.entity.GSysManage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface GSysManageMapper {

    GSysManage getInfo(Long objId,String type);

    List<GSysManage> getList(String type,String searchContent);

    int deleteByPrimaryKey(Long objId);

    int insert(GSysManage record);

    int insertSelective(GSysManage gSysManage);

    int updateByPrimaryKey(GSysManage record);

    void updateByPrimaryKeySelective(GSysManage gSysManage);

    void updateIsdelByOId(String objId);

    List<GSysManage> getManageList(@Param("type") String type, @Param("searchContent") String searchContent);
}