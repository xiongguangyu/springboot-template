package com.example.order.mapper;

import com.example.order.entity.GSysAnnouncementManagement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GSysAnnouncementManagementMapper {

    int deleteByPrimaryKey(Long announcementId);

    int insert(GSysAnnouncementManagement record);

    int insertSelective(GSysAnnouncementManagement record);

    int updateByPrimaryKeySelective(GSysAnnouncementManagement record);

    int updateByPrimaryKey(GSysAnnouncementManagement record);

    List<GSysAnnouncementManagement> getAnnouncementInfo(Long announcementId);
}