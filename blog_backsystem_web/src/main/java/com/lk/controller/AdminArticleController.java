package com.lk.controller;

import com.github.pagehelper.PageInfo;
import com.lk.custom.result.YHResult;
import com.lk.pojo.Article;
import com.lk.pojo.Category;
import com.lk.pojo.Tag;
import com.lk.pojo.custom.ArticleCustomer;
import com.lk.pojo.custom.CategoryCustom;
import com.lk.pojo.custom.TagCustom;
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
public class AdminArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;


    @RequestMapping("/article/{articleId}")
    public String toArticleById(Model model,@PathVariable int articleId){
        ArticleCustomer article = articleService.getArticleById(articleId);
        model.addAttribute("articleCustom",article);
        return "Home/Page/articleDetail";
    }

    /**
     * 后台管理页面主页显示数据
     * @param model
     * @return
     */
    @RequestMapping("/admin")
    public String toArticleIndex(Model model){
        model.addAttribute("articleCustomList",articleService.getRecentArticle());
        return "/Admin/index";
    }
    /**
     * 点击全部文章从数据库拿取全部文章信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/article")
    public String getFirstArticle(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageInfo<ArticleCustomer> pageInfo = articleService.getAllArticle(pageNum, pageSize);
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
     * 编辑文章前，根据文章id获取单个文章信息
     *
     * @param model
     * @param articleId
     * @return
     */
    @RequestMapping("/admin/article/edit/{articleId}")
    public String getArticle(Model model, @PathVariable int articleId) {
        ArticleCustomer article = articleService.getArticleById(articleId);
        List<Category> categories = categoryService.getCategoryList();
        List<Tag> tags = tagService.getTagsList();
        model.addAttribute("articleCustom", article);
        model.addAttribute("categoryCustomList", categories);
        model.addAttribute("tagCustomList", tags);
        return "/Admin/Article/edit";
    }

    /**
     * 编辑保存文章
     * @param article
     * @return
     */
    @RequestMapping("/admin/article/editSubmit")
    public String updateArticle(Article article){
        articleService.updateArticle(article);
        return "forward:/admin/article";
    }

    /**
     * 前往写文章的界面
     * @param model
     * @return
     */
    @RequestMapping("/admin/article/insert")
    public String toEditArticle(Model model){
        //分别获取全部类别和全部标签
        model.addAttribute("categoryCustomList",categoryService.getCategoryList());
        model.addAttribute("tagCustomList",tagService.getTagsList());
        return "Admin/Article/insert";
    }

    /**
     * 保存新文章
     * @return
     */
    @RequestMapping("/admin/article/insertSubmit")
    public String saveNewArticle(Article article){
        articleService.saveNewArticle(article);
        return "Admin/Article/index";
    }

    /**
     * 全部类别
     * @param model
     * @return
     */
    @RequestMapping("/admin/category")
    public String getCategories(Model model){
        List<CategoryCustom> categoryCustoms = categoryService.getCategoryCustom();
        model.addAttribute("categoryCustomList",categoryCustoms);
        return "Admin/Category/index";
    }
    /**
     * 全部标签
     * @param model
     * @return
     */
    @RequestMapping("/admin/tag")
    public String getTags(Model model){
        List<TagCustom> tagCustoms = tagService.getTagCustom();
        model.addAttribute("tagCustomList",tagCustoms);
        return "Admin/Tag/index";
    }
}
