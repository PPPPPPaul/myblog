package com.lk.controller;

import com.lk.pojo.Tag;
import com.lk.pojo.custom.TagCustom;
import com.lk.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminTagController {
    @Autowired
    private TagService tagService;

    /**
     * 删除标签后，请求转发到全部标签页面
     * @param tagId
     * @return
     */
    @RequestMapping("/admin/tag/delete/{tagId}")
    public String deleteTag(@PathVariable int tagId){
        tagService.deleteTag(tagId);
        return "forward:/admin/tag";
    }

    /**
     * 添加新的标签信息
     * @param tag
     * @return
     */
    @RequestMapping("/admin/tag/insertSubmit")
    public String addTag(Tag tag){
        tagService.addTag(tag);
        return "forward:/admin/tag";
    }

    /**
     * 编辑标签前获取标签的对象
     * @param model
     * @param tagId
     * @return
     */
    @RequestMapping("/admin/tag/edit/{tagId}")
    public String getTag(Model model,@PathVariable int tagId){
        Tag tagById = tagService.getTagById(tagId);
        List<TagCustom> tagCustoms = tagService.getTagCustom();
        model.addAttribute("tagCustomList",tagCustoms);
        model.addAttribute("tagCustom",tagById);
        return "Admin/Tag/edit";
    }

    /**
     * 保存编辑后的标签信息
     * @param tag
     * @return
     */
    @RequestMapping("/admin/tag/editSubmit")
    public String saveTag(Tag tag){
        tagService.updateTag(tag);
        return "forward:/admin/tag";
    }
}
