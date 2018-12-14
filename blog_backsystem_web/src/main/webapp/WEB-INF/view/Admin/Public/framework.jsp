<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="shortcut icon" href="/img/logo.png">
    <title>
        ${options.optionSiteTitle}个人博客后台管理系统
            <rapid:block name="title"></rapid:block>
    </title>
    <script src="/js/jquery.min.js"></script>
    <link rel="stylesheet" href="/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="/css/back.css">
    <link rel="stylesheet" href="/plugin/font-awesome/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="/css/loading.css">
    <rapid:block name="header-style"></rapid:block>
    <rapid:block name="header-script"></rapid:block>
    <script>
        /**
         * loading消失时间
         */
        function load() {
            var a= setTimeout("loading.style.transition='opacity 0.3s'",0)
            //设置透明度改变的过渡时间为0.3秒
            var b= setTimeout("loading.style.opacity=0",500)
            //0.5秒后加载动画开始变为透明
            var c= setTimeout("loading.style.display='none'",800)
        }
    </script>
</head>
<body onload="load()">


<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><a href="/admin" style="color:#009688;">
        ${options.optionSiteTitle}个人博客后台管理系统
        </a>
        </div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="/" target="_blank">前台</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">新建</a>
                <dl class="layui-nav-child">
                    <dd><a href="/admin/article/insert">文章</a></dd>
                    <dd><a href="/admin/page/insert">页面</a></dd>
                    <dd><a href="/admin/category/insert">分类</a></dd>
                    <dd><a href="/admin/tag/insert">标签</a></dd>
                    <dd><a href="/admin/notice/insert">公告</a></dd>
                    <dd><a href="/admin/link/insert">链接</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${loginUser.userAvatar}" class="layui-nav-img">
                    ${loginUser.userNickname}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/admin/user/profile/${loginUser.userId}">基本资料</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="/admin/logout">退出</a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">文章</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/article">全部文章</a></dd>
                        <dd><a href="/admin/article/insert">写文章</a></dd>
                        <dd><a href="/admin/category">全部分类</a></dd>
                        <dd><a href="/admin/tag">全部标签</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">页面</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/page">全部页面</a></dd>
                        <dd><a href="/admin/page/insert">添加页面</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">
                        链接
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/link">全部链接</a></dd>
                        <dd><a href="/admin/link/insert">添加链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">公告</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/notice">全部公告</a></dd>
                        <dd><a href="/admin/notice/insert">添加公告</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="/admin/comment">
                        评论
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">
                        用户
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/user">全部用户</a></dd>
                        <dd><a href="/admin/user/insert">添加用户</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">设置</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/menu">菜单</a></dd>
                        <dd><a href="/admin/options">主要选项</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <%--loading   页面载入动画--%>
            <div id="loading">
                <div id="loading-center-absolute">
                    <div class="sk-chasing-dots">
                        <div class="sk-child sk-dot1"></div>
                        <div class="sk-child sk-dot2"></div>
                    </div>
                </div>
            </div>
<%--            <!-- Preloader -->
            <div id="preloader">
                <div class="preload-content">
                    <div id="original-load"></div>
                </div>
            </div>--%>
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <rapid:block name="content">

            </rapid:block>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © ${options.optionSiteTitle} - 后台
    </div>
</div>

<%--<script src="/js/jquery.min.js"></script>--%>
<script src="/plugin/layui/layui.all.js"></script>
<script src="/js/back.js"></script>
<rapid:block name="footer-script">

</rapid:block>
<script>
    //给文本编辑器的iframe引入代码高亮的css
    $("iframe").contents().find("head").append("<link rel=\"stylesheet\" href=\"/css/highlight.css\">\n");
</script>

</body>
</html>