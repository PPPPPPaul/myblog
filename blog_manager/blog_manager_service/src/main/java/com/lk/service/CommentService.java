package com.lk.service;

import com.github.pagehelper.PageInfo;
import com.lk.custom.result.YHResult;
import com.lk.pojo.Comment;
import com.lk.pojo.custom.CommentCustom;

import java.util.List;

public interface CommentService {
    PageInfo<CommentCustom> getCommentCustomsPass(int pageNum, int pageSize);

    PageInfo<CommentCustom> getCommentCustomsNopass(int pageNum,int pageSize);

    List<Comment> getComment();

    List<CommentCustom> getRentCommentCustoms();

    Comment getCommentById(int cid);

    YHResult saveComment(Comment comment);

    void replyComment(Comment comment);

    void deleteComment(int cid);
}
