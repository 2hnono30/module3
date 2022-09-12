<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/09/2022
  Time: 3:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Result</title>
</head>
<br>
<h1>Result</h1>
${requestScope.first_operand} ${requestScope.operator} ${requestScope.second_operand} = ${requestScope.result}</br>
<c:set var="num" value="${first_operand}"/>
<fmt:formatNumber value="${num}" type="currency"/>
${requestScope.operator}
<c:set var="num" value="${second_operand}"/>
<fmt:formatNumber value="${num}" type="currency"/>=
<c:set var="num" value="${result}"/>
<fmt:formatNumber value="${num}" type="currency"/></br>
<h6>Ngay tao</h6>
<fmt:formatDate pattern="dd-MM-yyyy" type="both" value="${requestScope.date}"/>
</body>
</html>
