package com.example.order.service.impl;

import com.example.order.entity.GSysJournalism;
import com.example.order.mapper.GSysJournalismMapper;
import com.example.order.service.JournalismService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalismImpl implements JournalismService {

    protected static final Logger logger = LoggerFactory.getLogger(JournalismImpl.class);

    @Autowired
    private GSysJournalismMapper  GSysJournalismMapper;


    @Override
    public List<GSysJournalism> getNewsList(String journalismId) {
        long id = Long.parseLong(journalismId);
        return GSysJournalismMapper.getNewsList(id);

    }
}
