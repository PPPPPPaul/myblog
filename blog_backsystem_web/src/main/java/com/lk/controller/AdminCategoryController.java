package com.lk.controller;

import com.lk.pojo.Category;
import com.lk.pojo.custom.CategoryCustom;
import com.lk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminCategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 添加新的类别
     * @param category
     * @return
     */
    @RequestMapping("/admin/category/insertSubmit")
    public String addCategory(Category category){
        categoryService.insertCategory(category);
        return "forward:/admin/category";
    }
    /**
     * 编辑类别前，获取类别信息
     * @param model
     * @param categoryId
     * @return
     */
    @RequestMapping("/admin/category/edit/{categoryId}")
    public String getCategory(Model model,@PathVariable int categoryId){
        Category category = categoryService.getCategory(categoryId);
        List<CategoryCustom> categoryCustoms = categoryService.getCategoryCustom();
        model.addAttribute("categoryCustom",category);
        model.addAttribute("categoryCustomList",categoryCustoms);
        return "/Admin/Category/edit";
    }

    /**
     * 编辑保存
     * @param category
     * @return
     */
    @RequestMapping("/admin/category/editSubmit")
    public String saveCategory(Category category){
        categoryService.updateCategory(category);
        return "forward:/admin/category";
    }

    /**
     * 删除对应id的类别
     * @param categoryId
     * @return
     */
    @RequestMapping("/admin/category/delete/{categoryId}")
    public String deleteCategory(@PathVariable int categoryId){
        categoryService.deleteCateGory(categoryId);
        return "forward:/admin/category";
    }
}
