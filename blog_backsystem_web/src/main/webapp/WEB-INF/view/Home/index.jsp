<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="lyz" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>


    <rapid:override name="breadcrumb">
        <nav class="breadcrumb">
            <div class="bull"><i class="fa fa-volume-up"></i></div>
            <div id="scrolldiv">
                <div class="scrolltext">
                    <ul style="margin-top: 0px;">
                        <c:forEach items="${noticeCustomList}" var="n">
                            <li class="scrolltext-title">
                                <a href="/notice/${n.noticeId}" rel="bookmark">${n.noticeTitle}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </nav>
    </rapid:override>

    <rapid:override name="left">
        <div id="primary" class="content-area">

            <main id="main" class="site-main" role="main">
                <c:forEach items="${articleListVoList}" var="a">

                    <article  class="post type-post">

                        <figure class="thumbnail">
                            <a href="/article/${a.articleCustom.articleId}">
                                <img width="280" height="210"
                                     src="/img/thumbnail/random/img_${a.articleCustom.articleId%400}.jpg"
                                     class="attachment-content size-content wp-post-image"
                                     alt="${a.articleCustom.articleTitle}">
                            </a>
                            <span class="cat">
                                <a href="/category/${a.categoryCustomList[a.categoryCustomList.size()-1].categoryId}">
                                        ${a.categoryCustomList[a.categoryCustomList.size()-1].categoryName}
                                </a>
                            </span>
                        </figure>

                        <header class="entry-header">
                            <h2 class="entry-title">
                                <a href="/article/${a.articleCustom.articleId}"
                                   rel="bookmark">
                                        ${a.articleCustom.articleTitle}
                                </a>
                            </h2>
                        </header>

                        <div class="entry-content">
                            <div class="archive-content">
                                <lyz:htmlFilter>${a.articleCustom.articleContent}</lyz:htmlFilter>......
                            </div>
                            <span class="title-l"></span>
                            <span class="new-icon">
                                    <c:choose>
                                        <c:when test="${a.articleCustom.articleStatus==2}">
                                            <i class="fa fa-bookmark-o"></i>
                                        </c:when>
                                        <c:otherwise>
                                            <jsp:useBean id="nowDate" class="java.util.Date"/>
                                            <c:set var="interval"
                                                   value="${nowDate.time - a.articleCustom.articlePostTime.time}"/><%--时间差毫秒数--%>
                                            <fmt:formatNumber value="${interval/1000/60/60/24}" pattern="#0"
                                                              var="days"/>
                                            <c:if test="${days <= 7}">NEW</c:if>
                                        </c:otherwise>
                                    </c:choose>


                                </span>
                            <span class="entry-meta">
                                    <span class="date">
                                        <fmt:formatDate value="${a.articleCustom.articlePostTime}" pattern="yyyy年MM月dd日"/>
                                    &nbsp;&nbsp;
                                    </span>
                                    <span class="views">
                                        <i class="fa fa-eye"></i>
                                            ${a.articleCustom.articleViewCount} views
                                    </span>
                                    <span class="comment">&nbsp;&nbsp;
                                        <a href="/article/${a.articleCustom.articleId}#comments" rel="external nofollow">
                                          <i class="fa fa-comment-o"></i>
                                            <c:choose>
                                                <c:when test="${a.articleCustom.articleCommentCount==0}">
                                                    发表评论
                                                </c:when>
                                                <c:otherwise>
                                                    ${a.articleCustom.articleCommentCount}
                                                </c:otherwise>
                                            </c:choose>

                                        </a>
                                    </span>
                                </span>
                            <div class="clear"></div>
                        </div><!-- .entry-content -->

                        <span class="entry-more">
                                <a href="/article/${a.articleCustom.articleId}"
                                   rel="bookmark">
                                    阅读全文
                                </a>
                            </span>
                    </article>
                </c:forEach>
            </main>
            <div id="indexArticle"></div>
        </div>
    </rapid:override>
    <%--左侧区域 end--%>

    <%--侧边栏 start--%>
    <rapid:override name="right">
        <%@include file="Public/part/sidebar-2.jsp" %>
    </rapid:override>
    <%--侧边栏 end--%>

    <%--友情链接 start--%>
    <rapid:override name="link">
        <div class="links-box">
            <div id="links">
                <c:forEach items="${linkCustomList}" var="l">
                    <ul class="lx7">
                        <li class="link-f link-name">
                            <a href="${l.linkUrl}" target="_blank">
                                    ${l.linkName}
                            </a>
                        </li>
                    </ul>
                </c:forEach>
                <div class="clear"></div>
            </div>
        </div>
    </rapid:override>
    <%--友情链接 end--%>
<rapid:override name="footer-script">
    <script>
        layui.use("laypage", function () {
            var laypage = layui.laypage;
            laypage.render({
                elem: 'indexArticle',
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
        });
    </script>
</rapid:override>

<%@ include file="Public/framework.jsp" %>