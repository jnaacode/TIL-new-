<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 게시글 관리</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/AdminBoardManage.css">
    <link rel="stylesheet" href="${contextPath}/webapp/resources/css/sidebar.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>

	<jsp:include page="/WEB-INF/views/admin/AdminHeader.jsp"/>

    <div class="H-main">

        
        <jsp:include page="/WEB-INF/views/common/adminSidebar.jsp"/>
        
        <div class="H-div">
        
        <div class="H-maindisplay">
            <div class="H-list">

                    <div class="H-write">게시글 관리</div>


                    <div class="H-div">

                        <a href="${contextPath}/admin/FAQ" class="H-href">
                            <span class="H-span">FAQ 작성</span>
                        </a>

                        <a href="${contextPath}/admin/AdminBoardList" class="H-href">
                            <span class="H-span">공지사항</span>
                        </a>

                    </div>

	

                </div>
            </div>



        </div>

    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>

</html>