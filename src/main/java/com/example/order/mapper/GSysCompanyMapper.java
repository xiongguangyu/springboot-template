package com.example.order.mapper;

import com.example.order.entity.GSysCompany;

import java.util.List;

public interface GSysCompanyMapper {

    int deleteByPrimaryKey(Long companyId);

    int insert(GSysCompany record);

    int insertSelective(GSysCompany record);

    GSysCompany selectByPrimaryKey(Long companyId);

    int updateByPrimaryKeySelective(GSysCompany record);

    int updateByPrimaryKey(GSysCompany record);

    void updateIsdelById(String objId);

    List<GSysCompany> getInfo();

    GSysCompany getList(Long objId, String type);
}