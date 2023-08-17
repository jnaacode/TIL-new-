<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="boardName" value="${map.boardName}"/>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="boardList" value="${map.boardList}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 게시글 작성</title>

    <link href="https://cdn.jsdelivr.net/npm/bootsdivap@5.2.3/dist/css/bootsdivap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/7bc7245179.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css"> 
    <link rel="stylesheet" href="${contextPath}/resources/css/postWrite.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>

<body>
   <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <div class="C-body">
            <form action="${contextPath}/admin/AdminBoardList" method="post" name="C-postWrite-main" onsubmit="return inputcheck()">
                <div class="C-postWrite-body">
                    <div class="C-postWrite-title">공지사항 작성</div>
                
                        <div class="C-input-table">
                            <div class="L-title L-detail">
                                <div>제목</div>
                                <div><input type="text" name="L-input-title" id="C-postWrite-title" placeholder="제목을 입력해주세요" autocomplete="off"></div>
                            </div>
                
                            <div class="L-person L-detail">
                                <div>작성자</div>
                                <div><input type="text" name="L-input-person" value="${loginMember.memberName}" placeholder="작성자" disabled></div>
                                <input type="hidden" name="memberNo" value="${loginMember.memberNo}">
                              
                            </div>
                            
                            <div class="L-text L-detail">
                                <div>내용</div>
                                <div><textarea name="L-textarea-text" id="C-postWritearea"></textarea></div>
                            </div>

                        </div>
                  
                    <div class="C-btn-container">
                        <div class="C-btn-cancel">
                            <button type="button" id="C-postWritebtn-cancel">
                                <a href="${contextPath}/board/qna?type=2&cp=1" id="C-post-cancel">공지사항 작성 취소</a>
                            </button>
                        </div>
                        <div class="C-btn-clear">
                            <button id="C-postWritebtn-clear">
                                공지사항 작성
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
      
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="${contextPath}/resources/js/postWrite.js"></script> <!-- 바디js -->
    <script src="https://cdn.jsdelivr.net/npm/bootsdivap@5.2.3/dist/js/bootsdivap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/header.js"></script> <!-- 헤더 js -->
</body>

</html>