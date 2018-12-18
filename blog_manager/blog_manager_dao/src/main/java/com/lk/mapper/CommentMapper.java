package com.lk.mapper;

import com.lk.pojo.Comment;
import com.lk.pojo.custom.CommentCustom;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);



    List<Comment> selectCommentsList();

    List<CommentCustom> selectCommentCustomList(int status);

    List<CommentCustom> selectRentCommentCustomer();

    CommentCustom selectCommentCustomById(int cid);
}