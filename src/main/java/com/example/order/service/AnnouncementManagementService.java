package com.example.order.service;

import com.example.order.entity.GSysAnnouncementManagement;


import java.util.List;

public interface AnnouncementManagementService {

    /**
     * 公告
     * @param announcementId 公告id
     * @return
     */
    GSysAnnouncementManagement getAnnouncementInfo(Long announcementId);
}
