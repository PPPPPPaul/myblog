package com.lk.service.impl;

import com.lk.mapper.NoticeMapper;
import com.lk.pojo.Notice;
import com.lk.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> selectNoticesList() {
        return noticeMapper.selectNoticeList();
    }

    @Override
    public void deleteNoticeById(int nid) {
        noticeMapper.deleteByPrimaryKey(nid);
    }

    @Override
    public Notice selectNoticeById(int nid) {
        return noticeMapper.selectByPrimaryKey(nid);
    }

    @Override
    public void updateNotice(Notice notice) {
        Date date = new Date();
        notice.setNoticeUpdateTime(date);
        noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public void insertNotice(Notice notice) {
        Date date = new Date();
        notice.setNoticeCreateTime(date);
        notice.setNoticeUpdateTime(date);
        notice.setNoticeStatus(1);
        noticeMapper.insertSelective(notice);
    }
}
