<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-07
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Update</title>
</head>
<body>
<div>
    <form action="/Update?id=${b.id}" method="post">
        <div class="mt-3">
            <lable>Ma</lable>
            <input type="text" class="form-control" name="ma" value="${b.ma}">
        </div>
        <div class="mt-3">
            <lable>Ten</lable>
            <input type="text" class="form-control" name="ten" value="${b.ten}">
        </div>
        <div class="mt-3">
            <lable>SoThich</lable>
            <input type="text" class="form-control" name="soThich" value="${b.soThich}">
        </div>
        <div class="mt-3">
            <lable>GioiTinh</lable>
            <input type="text" class="form-control" name="gioiTinh" value="${b.gioiTinh}">
        </div>
        <div class="mt-3">
            <lable>IdMoiQuanHe</lable>
            <select class="form-select" aria-label="Default select example" name="idMoiQuanHe">
                <option value="${b.moiQuanHe.id}" hidden selected>${b.moiQuanHe.ten}</option>
                <c:forEach items="${listMQH}" var="b2" varStatus="i">
                    <option value="${b2.id}">${b2.ten}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Update Ban</button>
    </form>
</div>
</body>
</html>

<%--<option value="${b.id}" hidden selected>${b.ten}</option>--%>
<%--<c:forEach items="${listMQH}" var="b" varStatus="i">--%>
<%--    <option value="${b.id}">${b.ten}</option>--%>
<%--</c:forEach>--%>
