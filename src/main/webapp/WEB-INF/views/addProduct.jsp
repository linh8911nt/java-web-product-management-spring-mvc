<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhlinh
  Date: 5/25/18
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h1>Add Product </h1>
<h3>${message}</h3>

<form:form action="addProduct" method="post" modelAttribute="addProduct">
    <table>
        <tr>
            <td><form:label path="code">Product Code: </form:label></td>
            <td><form:input path="code"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Product Name: </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="price">Price:</form:label></td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td><form:label path="category_id">Category: </form:label></td>
            <td><form:select path="category_id" items="${categories_id}"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>

    </table>
</form:form>
</body>
</html>
