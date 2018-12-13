<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<rapid:override name="title">
    - 文章列表
</rapid:override>
<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/
        .layui-input {
            display: inline-block;
            width: 33.333% !important;
        }

        .layui-input-block {
            margin: 0px 10px;
        }
    </style>
</rapid:override>

<rapid:override name="content">
    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
          <a href="/admin">首页</a>
          <a><cite>文章列表</cite></a>
        </span>
    </blockquote>

    <div class="layui-tab layui-tab-card">
        <ul class="layui-tab-title">
            <li class="layui-this">已发布(${pageinfo.total})</li>
            <li>草稿(<%--${draftArticleList.size()}--%>)</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <form id="articleForm" action="/admin/article" method="post">
                    <input id="pageNum" name="pageNum" value="" hidden>
                    <input id="pageSize" name="pageSize" value="" hidden>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <input type="text" name="query" placeholder="请输入关键词" autocomplete="off" class="layui-input">
                            <button class="layui-btn" lay-filter="formDemo" onclick="queryArticle()">搜索</button>
                            <button class="layui-btn" lay-filter="formDemo" type="button" style="float: right" onclick="batchdelete()">批量删除</button>
                        </div>
                    </div>
                    <input type="hidden" name="currentUrl" id="currentUrl" value="">
                    <table class="layui-table">
                        <colgroup>
                            <col width="50">
                            <col width="50">
                            <col width="300">
                            <col width="200">
                            <col width="200">
                            <col width="50">
                            <col width="150">
                            <col width="100">
                        </colgroup>
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="allSelect" onclick="javascript:DoCheck()"></th>
                            <th>id</th>
                            <th>标题</th>
                            <th>所属分类</th>
                            <th>所带标签</th>
                            <td>order</td>
                            <th>发布时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageinfo.list}" var="a">
                            <c:if test="${a.articleStatus==1}">
                                <tr>
                                    <td><input type="checkbox" name="ids" value="${a.articleId}"></td>
                                    <td>${a.articleId}</td>
                                    <td>
                                        <a href="/article/${a.articleId}"
                                           target="_blank">
                                                ${a.articleTitle}

                                        </a></td>
                                    <td>
                                        <c:forEach items="${a.categoryCustomList}" var="c">
                                            <a href="/category/${c.categoryId}"
                                               target="_blank">${c.categoryName}</a>
                                            &nbsp;
                                        </c:forEach>
                                    </td>

                                    <td>
                                        <c:forEach items="${a.tagCustomList}" var="t">
                                            <a href="/tag/${t.tagId}"
                                               target="_blank">${t.tagName}</a>
                                            &nbsp;
                                        </c:forEach>
                                    </td>
                                    <td>${a.articleOrder}</td>
                                    <td>
                                        <fmt:formatDate value="${a.articlePostTime}"
                                                        pattern="MM月dd日 HH:mm"/>
                                    </td>
                                    <td>
                                        <a href="/admin/article/edit/${a.articleId}"
                                           class="layui-btn layui-btn-mini">编辑</a>
                                        <a href="javascript:void(0)"
                                           onclick="deleteArticle(${a.articleId})"
                                           class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
                <%--           <div class="layui-tab-item">
                               <table class="layui-table">
                                   <colgroup>
                                       <col width="50">
                                       <col width="300">
                                       <col width="200">
                                       <col width="200">
                                       <col width="200">
                                       <col width="100">
                                   </colgroup>
                                   <thead>
                                   <tr>
                                       <th>id</th>
                                       <th>标题</th>
                                       <th>所属分类</th>
                                       <th>所带标签</th>
                                       <th>发布时间</th>
                                       <th>操作</th>
                                   </tr>
                                   </thead>
                                   <tbody>
                                   <c:forEach items="${draftArticleList}" var="a">
                                       <tr>
                                           <td>${a.articleCustom.articleId}</td>
                                           <td><a href="/article/${a.articleCustom.articleId}"
                                                  target="_blank">
                                                   ${a.articleCustom.articleTitle}

                                           </a></td>
                                           <td>
                                               <c:forEach items="${a.categoryCustomList}" var="c">
                                                   <a href="/category/${c.categoryId}"
                                                      target="_blank">${c.categoryName}</a>
                                                   &nbsp;
                                               </c:forEach>
                                           </td>

                                           <td>
                                               <c:forEach items="${a.tagCustomList}" var="t">
                                                   <a href="/tag/${t.tagId}"
                                                      target="_blank">${t.tagName}</a>
                                                   &nbsp;
                                               </c:forEach>
                                           </td>

                                           <td>
                                               <fmt:formatDate value="${a.articleCustom.articlePostTime}"
                                                               pattern="yyyy-MM-dd HH:mm:ss"/>
                                           </td>
                                           <td>
                                               <a href="/admin/article/edit/${a.articleCustom.articleId}"
                                                  class="layui-btn layui-btn-mini">编辑</a>
                                               <a href="javascript:void(0)"
                                                  onclick="deleteArticle(${a.articleCustom.articleId})"
                                                  class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
                                           </td>
                                       </tr>
                                   </c:forEach>
                                   </tbody>
                               </table>
                           </div>--%>
        </div>
    </div>
    <div id="tablecontent"></div>

</rapid:override>
<rapid:override name="footer-script">
    <%--前台laypage和后台pageHelper分页--%>
    <script>
        var url;
        layui.use("laypage",function(){
            var laypage = layui.laypage;
            laypage.render({
                elem:'tablecontent',
                count:${pageinfo.total},
                curr:${pageinfo.pageNum},
                limit:${pageinfo.pageSize},
                limits:[5,10,20,30,40,50],
                layout:['prev', 'page','limit','next'],
                jump: function(obj, first){
                        $('#pageNum').val(obj.curr);
                        $('#pageSize').val(obj.limit);
                    if(!first) {
                        $('#articleForm').submit();
                    }
                }
            })
        })
    </script>
</rapid:override>
<%@ include file="../Public/framework.jsp" %>
