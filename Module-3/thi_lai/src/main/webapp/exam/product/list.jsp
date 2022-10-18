<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/9/2022
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Title</title>
    <jsp:include page="/exam/layout/header.jsp" />

</head>
<body>
<jsp:include page="/exam/layout/page-loader.jsp" />
<jsp:include page="/exam/layout/navbar.jsp" />
<jsp:include page="/exam/layout/sidebar.jsp" />
<section class="content">
    <div class="container-fluid">
        <!-- Vertical Layout -->
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Product list</h2>
                    </div>
                    <div class="body table-responsive">
                        <a href="/phongtro?action=create" class="btn btn-primary btn-custom">
                            <i class="fa fa-plus-circle" aria-hidden="true"></i> Add new product
                        </a>
                        <table class="table table-striped" id="dataTable-listMember">
                            <thead>
                            <tr>
                                <th>No</th>
                                <th>Ma tro</th>
                                <th>Ten nguoi thue</th>
                                <th>So dien thoai</th>
                                <th>Ngay thue</th>
                                <th>Hinh thuc thanh toan</th>
                                <th>Ghi chu</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${phongTros}" varStatus="item">
                                <tr>
                                    <td>${item.count }</td>
                                    <td>${item.current.ma_tro}</td>
                                    <td>${item.current.ten_nguoi_thue}</td>
                                    <td>${item.current.so_dien_thoai}</td>
                                    <td>${item.current.ngay_thue}</td>
                                    <td>${item.current.ma_thanh_toan}</td>
                                    <td>${item.current.ghi_chu}</td>
                                    <td>
<%--                                        <a href="/phongtro?action=delete&id=${item.current.ma_phong_tro}">DELETE</a>--%>

    <a href="/phongtro?action=delete&id=${item.current.ma_phong_tro}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
        <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
    </svg></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/exam/layout/script.jsp" />
</body>
</html>
