package com.lk.controller;

import com.github.pagehelper.PageInfo;
import com.lk.custom.result.YHResult;
import com.lk.pojo.Comment;
import com.lk.pojo.custom.CommentCustom;
import com.lk.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminCommentController {
    @Autowired
    private CommentService commentService;

    /*
    * 获取全部评论列表
    * */
    @RequestMapping("/admin/comment")
    public String toCommentPage(Model model,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "10")int pageSize,
                                      @RequestParam(value = "npageNum",defaultValue = "1")int npageNum,
                                      @RequestParam(value = "npageSize",defaultValue = "10")int npageSize,
                                      @RequestParam(value = "test",defaultValue = "11")int test){
        PageInfo<CommentCustom> commentCustomsPass = commentService.getCommentCustomsPass(pageNum, pageSize);
        PageInfo<CommentCustom> commentCustomsNopass = commentService.getCommentCustomsNopass(npageNum, npageSize);
        model.addAttribute("pageinfopass",commentCustomsPass);
        model.addAttribute("pageinfonopass",commentCustomsNopass);
        model.addAttribute("test",test);
        return "Admin/Comment/index";
    }
    /*
    * 删除
    * */
    @RequestMapping("/admin/comment/delete/{id}")
    public void toCommentPage(@PathVariable int id){
        commentService.deleteComment(id);
    }


    /*
    * 编辑
    * */
    @RequestMapping("/admin/comment/edit/{commentId}")
    public String getCommentById(Model model,@PathVariable int commentId){
        Comment commentById = commentService.getCommentById(commentId);
        model.addAttribute("commentCustom",commentById);
        return "Admin/Comment/edit";
    }
    @RequestMapping("/admin/comment/editSubmit")
    public String saveComment(Comment comment){
        commentService.saveComment(comment);
        return "forward:/admin/comment";
    }



    /*
    * 回复
    * */
    @RequestMapping("/admin/comment/reply/{commentId}")
    public String replyComment(Model model, @PathVariable int commentId){
        Comment commentById = commentService.getCommentById(commentId);
        model.addAttribute("commentCustom",commentById);
        return "/Admin/Comment/reply";
    }
    @RequestMapping("/admin/comment/replySubmit")
    public String saveReplyComment(Comment comment,HttpServletRequest request){
        String remoteAddr = request.getRemoteAddr();
        comment.setCommentIp(remoteAddr);
        commentService.replyComment(comment);
        return "forward:/admin/comment";
    }

    /**
     * 批准
     *
     */
    @RequestMapping("/admin/comment/approve/{id}")
    @ResponseBody
    public YHResult passComment(@PathVariable int id){
        Comment comment = commentService.getCommentById(id);
        comment.setCommentStatus(1);
        return commentService.saveComment(comment);
    }

    /**
     * 屏蔽
     * @param id
     * @return
     */
    @RequestMapping("/admin/comment/hide/{id}")
    @ResponseBody
    public YHResult noPassComment(@PathVariable int id){
        Comment comment = commentService.getCommentById(id);
        comment.setCommentStatus(0);
        return commentService.saveComment(comment);
    }
}
