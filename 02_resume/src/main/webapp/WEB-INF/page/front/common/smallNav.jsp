<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header id="crt-header">
    <nav id="crt-nav-sm" class="crt-nav hidden-lg hidden-md">
        <ul class="clear-list">
            <li>
                <a href="${ctx}">
                    <c:choose>
                        <c:when test="${empty user.photo}">
                            <img class="avatar avatar-42" src="${ctx}/asset/admin/img/noimage.png" alt="">
                        </c:when>
                        <c:otherwise>
                            <img class="avatar avatar-42" src="${ctx}/${user.photo}" alt="">
                        </c:otherwise>
                    </c:choose>
                </a>
            </li>
            <li><a href="${ctx}/education/front" data-tooltip="教育经验"><span
                    class="crt-icon crt-icon-book"></span></a></li>
            <li><a href="${ctx}/experience/front" data-tooltip="工作经验"><span
                    class="crt-icon crt-icon-experience"></span></a></li>
            <li><a href="${ctx}/project/front" data-tooltip="项目经验"><span
                    class="crt-icon crt-icon-wrench"></span></a></li>
            <li><a href="${ctx}/contact/front" data-tooltip="联系我吧"><span
                    class="crt-icon crt-icon-contact"></span></a></li>
            <li><a href="${ctx}/user/admin" data-tooltip="后台管理"><span
                    class="crt-icon crt-icon-key"></span></a></li>
        </ul>
    </nav><!-- #crt-nav-sm -->
</header>
