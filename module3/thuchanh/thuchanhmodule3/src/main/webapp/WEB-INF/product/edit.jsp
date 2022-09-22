<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Form Elements | Zircos - Responsive Bootstrap 4 Admin Dashboard</title>
    <jsp:include page="/layout/css_head.jsp"></jsp:include>
    <link href="/assets\libs\toastr\toastr.min.css" rel="stylesheet" type="text/css">

</head>

<body data-layout="horizontal">

<!-- Begin page -->
<div id="wrapper">

    <!-- Navigation Bar-->

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
                            <h4 class="page-title">Product</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div class="row">
                    <div class="col-sm-12">
                        <div class="card-box">
                            <h4 class="header-title">Add new product</h4>
                            <form class="form-horizontal" method="post" action="/products?action=edit&id=${requestScope["product"].getId()}">
<%--                                <input name="id" value="${requestScope["product"].getId()}" hidden>--%>
                                <div class="form-group row">
                                    <label class="col-md-2 control-label">Name</label>
                                    <div class="col-md-10">
                                        <input type="text" class="form-control" name="name" value="${requestScope["product"].getProductName()}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-md-2 control-label" for="idPrice">Price</label>
                                    <div class="col-md-10">
                                        <input type="text" id="idPrice" name="price" class="form-control" value="${requestScope["product"].getPrice()}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-md-2 control-label" for="idQuantily" required>Quantily</label>
                                    <div class="col-md-10">
                                        <input type="text" id="idQuantily" name="quantily" class="form-control" value="${requestScope["product"].getQuantily()}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-md-2 control-label" for="idColor" required>Color</label>
                                    <div class="col-md-10">
                                        <input type="text" id="idColor" name="color" class="form-control" value="${requestScope["product"].getColor()}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-md-2 control-label" for="idStatus" required>Status</label>
                                    <div class="col-md-10">
                                        <input aria-label="" id="idStatus" name="status" class="form-control" value="${requestScope["product"].getStatus()}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-md-2 control-label" for="idCatelory">Catelory</label>
                                    <div class="col-md-10">
                                        <select id="idCatelory" name="catelory" class="form-control">
                                            <option>Phone</option>
                                            <option>TV</option>
                                        </select>
                                    </div>
                                </div>
                                <div style="text-align: center">
                                    <button style="border-radius: 5px">Create</button>
                                    <button style="border-radius: 5px"><a href="/products">Black</a></button>
                                </div>

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


    </div>

    <!-- ============================================================== -->
    <!-- End Page content -->
    <!-- ============================================================== -->

</div>
<!-- END wrapper -->

<!-- Right Sidebar -->

<c:if test="${requestScope.message !=null}">
    <script>

        window.onload = function(e){
            toastr["success"]("Sửa thanh cong!");
        }
    </script>
</c:if>

<jsp:include page="/layout/footer_js.jsp">
    <jsp:param name="page" value="create"/>
    <jsp:param name="toast" value="create"/>
</jsp:include>
<script>

    toastr.options = {
        "closeButton": true,
        "debug": false,
        "newestOnTop": false,
        "progressBar": true,
        "positionClass": "toast-top-right",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "5000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }

</script>

</body>

</html>
