package com.example.order.service;

import com.example.order.entity.GSysJournalism;

import java.util.List;

public interface JournalismService {

    /**
     * 公告
     * @param journalismId 新闻id
     * @return
     */

    List<GSysJournalism> getNewsList(String journalismId);
}
