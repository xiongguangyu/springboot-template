package com.example.order.service;

import com.example.order.entity.GSysCompany;
import com.example.order.exception.AddUserException;

import java.util.List;

public interface CompanyService {

    /**
     * 公告，新闻，轮播图
     * @param objId id
     * @return
     */
    GSysCompany getList(Long objId,String type);

    List<GSysCompany> getInfo();

    void addInfo(GSysCompany gSysManage)  throws AddUserException;

    void updateList(GSysCompany gSysManage);

    void doDelete(String companyId);
}
