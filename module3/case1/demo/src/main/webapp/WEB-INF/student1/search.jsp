<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Basic Tables | Zircos - Responsive Bootstrap 4 Admin Dashboard</title>

    <jsp:include page="/layout/css_head.jsp"></jsp:include>
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
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Tables</a></li>
                                    <li class="breadcrumb-item active">Basic Tables</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Basic Tables</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div class="row">
                    <div class="col-sm-12">
                        <div class="card-box">
                            <label>
                                <div>
                                    <button style="border-radius: 5px">
                                        <a href="/students?action=create">Create<i class="ion ion-md-add"></i></a>
                                    </button>
                                </div>
                            </label>
                            <div class="table-responsive">
                                <table class="table m-0">

                                    <thead class="thead-light">
                                    <tr>
                                        <th>StudentId</th>
                                        <th>Name</th>
                                        <th>Classroom</th>
                                        <th>Grade</th>
                                        <th>Specialized</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${studentList}" var="item">
                                        <tr>
                                            <td>${item.getId()}</td>
                                            <td><a href="/students?action=view&&id=${item.getId()}">${item.getName()}</a></td>
                                            <td>${item.getClassroom()}</td>
                                            <td>${item.getGrade()}</td>
                                            <td>${item.getSpecialized()}</td>
                                            <td>
                                                <button style="width: 30px;border-radius: 5px" aria-label="edit"><a href="/students?action=edit&&id=${item.getId()}"><i class="ion ion-md-create"></i></a></button>
                                                <button style="width: 30px;border-radius: 5px" aria-label="remove"><a href="/students?action=delete&&id=${item.getId()}"><i class="ion ion-md-trash"></i></a></button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div>
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link">Page: </a></li>
                                        <c:forEach begin="1" end="${endPage}" var="index">
                                            <li class="page-item"><a class="page-link" href="/students?action=search&&index=${index}&&searchName=${search}">${index}</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                            <!-- end row -->

                        </div>
                        <!-- end card-box -->
                    </div>
                    <!-- end col -->
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

<jsp:include page="/layout/footer_js.jsp">
    <jsp:param name="page" value="list"/>
</jsp:include>

</body>

</html>