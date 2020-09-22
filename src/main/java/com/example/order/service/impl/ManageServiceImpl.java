package com.example.order.service.impl;

import com.example.order.entity.GSysUser;
import com.example.order.exception.AddUserException;
import com.example.order.mapper.GSysManageMapper;
import com.example.order.service.ManageService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.order.entity.GSysManage;

import java.util.Date;
import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    protected static final Logger logger = LoggerFactory.getLogger(ManageServiceImpl.class);

    @Autowired
    private GSysManageMapper  gSysManageMapper;

    @Override
    public GSysManage getList(@Param("objId")Long objId,@Param("type")String type) {
        return gSysManageMapper.getList(objId,type);

    }

    @Override
    public List<GSysManage> getInfo(@Param("type")String type,@Param("searchContent")String searchContent) {
        return gSysManageMapper.getInfo(type,searchContent);

    }

    @Override
    public void addInfo(GSysManage gSysManage) throws AddUserException {
        try {
            gSysManageMapper.insertSelective(gSysManage);
        } catch (Exception e) {
            logger.error("新增失败!");
            throw new AddUserException("新增失败");
        }
    }

    @Override
    public void updateList(GSysManage gSysManage) {
        try {
            gSysManageMapper.updateByPrimaryKeySelective(gSysManage);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }


    @Override
    public void doDelete(String objId) {
        try {
            gSysManageMapper.updateIsdelByOId(objId);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }
}
