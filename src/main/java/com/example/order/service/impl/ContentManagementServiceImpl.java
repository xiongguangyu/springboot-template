package com.example.order.service.impl;

import com.example.order.entity.GSysContentManagement;
import com.example.order.mapper.GSysContentManagementMapper;
import com.example.order.service.ContentManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentManagementServiceImpl implements ContentManagementService {

    protected static final Logger logger = LoggerFactory.getLogger(ExhibitionServiceImpl.class);

    @Autowired
    GSysContentManagementMapper gSysContentManagementMapper;

    @Override
    public List<GSysContentManagement> getBannerList() {
        //查询轮播图片
        return gSysContentManagementMapper.getBannerList();
    }
    @Override
    public GSysContentManagement getBannerInfo(Long contentId) {
        //查询轮播图片
        return gSysContentManagementMapper.selectByPrimaryKey(contentId);
    }

}
