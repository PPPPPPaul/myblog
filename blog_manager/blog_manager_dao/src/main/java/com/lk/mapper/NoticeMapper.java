package com.lk.mapper;

import com.lk.pojo.Notice;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeId);

    List<Notice> selectNoticeList();

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}