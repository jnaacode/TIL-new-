<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminHeader</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/AdminHeader.css">
</head>
<body>

    <header>
        <div class="K-header">
            <div><a href="${contextPath}/admin/memberAdmin?type=1">관리자 페이지</div>
            <div><a href="${contextPath}"><img src="${contextPath}/resources/images/logo_b_2.png"  class="headerAd"></a></div>
            <div>
                <a href="${contextPath}/member/logout">로그아웃</a>
            </div>

        </div>
    </header>
    
    
</body>
</html>