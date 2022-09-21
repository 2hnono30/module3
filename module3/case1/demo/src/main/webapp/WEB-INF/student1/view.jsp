<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Form Elements | Zircos - Responsive Bootstrap 4 Admin Dashboard</title>
    <jsp:include page="/layout/css_head.jsp"></jsp:include>
    <link href="/assets\libs\toastr\toastr.min.css" rel="stylesheet" type="text/css">
    <style>
        table tr td{
            border: #5a6268 solid;
        }
         tr td {
            height: 50px;
        }
         th{
            border: #5a6268 solid;
         }
    </style>
</head>

<body data-layout="horizontal">

<!-- Begin page -->
<div id="wrapper">

    <!-- Navigation Bar-->
    <jsp:include page="/layout/top_nav.jsp"></jsp:include>
    <!-- End Navigation Bar-->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <!-- start page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Zircos</a></li>
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Forms</a></li>
                                    <li class="breadcrumb-item active">Form elements</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Form elements</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div class="row">
                    <div class="col-sm-12">
                        <div class="card-box">
                            <h4 class="header-title">Input Types</h4>
                            <form class="form-horizontal" method="post" enctype="multipart/form-data">
                                <fieldset>
                                    <table style="width: 80%;text-align: center;margin: 0 auto">
                                        <tr >
                                            <th>Image:</th>
                                            <td><img height="250px" width="200px" src="${requestScope["student"].getImage()}" alt=""></td>
                                        </tr>
                                        <tr >
                                            <th>Name:</th>
                                            <td>${requestScope["student"].getName()}</td>
                                        </tr>
                                        <tr>
                                            <th>Dob:</th>
                                            <td>${requestScope["student"].getDob()}</td>
                                        </tr>
                                        <tr>
                                            <th>Phone:</th>
                                            <td>${requestScope["student"].getPhone()}</td>
                                        </tr>
                                        <tr>
                                            <th>Email:</th>
                                            <td>${requestScope["student"].getEmail()}</td>
                                        </tr>
                                        <tr>
                                            <th>Address:</th>
                                            <td>${requestScope["student"].getAddress()}</td>
                                        </tr>

<%--                                        <div class="form-group row">--%>
<%--                                            <label class="col-md-2 control-label">Name</label>--%>
<%--                                            <div>--%>
<%--                                                <img ${requestScope["student"].getImage()}>--%>
<%--                                            </div>--%>
<%--                                            <div class="col-md-10">--%>
<%--                                                <input type="text" class="form-control" name="name"--%>
<%--                                                       value="${requestScope["student"].getName()}">--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group row">--%>
<%--                                            <label class="col-md-2 control-label">Dob</label>--%>
<%--                                            <div class="col-md-10">--%>
<%--                                                <input type="dob" class="form-control" name="dob"--%>
<%--                                                       value="${requestScope["student"].getDob()}">--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group row">--%>
<%--                                            <label class="col-md-2 control-label">Phone</label>--%>
<%--                                            <div class="col-md-10">--%>
<%--                                                <input type="phone" id="idPhone" class="form-control" name="phone"--%>
<%--                                                       value="${requestScope["student"].getPhone()}">--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group row">--%>
<%--                                            <label class="col-md-2 control-label" for="idEmail">Email</label>--%>
<%--                                            <div class="col-md-10">--%>
<%--                                                <input type="email" id="idEmail" name="email" class="form-control"--%>
<%--                                                       value="${requestScope["student"].getEmail()}">--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="form-group row">--%>
<%--                                            <label class="col-md-2 control-label" for="idAddress">Address</label>--%>
<%--                                            <div class="col-md-10">--%>
<%--                                                <input type="input" id="idAddress" name="address" class="form-control"--%>
<%--                                                       value="${requestScope["student"].getAddress()}">--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <button style="border-radius: 5px"><a href="/students">Black</a></button>--%>
                                    </table>
                                    <div style="text-align: center">
                                    <button style="border-radius: 5px"><a href="/students">Black</a></button>
                                    </div>
                                </fieldset>

                            </form>
                            <!-- end row -->

                        </div>
                    </div>
                </div>
                <!-- end row -->

            </div>
            <!-- end container-fluid -->

        </div>
        <!-- end content -->


        <!-- Footer Start -->
        <jsp:include page="/layout/footer.jsp"></jsp:include>
        <!-- end Footer -->

    </div>

    <!-- ============================================================== -->
    <!-- End Page content -->
    <!-- ============================================================== -->

</div>
<!-- END wrapper -->

<!-- Right Sidebar -->
<jsp:include page="/layout/right_bar.jsp"></jsp:include>

</script>

</body>

</html>
