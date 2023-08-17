<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 이벤트 작성</title>
    
    <link rel="stylesheet" href="${contextPath}/resources/css/AdminEventWrite.css">

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/admin/AdminHeader.jsp"/>
    
    <div class="K-first">
        <div>
            <jsp:include page="/WEB-INF/views/common/adminSidebar.jsp"/>
            
            <div class="K-all">
                <div>
                    <div>이벤트 작성</div>

                    <form action="${contextPath}/admin/eventWrite" enctype="multipart/form-data" method="post" id="K-form" onsubmit="return eventValidate()">
                        <div>제목 입력</div>
                        <div>
                            <input type="text" placeholder="내용을 입력해주세요" name="K-title" value="${event.eventTitle}">
                        </div>

                        <div>
                            <label for="K-date">마감일</label>
                            <input type="date" name="K-date" id="K-date">
                        </div>
                        <div>
                            <span>내용입력</span>
                            <!-- <div>
                                <input type="file" name="K-photo" id="K-photo" multiple/>
                                <div id="K-image-select"></div>
                            </div> -->

                            <c:forEach items="${event.imageList}" var="Eimage">
                                <c:choose>
                                    <c:when  test="${Eimage.imageLevel == 0}">
                                        <c:set var="img0" value="${contextPath}${Eimage.imageRename}"/>
                                    </c:when>
                                    
                                    <c:when  test="${Eimage.imageLevel == 1}">
                                        <c:set var="img1" value="${contextPath}${Eimage.imageRename}"/>
                                    </c:when>
                                    
                                    <c:when  test="${Eimage.imageLevel == 2}">
                                        <c:set var="img2" value="${contextPath}${Eimage.imageRename}"/>
                                    </c:when>

                                    <c:when  test="${Eimage.imageLevel == 3}">
                                        <c:set var="img3" value="${contextPath}${Eimage.imageRename}"/>
                                    </c:when>

                                </c:choose>
                            </c:forEach>

                            <h5>썸네일</h5>
                            <div class="k-img-box k-thumbnail">
                                <label for="k-img0">
                                    <img class="k-preview" src="${img0}">
                                </label>
                                <input type="file" class="k-inputImg" name="0" id="k-img0" accept="image/*">
                                <span class="k-deleteImg">&times;</span>
                            </div>

                            <h5>업로드 이미지</h5>
                            <div class="k-upload-img">
                                <div class="k-img-box k-upload">
                                    <label for="k-img1">
                                        <img class="k-preview" src="${img1}">
                                    </label>
                                    <input type="file" class="k-inputImg" name="1" id="k-img1" accept="image/*">
                                    <span class="k-deleteImg">&times;</span>
                                </div>
                                <div class="k-img-box k-upload">
                                    <label for="k-img2">
                                        <img class="k-preview" src="${img2}">
                                    </label>
                                    <input type="file" class="k-inputImg" name="2" id="k-img2" accept="image/*">
                                    <span class="k-deleteImg">&times;</span>
                                </div>
                                <div class="k-img-box k-upload">
                                    <label for="k-img3">
                                        <img class="k-preview" src="${img3}">
                                    </label>
                                    <input type="file" class="k-inputImg" name="3" id="k-img3" accept="image/*">
                                    <span class="k-deleteImg">&times;</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <textarea name="K-content" cols="100" rows="20" placeholder="내용을 입력해주세요">${event.eventContent}</textarea>
                        </div>
                        <div>
                            
                            <button type="button" id="K-cancel">작성 취소</button>
                            
                            <button id="K-write">작성</button>
                        </div>

                        
                        <!-- hidden으로 숨겨놓기 -->
                        <input type="hidden" name="mode" value="${param.mode}">
                        <input type="hidden" name="deleteList" id="deleteList" value="">
                        <input type="hidden" name="no" value="${param.no}">
                    </form>
                </div>
            </div>
        </div>
    </div>


    <div id="sample"></div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="${contextPath}/resources/js/AdminEventWrite.js"></script>
</body>
</html>
