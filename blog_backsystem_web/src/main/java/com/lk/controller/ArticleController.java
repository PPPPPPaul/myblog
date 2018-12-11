package com.lk.controller;

import com.github.pagehelper.PageInfo;
import com.lk.custom.result.YHResult;
import com.lk.pojo.Category;
import com.lk.pojo.Tag;
import com.lk.pojo.custom.CustomerArticle;
import com.lk.service.ArticleService;
import com.lk.service.CategoryService;
import com.lk.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;

    /**
     * 点击全部文章从数据库拿取全部文章信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/article")
    public String getFirstArticle(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageInfo<CustomerArticle> pageInfo = articleService.getAllArticle(pageNum, pageSize);
        model.addAttribute("pageinfo", pageInfo);
        return "Admin/Article/index";
    }

    /**
     * 批量删除文章
     *
     * @param ids
     * @return
     */
    @RequestMapping("/admin/article/delete")
    @ResponseBody
    public YHResult deleteArticle(int[] ids) {
        return articleService.deleteArticle(ids);
    }

    /**
     * 根据文章id获取单个文章信息
     *
     * @param model
     * @param articleId
     * @return
     */
    @RequestMapping("/admin/article/edit/{articleId}")
    public String getArticle(Model model, @PathVariable int articleId) {
        CustomerArticle article = articleService.getArticleById(articleId);
        List<Category> categories = categoryService.getCategoryList();
        List<Tag> tags = tagService.getTagsList();
        model.addAttribute("articleCustom", article);
        model.addAttribute("categoryCustomList", categories);
        model.addAttribute("tagCustomList", tags);
        return "/Admin/Article/edit";
    }
}
