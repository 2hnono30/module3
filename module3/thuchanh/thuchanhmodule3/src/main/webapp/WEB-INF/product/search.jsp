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



    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">
                <form action="/products?action=search" class="app-search" method="post">
                    <div class="app-search-box">
                        <div class="input-group">
                            <input style="text-align: center" type="text" name="txtSearch" class="form-control" placeholder="Search...">
                            <div style="background-color: #00aced" class="input-group-append">
                                <button class="btn" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card-box">
                            <label>
                                <div>
                                    <button style="border-radius: 5px">
                                        <a href="/products?action=create">Create<i class="ion ion-md-add"></i></a>
                                    </button>
                                </div>
                            </label>
                            <div class="table-responsive">
                                <table class="table m-0">

                                    <thead class="thead-light">
                                    <tr>
                                        <th>Id</th>
                                        <th>ProductName</th>
                                        <th>Price</th>
                                        <th>Quantily</th>
                                        <th>Color</th>
                                        <th>Status</th>
                                        <th>Catelory</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${productList}" var="item">
                                            <tr>
                                                <td>${item.getId()}</td>
                                                <td>${item.getProductName()}</td>
                                                <td>${item.getPrice()}</td>
                                                <td>${item.getQuantily()}</td>
                                                <td>${item.getColor()}</td>
                                                <td>${item.getStatus()}</td>
                                                <td>${item.getCatelory()}</td>
                                                <td>
                                                    <button style="width: 30px;border-radius: 5px"><a href="/products?action=edit&id=${item.getId()}"><i class="ion ion-md-create"></i></a></button>
                                                    <button style="width: 30px;border-radius: 5px"><a href="/products?action=delete&id=${item.getId()}"><i class="ion ion-md-trash"></i></a></button>
                                                </td>
                                            </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- end row -->

                        </div>
                        <!-- end card-box -->
                    </div>
                    <!-- end col -->
                </div>
                <!-- end row -->

            </div>


        </div>

    </div>



</div>


</body>

</html>
