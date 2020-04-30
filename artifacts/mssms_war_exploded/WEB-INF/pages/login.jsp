<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from admindesigns.com/demos/absolute/1.1/pages_login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 06 Aug 2015 02:55:38 GMT -->
<head>
    <meta charset="utf-8">
    <title>欢迎使用爱慕课OA</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme" />
    <meta name="description" content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
    <meta name="author" content="AbsoluteAdmin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/statics/assets/img/favicon.ico">
</head>

<body class="external-page external-alt sb-l-c sb-r-c">

<!-- Start: Main -->
<div id="main" class="animated fadeIn">

    <!-- Start: Content-Wrapper -->
    <section id="content_wrapper">

        <!-- Begin: Content -->
        <section id="content">

            <div class="admin-form theme-info mw500" id="login">

                <!-- Login Logo -->
                <div class="content-header">
                    <h1>胡雪峰OA</h1>
                    <p class="lead">欢迎使用xuefeng成绩管理系统</p>
                </div>
                <!-- Login Panel/Form -->
                <div class="panel mt30 mb25">

                    <form method="post" action="http://127.0.0.1:8080/login/toLogin" id="contact">
                        <div class="panel-body bg-light p25 pb15">


                            <!-- Username Input -->
                            <div class="section">
                                <label for="username" class="field-label text-muted fs18 mb10">工号</label>
                                <label for="username" class="field prepend-icon">
                                    <input type="text" name="username" id="username" class="gui-input" placeholder="请输入工号...">
                                    <label for="username" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>

                            <!-- Password Input -->
                            <div class="section">
                                <label for="username" class="field-label text-muted fs18 mb10">密码</label>
                                <label for="password" class="field prepend-icon">
                                    <input type="password" name="password" id="password" class="gui-input" placeholder="请输入密码...">
                                    <label for="password" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>

                        <div class="panel-footer clearfix">
                            <button type="submit" class="button btn-primary mr10 pull-right">登陆</button>
                            <label class="switch ib switch-primary mt10">
                                <input type="checkbox" name="remember" id="remember" checked>
                                <label for="remember" data-on="是" data-off="否"></label>
                                <span>记住我</span>
                                <span style="color: red">
                                    ${error}
                                </span>
                            </label>
                        </div>

                    </form>
                </div>



            </div>

        </section>
        <!-- End: Content -->

    </section>
    <!-- End: Content-Wrapper -->

</div>
<!-- End: Main -->


<!-- BEGIN: PAGE SCRIPTS -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/statics/vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/vendor/jquery/jquery_ui/jquery-ui.min.js"></script>

<!-- Theme Javascript -->
<script src="${pageContext.request.contextPath}/statics/assets/js/utility/utility.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/demo/demo.js"></script>
<script src="${pageContext.request.contextPath}/statics/assets/js/main.js"></script>

<!-- END: PAGE SCRIPTS -->

</body>


<!-- Mirrored from admindesigns.com/demos/absolute/1.1/pages_login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 06 Aug 2015 02:55:42 GMT -->
</html>
