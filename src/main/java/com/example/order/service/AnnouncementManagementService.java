package com.example.order.service;

import com.example.order.entity.GSysAnnouncementManagement;


import java.util.List;

public interface AnnouncementManagementService {

    /**
     * 用户登录
     * @param menuId 菜单id
     * @return
     */

    List<GSysAnnouncementManagement> getAnnouncementInfo(String announcementId);
}
