<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 게시글 수정</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css"> <!-- 헤더 스타일 -->
    <link rel="stylesheet" href="${contextPath}/resources/css/postWrite.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css"><!-- 풋터 스타일 -->

     <!-- j쿼리 url -->
     <script src="resources/js/jquery-3.7.0.min.js"></script>
    <!-- 폰트 url -->
    <script src="https://kit.fontawesome.com/7bc7245179.js" crossorigin="anonymous"></script>
    <!-- 부트스트랩 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
    <!----------------------------------------헤더 --------------------------------------------->
   	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <!----------------------------------------헤더 --------------------------------------------->

        <div class="C-body">
            <form action="${contextPath}/admin/AdminBoardList/detail?no=${board.boardNo}" method="post" name="C-postWrite-main">
                <div class="C-postWrite-body">
                    <div class="C-postWrite-title">공지사항 수정</div>
                    
                
                        <div class="C-input-table">
                            <div class="L-title L-detail">
                                <div>제목</div>
                                <div><input type="text" name="L-input-title" id="C-postWrite-title" value="${board.boardTitle}" placeholder="제목"></div>
                            </div>
                
                            <div class="L-person L-detail">
                                <div>작성자</div>
                                <div><input type="text" name="L-input-person" value="${board.memberId}" placeholder="작성자" disabled></div>
                                <div></div>
                                <div>작성일</div>
                                <div><input type="text" name="L-date" value="${board.boardDate}" placeholder="작성일" disabled></div>
                            </div>
                            <div class="L-text L-detail">
                                <div>내용</div>
                                <div><textarea name="L-textarea-text" id="C-postWritearea">${board.boardContent}</textarea></div>
                            </div>

                        </div>
                  
                    <div class="C-btn-container">
                        <div class="C-btn-cancel">
                            <button type="button" id="C-postWritebtn-cancel">
                                <a href="${contextPath}/board/qna/boardDetail?type=2&cp=${param.cp}&no=${param.no}" id="C-post-cancel">공지사항 수정 취소</a>
              
                            </button>
                        </div>
                            <button type="submit" id="C-postWritebtn-clear">
                                공지사항 수정
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
      
     <!----------------------------------------풋터 --------------------------------------------->
     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <!----------------------------------------풋터 --------------------------------------------->

    <script src="../webapp/resources/js/postWrite.js"></script> <!-- 바디js -->
    <script src="https://cdn.jsdelivr.net/npm/bootsdivap@5.2.3/dist/js/bootsdivap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="../webapp/resources/js/header.js"></script> <!-- 헤더 js -->
</body>

</html>