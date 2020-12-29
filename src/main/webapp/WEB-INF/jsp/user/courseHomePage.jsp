
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
                <a href="${pageContext.request.contextPath}/user/homePage" class="brand-link">
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
                        <ul style="margin-top: 50px;" class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                            <!-- Add icons to the links using the .nav-icon class
                                 with font-awesome or any other icon font library -->
                            <li class="nav-item has-treeview menu-open">

                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/user/courseHomePage/1" class="nav-link">
                                            <i ></i>
                                            <h4>Chương Trình Học</h4>
                                        </a>
                                    </li>

                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/user/batchHomePage/1" class="nav-link ">
                                            <i ></i>
                                            <h4>Lớp</h4>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/user/centerHomePage" class="nav-link">
                                            <i ></i>
                                            <h4>Trung Tâm</h4>
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

            <div style="background:white url(data:image/jpeg;base64,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) repeat fixed;width:1000px;height:200px;" class="content-wrapper">

                <!-- Content Header (Page header) -->
                <div class="content-header">
                    <form class="example" action="${pageContext.request.contextPath}/search7" method="get" style="margin:auto;">
                        <input style=" margin-left: 300px;width: 400px; height: 30px" type="text" name="searchText" id="searchText" value="${model.productList}" placeholder="Search...">
                        <button style= "color: red ;width: 50px; height: 30px" type="submit"><i class="fa fa-search"></i></button>

                    </form>
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1 style="color: red;" class="m-0 text-dark">Đăng Ký Học</h1>
                            </div>                           
                        </div>
                    </div>
                </div>
                <!-- List Product -->
                <div style="width: 900px;margin-left: 20px;" class="card">
                    <!-- /.card-header -->

                    <table class="table table-hover">

                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Tên Môn Học</th>
                                <th>Ngày Bắt Đầu</th>                             
                                <th>Trung Tâm</th>

                            </tr>
                        </thead>  
                        <tbody>
                            <c:forEach var="course" items="${courseList}"> 
                                <tr>
                                    <td>${course.id}</td>
                                    <td>${course.name}</td>
                                    <td>${course.startDate}</td>                                  
                                    <td>${course.center.name}</td>
                                    <th><a href="${pageContext.request.contextPath}/registerCourse/${product.id}">Đăng Ký Học</a></th>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <!-- /.card-body -->
                    <ul class="pagination pagination-sm">
                        <li class="page-item"><a class="page-link" href='<c:url value="/user/courseHomePage/1"/>'>1</a></li>
                        <li class="page-item"><a class="page-link" href='<c:url value="/user/courseHomePage/2"/>'>2</a></li>
                        <li class="page-item"><a class="page-link" href='<c:url value="/user/courseHomePage/3"/>'>3</a></li>
                    </ul>

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
