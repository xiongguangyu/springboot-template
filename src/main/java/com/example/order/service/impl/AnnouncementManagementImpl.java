package com.example.order.service.impl;

import com.example.order.entity.GSysAnnouncementManagement;
import com.example.order.mapper.GSysAnnouncementManagementMapper;
import com.example.order.service.AnnouncementManagementService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnnouncementManagementImpl implements AnnouncementManagementService {

    protected static final Logger logger = LoggerFactory.getLogger(AnnouncementManagementImpl.class);

    @Autowired
    private GSysAnnouncementManagementMapper  GSysAnnouncementManagementMapper;

    @Override
    public GSysAnnouncementManagement getAnnouncementInfo(Long announcementId) {
        return GSysAnnouncementManagementMapper.getAnnouncementInfo(announcementId).get(0);
    }
}
