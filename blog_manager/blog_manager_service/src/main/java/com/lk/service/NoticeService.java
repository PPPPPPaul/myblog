package com.lk.service;

import com.lk.pojo.Notice;

import java.util.List;

public interface NoticeService {
    /**
     * 获取全部公告
     * @return
     */
    List<Notice> selectNoticesList();

    /**
     * 删除公告
     * @param nid
     */
    void deleteNoticeById(int nid);
    Notice selectNoticeById(int nid);
    void updateNotice(Notice notice);
    void insertNotice(Notice notice);
}
