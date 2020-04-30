<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="top.jsp"/>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from admindesigns.com/demos/absolute/1.1/admin_forms-validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 06 Aug 2015 02:56:15 GMT -->
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">

    <title> 胡雪峰OA--欢迎使用胡雪峰OA系统 </title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/statics/assets/img/favicon.ico">
</head>

<body class="admin-validation-page" data-spy="scroll" data-target="#nav-spy" data-offset="200">
<div id="main">
    <header class="navbar navbar-fixed-top navbar-shadow">
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown menu-merge">
                <a href="#" class="dropdown-toggle fw600 p15" data-toggle="dropdown">
                    <img src="${pageContext.request.contextPath}/statics/assets/img/avatars/2.jpg" alt="avatar" class="mw30 br64">
                    <span class="hidden-xs pl15">
                        ${info.teachname}
                    </span>
                    <span class="caret caret-tp hidden-xs"></span>
                </a>
                <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
                    <li class="list-group-item">
                        <a href="/modifyPassword/modifyTeacherPassword.do?teachno=${info.teachno}" class="animated animated-short fadeInUp">
                            <span class="fa fa-gear"></span> 设置密码 </a>
                    </li>
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
            <h2> 个人信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 基本信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">姓名</div>
                        <div class="col-md-4">${info.teachname}</div>
                        <div class="col-md-2">性别</div>
                        <div class="col-md-4">${info.sex}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">身份</div>
                        <div class="col-md-4">${idinfo}</div>
                        <div class="col-md-2"></div>
                        <div class="col-md-4"></div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">查询学生成绩</div>
                        <div class="col-md-4">
                            <a href="http://127.0.0.1:8080/score/goQueryStudentScore">
                                <span style="color: greenyellow">学生成绩单</span>
                            </a>
                        </div>
                        <div class="col-md-2">查询班级成绩</div>
                        <div class="col-md-4">
                            <a href="http://127.0.0.1:8080/score/goStudentScoreByClassAndCourse">
                                <span style="color: greenyellow">班级成绩单</span>
                            </a>
                        </div>
                    </div>
                    <div class="panel-footer text-right">
                        <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>