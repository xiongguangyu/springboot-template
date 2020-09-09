package com.example.order.service.impl;

import com.example.order.entity.GSysAnnouncementManagement;
import com.example.order.exception.LoginException;
import com.example.order.mapper.GSysAnnouncementManagementMapper;
import com.example.order.service.AnnouncementManagementService;
import com.example.order.service.menuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.order.controller.AnnouncementController;

@Service
public class AnnouncementManagementImpl implements AnnouncementManagementService {

    protected static final Logger logger = LoggerFactory.getLogger(AnnouncementManagementImpl.class);

    @Autowired
    private GSysAnnouncementManagementMapper  GSysAnnouncementManagementMapper;


    @Override
    public List<GSysAnnouncementManagement> getAnnouncementInfo(String announcementId) {
        long id = Long.parseLong(announcementId);
        return GSysAnnouncementManagementMapper.getAnnouncementInfo(id);

    }
}
