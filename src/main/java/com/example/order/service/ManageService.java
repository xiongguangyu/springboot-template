package com.example.order.service;

import java.util.List;
import java.util.Map;

import com.example.order.entity.GSysManage;
import com.example.order.exception.AddUserException;
import com.example.order.mapper.GSysManageMapper;

public interface ManageService {

    /**
     * 公告，新闻，轮播图
     * @param objId id
     * @return
     */
    GSysManage getInfo(Long objId,String type);

    List<GSysManage> getList(String type,String searchContent);

    void addInfo(GSysManage gSysManage)  throws AddUserException;

    void updateList(GSysManage gSysManage);

    void doDelete(String objId);

    boolean reviewById(Long objId,String exaId,String remark);

    /**
     * 小程序端获取首页轮播图，公告，新闻列表
     * @param type
     * @param searchContent
     * @return
     */
    List<GSysManage> getManageList(String type,String searchContent);

    /**
     * 小程序端获取首页轮播图，公告，新闻详细信息
     * @param objId
     * @param type
     * @return
     */
    GSysManage getManageInfo(Long objId,String type);
}
