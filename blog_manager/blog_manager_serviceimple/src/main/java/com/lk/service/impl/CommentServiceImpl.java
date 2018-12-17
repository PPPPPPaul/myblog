package com.lk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lk.custom.result.YHResult;
import com.lk.mapper.CommentMapper;
import com.lk.pojo.Comment;
import com.lk.pojo.custom.CommentCustom;
import com.lk.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;


    @Override
    public PageInfo<CommentCustom> getCommentCustomsPass(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CommentCustom> commentCustoms = commentMapper.selectCommentCustomList(1);
        return new PageInfo<>(commentCustoms);
    }

    @Override
    public PageInfo<CommentCustom> getCommentCustomsNopass(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CommentCustom> commentCustoms = commentMapper.selectCommentCustomList(0);
        return new PageInfo<>(commentCustoms);
    }

    @Override
    public List<Comment> getComment() {
        return commentMapper.selectCommentsList();
    }

    @Override
    public List<CommentCustom> getRentCommentCustoms() {
        return commentMapper.selectRentCommentCustomer();
    }

    @Override
    public Comment getCommentById(int cid) {
        return commentMapper.selectByPrimaryKey(cid);
    }

    @Override
    public YHResult saveComment(Comment comment) {
        try {
            commentMapper.updateByPrimaryKeySelective(comment);
            return YHResult.ok();
        }catch (Exception e){
            return YHResult.build(500,"批准失败");
        }
    }

    @Override
    public void replyComment(Comment comment) {
        Date date = new Date();
        comment.setCommentCreateTime(date);
        comment.setCommentStatus(0);
        commentMapper.insertSelective(comment);
    }

    @Override
    public void deleteComment(int cid) {
        commentMapper.deleteByPrimaryKey(cid);
    }
}
