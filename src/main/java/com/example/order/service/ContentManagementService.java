package com.example.order.service;

import com.example.order.entity.GSysContentManagement;

import java.util.List;

/**
 * 轮播图展示service
 */
public interface ContentManagementService {

    List<GSysContentManagement> getBannerList();

    GSysContentManagement getBannerInfo(Long contentId);

}
