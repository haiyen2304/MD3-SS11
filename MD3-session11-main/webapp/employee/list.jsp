<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 25/07/2024
  Time: 2:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach nhan vien</h1>
<a href="/EmployeeServlet?action=ADD">Them moi</a>
<table border="5" cellspacing="10" cellpadding="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Age</th>
        <th>Sex</th>
        <th>Image</th>
        <th>Address</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="em" varStatus="loop">
    <tr>
        <td>${loop.count}</td>
        <td>${em.name}</td>
        <td>${em.formatDate()}</td>
        <td>${em.sex?"Nam":"Nu"}</td>
        <td><img src="${em.image}" width="100px" height="100px" style="object-fit: cover"> </td>
        <td>${em.address}</td>
        <td><a href="">Edit</a> </td>
        <td><a href="">Delete</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
