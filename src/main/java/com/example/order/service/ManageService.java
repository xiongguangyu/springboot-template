package com.example.order.service;

import java.util.List;
import com.example.order.entity.GSysManage;
import com.example.order.exception.AddUserException;
import com.example.order.mapper.GSysManageMapper;

public interface ManageService {

    /**
     * 公告，新闻，轮播图
     * @param objId id
     * @return
     */
    GSysManage getList(Long objId,String type);

    List<GSysManage> getInfo(String type);

    void addInfo(GSysManage gSysManage)  throws AddUserException;

    void updateList(GSysManage gSysManage);
}
