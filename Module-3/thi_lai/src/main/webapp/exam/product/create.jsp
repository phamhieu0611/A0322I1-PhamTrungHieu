<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 9/14/2022
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta charset="UTF-8">
    <title>Create customer</title>
    <link rel="stylesheet" href="/assets/css/index.css">
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
                        <h2>
                            Add new customer
                        </h2>
                        <a href="/phongtro">Return List</a>
                        <c:if test="${error != null}">
                            <h2 style="color: red">${error}</h2>
                        </c:if>
                        <div class="body">
                            <form action="/phongtro?action=create" method="post">

                                <label for="ma_phong">Ma tro: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="ma_tro" required class="form-control" placeholder="ma phong" tabindex="1" autofocus="autofocus" id="ma_phong" />
                                    </div>
                                </div>

                                <label for="ten_nguoi_thue">Ten nguoi thue: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="ten_nguoi_thue" required class="form-control" placeholder="ten nguoi thue" tabindex="2" autofocus="autofocus" id="ten_nguoi_thue" />
                                    </div>
                                </div>

                                <label for="so_dien_thoai">So dien thoai: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="so_dien_thoai" min="0" class="form-control" placeholder="so dien thoai" tabindex="3" autofocus="autofocus" id="so_dien_thoai" />
                                    </div>
                                </div>

                                <label for="ngay_thue">Ngay thue: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="date" name="ngay_thue" class="form-control" placeholder="ngay thue" tabindex="4" id="ngay_thue" />
                                    </div>
                                </div>

                                <label for="ghi_chu">Ghi chu: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="ghi_chu" class="form-control" placeholder="ghi chu" tabindex="5" autofocus="autofocus" id="ghi_chu" />
                                    </div>
                                </div>

                                <label for="ma_thanh_toan">Loai Thanh Toan: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <select name="ma_thanh_toan" class="form-control" id="ma_thanh_toan">
                                            <c:forEach items="${loaiThanhToans}" varStatus="item">
                                                <option value="${item.current.ma_thanh_toan}">${item.current.loai_thanh_toan}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <button type="reset" class="btn btn-primary btn-custom" tabindex="6"><i class="fa fa-check" aria-hidden="true"></i> Reset</button>
                                <button type="submit" class="btn btn-primary btn-custom" tabindex="7"><i class="fa fa-check" aria-hidden="true"></i> Add</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/exam/layout/script.jsp" />
</body>
</html>
