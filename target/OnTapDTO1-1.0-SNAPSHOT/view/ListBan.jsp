<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-05
  Time: 08:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div>
        <form action="/Add" method="post">
            <div class="mt-3">
                <lable>Ma</lable>
                <input type="text" class="form-control" name="ma">
            </div>
            <div class="mt-3">
                <lable>Ten</lable>
                <input type="text" class="form-control" name="ten">
            </div>
            <div class="mt-3">
                <lable>SoThich</lable>
                <input type="text" class="form-control" name="soThich">
            </div>
            <div class="mt-3">
                <lable>GioiTinh</lable>
                <input type="text" class="form-control" name="gioiTinh">
            </div>
            <div class="mt-3">
                <lable>IdMoiQuanHe</lable>
                <select class="form-select" aria-label="Default select example" name="idMoiQuanHe">
                    <c:forEach items="${listMQH}" var="b" varStatus="i">
                        <option value="${b.id}">${b.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-success">Add Ban</button>
        </form>
    </div>
    <table class="table">
        <thead>
        <th>STT</th>
        <th>Ma ban</th>
        <th>Ten ban</th>
        <th>So thich</th>
        <th>Gioi tinh</th>
        <th>Ten MQH</th>
        <th>Hanh Dong</th>
        </thead>
        <tbody>
        <c:forEach items="${currentPageProducts}" var="a" varStatus="i">
            <tr>
                <td>${i.count}</td>
                <td>${a.ma}</td>
                <td>${a.ten}</td>
                <td>${a.soThich}</td>
                <td>${a.gioiTinh}</td>
                <td>${a.tenMoiQuanHe} </td>

                <td>
                    <a href="/ViewUpdate?id=${a.id}" class="btn btn-success" onclick="return confirm('ViewUpdate?')">Update</a>
                    <a href="/Delete?id=${a.id}" class="btn btn-success" onclick="return confirm('Xoá?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="container mt-4">
        <div class="row">
            <div class="col-12 d-flex justify-content-center">
                <c:if test="${pageNumber > 1}">
                    <a href="/HienThi?page=${pageNumber - 1}" class="btn-page"><<</a>
                </c:if>

                <span class="btn-page-number">${pageNumber}</span>

                <c:if test="${pageNumber < totalPages}">
                    <a href="/HienThi?page=${pageNumber + 1}" class="btn-page">>></a>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
