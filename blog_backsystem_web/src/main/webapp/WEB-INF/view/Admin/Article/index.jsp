<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<rapid:override name="title">
    - 文章列表
</rapid:override>
<rapid:override name="header-script">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/plugin/layui/layui.all.js"></script>
    <script>
    </script>
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
                <form id="articleForm" method="post">
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <input type="text" name="query" placeholder="请输入关键词" autocomplete="off" class="layui-input">
                            <button class="layui-btn" lay-filter="formDemo" onclick="queryArticle()">搜索</button>
                            <button class="layui-btn" lay-filter="formDemo" style="float: right;"
                                    onclick="confirmDeleteArticleBatch()">批量删除
                            </button>
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
                    <div id="tablecontent"></div>
                </form>

                <%--<c:if test="${pageinfo.list.size()!=0}">
                    &lt;%&ndash;分页 start&ndash;%&gt;
                    <nav class="navigation pagination" role="navigation">
                        <div class="nav-links">
                            <c:choose>
                                <c:when test="${pageinfo.totalPageCount <= 3 }">
                                    <c:set var="begin" value="1"/>
                                    <c:set var="end" value="${publishedArticleListVoList[0].page.totalPageCount }"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="begin" value="${publishedArticleListVoList[0].page.pageNow-1 }"/>
                                    <c:set var="end" value="${publishedArticleListVoList[0].page.pageNow + 2}"/>
                                    <c:if test="${begin < 2 }">
                                        <c:set var="begin" value="1"/>
                                        <c:set var="end" value="3"/>
                                    </c:if>
                                    <c:if test="${end > publishedArticleListVoList[0].page.totalPageCount }">
                                        <c:set var="begin"
                                               value="${publishedArticleListVoList[0].page.totalPageCount-2 }"/>
                                        <c:set var="end" value="${publishedArticleListVoList[0].page.totalPageCount }"/>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                                &lt;%&ndash;上一页 &ndash;%&gt;
                            <c:choose>
                                <c:when test="${publishedArticleListVoList[0].page.pageNow eq 1 }">
                                    &lt;%&ndash;当前页为第一页，隐藏上一页按钮&ndash;%&gt;
                                </c:when>
                                <c:otherwise>
                                    <a class="page-numbers"
                                       href="/admin/article/p/${publishedArticleListVoList[0].page.pageNow-1}">
                                        <i class="layui-icon">&#xe603;</i>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                                &lt;%&ndash;显示第一页的页码&ndash;%&gt;
                            <c:if test="${begin >= 2 }">
                                <a class="page-numbers" href="/admin/article/p/1">1</a>
                            </c:if>
                                &lt;%&ndash;显示点点点&ndash;%&gt;
                            <c:if test="${begin  > 2 }">
                                <span class="page-numbers dots">…</span>
                            </c:if>
                                &lt;%&ndash;打印 页码&ndash;%&gt;
                            <c:forEach begin="${begin }" end="${end }" var="i">
                                <c:choose>
                                    <c:when test="${i eq publishedArticleListVoList[0].page.pageNow }">
                                        <a class="page-numbers current">${i}</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="page-numbers"
                                           href="/admin/article/p/${i}">${i}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                                &lt;%&ndash; 显示点点点 &ndash;%&gt;
                            <c:if test="${end < publishedArticleListVoList[0].page.totalPageCount-1 }">
                                <span class="page-numbers dots">…</span>
                            </c:if>
                                &lt;%&ndash; 显示最后一页的数字 &ndash;%&gt;
                            <c:if test="${end < publishedArticleListVoList[0].page.totalPageCount }">
                                <a href="/admin/article/p/${publishedArticleListVoList[0].page.totalPageCount}">
                                        ${publishedArticleListVoList[0].page.totalPageCount}
                                </a>
                            </c:if>
                                &lt;%&ndash;下一页 &ndash;%&gt;
                            <c:choose>
                                <c:when test="${publishedArticleListVoList[0].page.pageNow eq publishedArticleListVoList[0].page.totalPageCount }">
                                    &lt;%&ndash;到了尾页隐藏，下一页按钮&ndash;%&gt;
                                </c:when>
                                <c:otherwise>
                                    <a class="page-numbers"
                                       href="/admin/article/p/${publishedArticleListVoList[0].page.pageNow+1}">
                                        <i class="layui-icon">&#xe602;</i>
                                    </a>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </nav>
                    &lt;%&ndash;分页 end&ndash;%&gt;
                </c:if>--%>
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


</rapid:override>
<rapid:override name="footer-script">
    <script>
        var ROOT_PATH=getRootPath();
        layui.use("laypage",function(){
            var laypage = layui.laypage;
            laypage.render({
                elem:'tablecontent',
                count:${pageinfo.total},
                curr:${pageinfo.pageNum},
                limit:${pageinfo.pageSize},
                limits:[10,20,30,40,50],
                layout:['prev', 'page','limit','next'],
                jump: function(obj, first){//这个方法是在你选择页数后触发执行，在这里完成当你点击页码后需要向服务请求数据的操
                    $('#articleForm').submit(function(){
                        url:'/admin/article'+'?pageNum='+obj.curr+"&pageSize="+obj.limit
                    });
                }
            })
        })
        /**
         * 获取当前项目路径
         * @returns
         */
        function getRootPath(){
            //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
            var curWwwPath=window.document.location.href;
            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
            var pathName=window.document.location.pathname;
            var pos=curWwwPath.indexOf(pathName);
            //获取主机地址，如： http://localhost:8083
            var localhostPaht=curWwwPath.substring(0,pos);
            //获取带"/"的项目名，如：/uimcardprj
            /*var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);*/
            return(localhostPaht);
        };
    </script>
</rapid:override>
<%@ include file="../Public/framework.jsp" %>
