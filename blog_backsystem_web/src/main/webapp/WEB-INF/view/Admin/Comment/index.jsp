<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 评论列表
</rapid:override>
<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/
        .layui-table {
            margin-top: 0;
        }

    </style>
</rapid:override>

<rapid:override name="content">
    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/admin">首页</a>
              <a><cite>评论列表</cite></a>
        </span>
    </blockquote>
    <div class="layui-tab layui-tab-card" lay-filter="test">
        <ul class="layui-tab-title" id="cardheader">
            <li class="layui-this" lay-id="11">全部评论(${pageinfopass.total})</li>
            <li lay-id="22">待审评论(${pageinfonopass.total})</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show" style="margin-bottom: -10px">
                <table class="layui-table" lay-even lay-skin="nob">
                    <colgroup>
                        <col width="100">
                        <col width="300">
                        <col width=200">
                        <col width="150">
                        <col width="50">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>作者</th>
                        <th>评论内容</th>
                        <th>回复至</th>
                        <th>提交于</th>
                        <th>ID</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageinfopass.list}" var="c">
                        <tr>
                            <td>
                                <img src="${c.user.userAvatar}" alt="" width="64px">
                                <strong>${c.user.userName}</strong>
                                <c:if test="${c.commentStatus==0}">
                                    <span class="approve">[待审]</span>
                                </c:if>
                                <br>
                                    ${c.user.userUrl} <br>
                                    ${c.user.userEmail} <br>
                                    ${c.commentIp}
                            </td>
                            <td class="dashboard-comment-wrap">
                                <c:if test="${c.commentPid!=0}">
                                    <span class="at">@ </span><a href="${c.user.userUrl}">${c.commentPname}</a>
                                </c:if>
                                    ${c.commentContent}
                                <div class="row-actions">
                                     <span class="">
                                           <c:choose>
                                               <c:when test="${c.commentStatus==0}">
                                                   <a href="javascript:void(0)" style="color:#5FB878;!important;"
                                                      onclick="approveComment(${c.commentId})">批准</a>
                                               </c:when>
                                               <c:otherwise>
                                                   <a href="javascript:void(0)" style="color:#FF5722;!important;"
                                                      onclick="hideComment(${c.commentId})">屏蔽</a>
                                               </c:otherwise>
                                           </c:choose>
                                     </span> |
                                    <span class="">
                                        <a href="/admin/comment/reply/${c.commentId}">
                                            回复
                                        </a>
                                     </span>
                                    <span class=""> |
                                        <a href="/admin/comment/edit/${c.commentId}">编辑</a>
                                     </span>
                                    <span class=""> |
                                        <a href="javascript:void(0)" onclick="deleteComment(${c.commentId})">删除</a>
                                     </span>
                                </div>
                            </td>
                            <td>
                                <a href="/article/${c.article.articleId}"
                                   target="_blank">${c.article.articleTitle}</a>
                            </td>
                            <td>
                                <fmt:formatDate value="${c.commentCreateTime}" pattern="yyyy年MM月dd日 HH:dd:ss"/>
                            </td>
                            <td>
                                    ${c.commentId}
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
                <div id="passpage"></div>
            </div>
            <div class="layui-tab-item">
                <table class="layui-table" lay-even lay-skin="nob">
                    <colgroup>
                        <col width="100">
                        <col width="300">
                        <col width=200">
                        <col width="150">
                        <col width="50">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>作者</th>
                        <th>评论内容</th>
                        <th>回复至</th>
                        <th>提交于</th>
                        <th>ID</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageinfonopass.list}" var="c">
                        <tr>
                            <td>
                                <img src="${c.user.userAvatar}" alt="" width="64px">
                                <strong>${c.user.userName}</strong> <br>
                                    ${c.user.userUrl} <br>
                                    ${c.user.userEmail} <br>
                                    ${c.commentIp}
                            </td>
                            <td class="dashboard-comment-wrap">
                                <c:if test="${c.commentPid!=0}">
                                    <a href="${c.user.userUrl}">@ ${c.commentPname}</a></span>
                                </c:if>
                                    ${c.commentContent}
                                <div class="row-actions">
                                    <span class="">
                                        <c:choose>
                                            <c:when test="${c.commentStatus==0}">
                                                <a href="javascript:void(0)" style="color:#5FB878;!important;"
                                                   onclick="approveComment(${c.commentId})">批准</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="javascript:void(0)" style="color:#FF5722;!important;"
                                                   onclick="hideComment(${c.commentId})">屏蔽</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </span>
                                    <span class=""> |
                                        <a href="/admin/comment/reply/${c.commentId}">回复</a>
                                    </span>
                                    <span class=""> |
                                         <a href="/admin/comment/edit/${c.commentId}">编辑</a>
                                    </span>
                                    <span class=""> |
                                        <a href="javascript:void(0)" onclick="deleteComment(${c.commentId})">删除</a>
                                    </span>
                                </div>
                            </td>
                            <td>
                                <a href="/article/${c.article.articleId}"
                                   target="_blank">${c.article.articleTitle}</a>
                            </td>
                            <td>
                                <fmt:formatDate value="${c.commentCreateTime}" pattern="yyyy年MM月dd日 HH:dd:ss"/>
                            </td>
                            <td>
                                    ${c.commentId}
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div id="nopasspage"></div>
            </div>
        </div>
    </div>


</rapid:override>
<rapid:override name="footer-script">
    <script>
        var lid=${test};
        layui.use("element", function () {
            //Hash地址的定位
            var element = layui.element;
            var layid = location.hash.replace(/^#test=/, '');
            element.tabChange('test', layid);
            element.on('tab(test)', function (elem) {
                location.hash = 'test=' + $(this).attr('lay-id');
                lid=$(this).attr('lay-id');
            });
        });
    </script>
    <script>
        layui.use("laypage", function () {
            var laypage = layui.laypage;
            var laypage1 = layui.laypage;
            laypage.render({
                elem: 'passpage',
                count:${pageinfopass.total},
                curr:${pageinfopass.pageNum},
                limit:${pageinfopass.pageSize},
                limits: [5, 10, 20, 30, 40, 50],
                layout: ['prev', 'page', 'limit', 'next'],
                jump: function (obj, first) {
                    if (!first) {
                        location.href = "/admin/comment?pageNum=" + obj.curr + "&pageSize=" + obj.limit;
                    }
                }
            });
            laypage1.render({
                elem: 'nopasspage',
                count:${pageinfonopass.total},
                curr:${pageinfonopass.pageNum},
                limit:${pageinfonopass.pageSize},
                limits: [5, 10, 20, 30, 40, 50],
                layout: ['prev', 'page', 'limit', 'next'],
                jump: function (obj, first) {
                    if (!first) {
                        location.href = "/admin/comment?npageNum=" + obj.curr + "&npageSize=" + obj.limit + "&test=" + lid + "#test=" + lid;
                    }
                }
            });
        });
    </script>
</rapid:override>

<%@ include file="../Public/framework.jsp" %>
