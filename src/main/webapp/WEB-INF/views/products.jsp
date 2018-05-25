<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhlinh
  Date: 5/25/18
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1><a href="/showFormAddProduct">Add Product</a> </h1>

<table border="1">
    <tr>
        <td>Code</td>
        <td>Name</td>
        <td>Price</td>
        <td>Category</td>
    </tr>
    <c:forEach items='${products}' var="product">
        <tr>
            <td>${product.getCode()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getCategory()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
