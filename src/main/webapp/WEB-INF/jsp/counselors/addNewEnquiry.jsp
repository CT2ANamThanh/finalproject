<%-- 
    Document   : addNewEnquiry
    Created on : Dec 8, 2020, 8:38:35 AM
    Author     : Administrator
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>ADMIN</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Font Awesome Icons -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/ADMIN/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/ADMIN/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/ADMIN/plugins/fontawesome-free/css/all.min.css">
        <!-- overlayScrollbars -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/ADMIN/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/ADMIN/dist/css/adminlte.min.css">
        <!-- Google Font: Source Sans Pro -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    </head>
    <body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
        <div class="wrapper">
            <!-- Navbar -->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
                <!-- Left navbar links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
                    </li>


                    

                </ul>

                <!-- SEARCH FORM -->


                <!-- Right navbar links -->

            </nav>
            <!-- /.navbar -->

            <!-- Main Sidebar Container -->
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <!-- Brand Logo -->
                <a href="counselors" class="brand-link">
                    <img src="${pageContext.request.contextPath}/ADMIN/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
                         style="opacity: .8">
                    <span class="brand-text font-weight-light">ACADEMY</span>
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
                        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                            <!-- Add icons to the links using the .nav-icon class
                                 with font-awesome or any other icon font library -->
                            <li class="nav-item has-treeview menu-open">
                                
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="student2" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Manage Student Info</p>
                                        </a>
                                    </li><br>
                                    <li class="nav-item">
                                        <a href="enquiry" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Manage Enquiry</p>
                                        </a>
                                    </li><br>
                                    <li class="nav-item">
                                        <a href="follow" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Follow Up</p>
                                        </a>
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
                            </li>


                        </ul>
                    </nav>

                </div>

            </aside>

            <!-- Content Wrapper. Contains page content -->
            <<div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <div class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1 class="m-0 text-dark">Add New</h1>
                            </div>                           
                        </div>
                    </div>
                </div>

                <mvc:form modelAttribute="enquiry" action="addNewEnquiry" method="post">
                    <table>
                        
                        
                        
                        <tr>
                            <td>Name(*):</td>
                            <td><mvc:input path="name" required="true"/></td>
                        </tr>
                        <tr>
                            <td>Enquiry Date(*):</td>
                            <td><mvc:input path="equiryDate" type="Date"/></td>
                        </tr>
                        
                        <tr>
                            <td>Gender(*):</td>
                            <td><mvc:input path="sex" required="true"/></td>
                        </tr>
                        <tr>
                            <td>Address(*):</td>
                            <td><mvc:input path="address" required="true"/></td>
                        </tr>
                        <tr>
                            <td>Major(*):</td>
                            <td><mvc:input path="major" required="true"/></td>
                        </tr>

                        <tr>
                            <td>Source Name (*):</td>
                            <td><mvc:input path="sourceName" required="true"/></td>
                        </tr>
                        <tr>
                            <td>Enquiry Status(*):</td>
                            <td><mvc:input path="enquiryStatus" required="true"/></td>
                        </tr>
                        
                        
                        <tr>
                            <td colspan="2"><input type="submit" value="save"></td>
                        </tr>
                    </table>
                </mvc:form>



                <!-- Control Sidebar -->
                <aside class="control-sidebar control-sidebar-dark">
                    <!-- Control sidebar content goes here -->
                </aside>
                <!-- /.control-sidebar -->

                <!-- Main Footer -->
                <footer class="main-footer">
                    <strong>Copyright &copy; 2020 <a>ATHENA Co</a>.</strong>
                    All rights reserved.
                    <div class="float-right d-none d-sm-inline-block">
                        <b>Version</b> 3.0.5
                    </div>
                </footer>




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
            <!-- DataTables -->
            <script src="${pageContext.request.contextPath}/ADMIN/plugins/datatables/jquery.dataTables.min.js"></script>
            <script src="${pageContext.request.contextPath}/ADMIN/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
            <script src="${pageContext.request.contextPath}/ADMIN/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
            <script src="${pageContext.request.contextPath}/ADMIN/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>

    </body>
</html>
