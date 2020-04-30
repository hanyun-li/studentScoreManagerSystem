<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="top.jsp"/>--%>
<!DOCTYPE html>
<html>


<!-- Mirrored from admindesigns.com/demos/absolute/1.1/admin_forms-validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 06 Aug 2015 02:56:15 GMT -->
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">

    <title> 胡雪峰OA--欢迎使用胡雪峰OA系统 </title>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/statics/assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/statics/assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/statics/assets/img/favicon.ico">
</head>

<body class="admin-validation-page" data-spy="scroll" data-target="#nav-spy" data-offset="200">
<div id="main">
    <header class="navbar navbar-fixed-top navbar-shadow">
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown menu-merge">
                <a href="#" class="dropdown-toggle fw600 p15" data-toggle="dropdown">
                    <img src="${pageContext.request.contextPath}/statics/assets/img/avatars/3.jpg" alt="avatar"
                         class="mw30 br64">
                    <span class="hidden-xs pl15">
                        ${info.name}
                    </span>
                    <span class="caret caret-tp hidden-xs"></span>
                </a>
                <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
                    <li class="dropdown-footer">
                        <a href="http://127.0.0.1:8080/login/goLogin" class="">
                            <span class="fa fa-power-off pr5"></span> 退出 </a>
                    </li>
                </ul>
            </li>
        </ul>
    </header>
</div>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 查询学生成绩 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                        </div>
                    </div>
                </div>
                <div>
                    <form action="http://127.0.0.1:8080/score/studentScoreByClassAndCourse" method="post">

                        <div class="panel-body pn">
                            <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                                <thead>
                                <tr class="">
                                    <th colspan="2" class="text-center hidden-xs">
                                        <input type="text" id="graclass" name="graclass" placeholder="请输入班级名称..."  >
                                    </th>
                                    <th colspan="2" class="text-center">
                                        <input type="text" id="courseName" name="courseName" placeholder="请输入课程名称..."  >
                                    </th>
                                    <th colspan="1" class="text-center">
                                        <input type="submit" value="查询" >
                                    </th>
                                </tr>
                                <tr class="">
                                    <th class="text-center hidden-xs">班级：</th>
                                    <th class="text-center hidden-xs">姓名：</th>
                                    <th class="text-center hidden-xs">学号：</th>
                                    <th class="text-center hidden-xs">课程：</th>
                                    <th class="text-center hidden-xs">分数：</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="cv">
<%--                                    <c:forEach items="${cv}" var="ca">--%>
                                        <tr class="message-unread">
                                            <td align="center">
                                                    ${student.graclass}
                                            </td>
                                            <td align="center">
                                                    ${student.stuname}
                                            </td>
                                            <td align="center">
                                                    ${student.stuno}
                                            </td>
                                            <td align="center">
                                                    ${cv.allStudentCourseName}
                                            </td>
                                            <td align="center">
                                                    ${cv.allStudentScore}
                                            </td>
                                        </tr>
<%--                                    </c:forEach>--%>
                                </c:forEach>
                                <c:forEach items="${list1}" var="cv">
                                    <%--                                    <c:forEach items="${cv}" var="ca">--%>
                                    <tr class="message-unread">
                                        <td align="center">
                                                ${student1.graclass}
                                        </td>
                                        <td align="center">
                                                ${student1.stuname}
                                        </td>
                                        <td align="center">
                                                ${student1.stuno}
                                        </td>
                                        <td align="center">
                                                ${cv.allStudentCourseName}
                                        </td>
                                        <td align="center">
                                                ${cv.allStudentScore}
                                        </td>
                                    </tr>
                                    <%--                                    </c:forEach>--%>
                                </c:forEach>
                                <c:forEach items="${list2}" var="cv">
                                    <%--                                    <c:forEach items="${cv}" var="ca">--%>
                                    <tr class="message-unread">
                                        <td align="center">
                                                ${student2.graclass}
                                        </td>
                                        <td align="center">
                                                ${student2.stuname}
                                        </td>
                                        <td align="center">
                                                ${student2.stuno}
                                        </td>
                                        <td align="center">
                                                ${cv.allStudentCourseName}
                                        </td>
                                        <td align="center">
                                                ${cv.allStudentScore}
                                        </td>
                                    </tr>
                                    <%--                                    </c:forEach>--%>
                                </c:forEach>
                                <tr class="message-unread">
                                    <td colspan="2" align="center">
                                        <a href="http://127.0.0.1:8080/admin/addScore.do">
                                            <span style="color: greenyellow">去录入成绩</span>
                                        </a>
                                    </td>
                                    <td colspan="3" align="center">
                                        <a href="http://127.0.0.1:8080/admin/modifyScore.do">
                                            <span style="color: greenyellow">去修改成绩</span>
                                        </a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="panel-footer text-right">
                                <span>${errorMessage}</span>
                                <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
