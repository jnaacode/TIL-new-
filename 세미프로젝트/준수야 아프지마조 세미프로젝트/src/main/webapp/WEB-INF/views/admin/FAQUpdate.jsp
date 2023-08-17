<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FAQ 수정</title>



    <link rel="stylesheet" href="${contextPath}/resources/css/FAQUpdate.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/AdminHeader.css">
</head>
<body>

    <main>

        <header>
            <jsp:include page="/WEB-INF/views/admin/AdminHeader.jsp" />
        </header>

        <form action="FAQUpate2" method="POST">
        <div class="J-body">

            <jsp:include page="/WEB-INF/views/common/adminSidebar.jsp" />

            <div class="J-FAQ">

                <div class="J-F1">

                    <div class="J-F-1">
                        FAQ 수정
                    </div>
    
                    <div class="J-F-2">
                        제목 입력
                    </div>
    
                    <div class="J-F-3">
                        <input type="text" placeholder="내용을 입력해주세요." name="faqTitle" value="${faq.boardTitle}">
                    </div>
    
                    <div class="J-F-4">
                        내용입력
                    </div>
    
                    <div class="J-F-5">
                        <textarea placeholder="내용을 입력해주세요." name="faqContent" >${faq.boardContent}</textarea>
                    </div>
    
    
                    <div class="J-F-6">
                        <button>수정 취소</button>
                        <button>수정하기</button>
                    </div>

                </div>

            </div>

            <input type="hidden" name="faq1" value="${faq.boardTitle}">
            <input type="hidden" name="faq2" value="${faq.boardContent}">
        </div>
    </form>

        <jsp:include page ="/WEB-INF/views/common/footer.jsp"/>





    </main>
    
</body>
</html>