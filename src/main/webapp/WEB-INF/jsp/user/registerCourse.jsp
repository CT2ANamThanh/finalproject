
<%-- 
    Document   : customer
    Created on : Oct 16, 2020, 9:01:44 AM
    Author     : Administrator
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="x-ua-compatible" content="ie=edge">

        <title>Đăng Ký Học</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


        <link rel="stylesheet" href="${pageContext.request.contextPath}/ADMIN/plugins/fontawesome-free/css/all.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/ADMIN/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/ADMIN/dist/css/adminlte.min.css">

        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    </head>
    <body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
        <div class="wrapper">

            <nav class="main-header navbar navbar-expand navbar-white navbar-light">

                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
                    </li>



                </ul>

                <!-- SEARCH FORM -->





            </nav>
            <!-- /.navbar -->

            <!-- Main Sidebar Container -->
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <!-- Brand Logo -->
                <a href="homePage" class="brand-link">
                    <img src="${pageContext.request.contextPath}/ADMIN/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
                         style="opacity: .8">
                    <span class="brand-text font-weight-light">Trung Tâm Lập Trình Viên </span>
                </a>

                <!-- Sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                        <div class="image">
                            <img style="margin-top: 15px;" src="${pageContext.request.contextPath}/ADMIN/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                        </div>

                        <div class="info">
                            <a style="margin-top: 10px;" href="${pageContext.request.contextPath}/user/infomation" class="d-block"><h2>${lastName}</h2></a>

                        </div>

                    </div>

                    <!-- Sidebar Menu -->
                    <nav class="mt-2">
                        <ul style="margin-top: 30px;" class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                            <!-- Add icons to the links using the .nav-icon class
                                 with font-awesome or any other icon font library -->
                            <li class="nav-item has-treeview menu-open">

                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/user/courseHomePage/1" class="nav-link">
                                            <i ></i>
                                            <h3>Chương Trình Học</h3>
                                        </a>
                                    </li>

                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/user/batchHomePage/1" class="nav-link ">
                                            <i ></i>
                                            <h2>Lớp</h2>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/user/centerHomePage" class="nav-link">
                                            <i ></i>
                                            <h3>Trung Tâm</h3>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/logout" class="nav-link">
                                    <i ></i>
                                    <h4>
                                        Đăng Xuất

                                    </h4>
                                </a>
                            </li>


                        </ul>
                    </nav>

                </div>

            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="jumbotron text-center">
                <h1 class="display-3">Thank You!</h1>
                <p class="lead"><strong>Please check your email</strong> for further instructions on how to complete your account setup.</p>
                <hr>
                <p>
                    Having trouble? <a href="">Contact us</a>
                </p>
                <p class="lead">
                    <a class="btn btn-primary btn-sm" href="https://bootstrapcreative.com/" role="button">Continue to homepage</a>
                </p>
            </div>

        </div>



        <aside class="control-sidebar control-sidebar-dark">
            <!-- Control sidebar content goes here -->
        </aside>



    </div>
    <!-- ./wrapper -->

    <!-- REQUIRED SCRIPTS -->
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/ADMIN/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath}/ADMIN/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- overlayScrollbars -->
    <script src="${pageContext.request.contextPath}/ADMIN/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
    <!-- AdminLTE App -->
    <script src="${pageContext.request.contextPath}/ADMIN/dist/js/adminlte.js"></script>

    <!-- OPTIONAL SCRIPTS -->
    <script src="${pageContext.request.contextPath}/ADMIN/dist/js/demo.js"></script>

    <!-- PAGE PLUGINS -->
    <!-- jQuery Mapael -->
    <script src="${pageContext.request.contextPath}/ADMIN/plugins/jquery-mousewheel/jquery.mousewheel.js"></script>
    <script src="${pageContext.request.contextPath}/ADMIN/plugins/raphael/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/ADMIN/plugins/jquery-mapael/jquery.mapael.min.js"></script>
    <script src="${pageContext.request.contextPath}/ADMIN/plugins/jquery-mapael/maps/usa_states.min.js"></script>
    <!-- ChartJS -->
    <script src="${pageContext.request.contextPath}/ADMIN/plugins/chart.js/Chart.min.js"></script>

    <!-- PAGE SCRIPTS -->
    <script src="${pageContext.request.contextPath}/ADMIN/dist/js/pages/dashboard2.js"></script>
</body>
</html>
