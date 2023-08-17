<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


            <!-- <c:set var="pagination" value="${map.pagination}" />
            <c:set var="boardList" value="${map.boardList}" /> -->

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>리뷰/별점 상세보기</title>

                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                    crossorigin="anonymous">
                <script src="https://kit.fontawesome.com/7bc7245179.js" crossorigin="anonymous"></script>
                <link rel="stylesheet" href="${contextPath}/resources/css/reviewShow.css">
                <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
                <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">

                <script src="https://code.jquery.com/jquery-3.7.0.min.js"
                    integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

            </head>

            <body>

                <jsp:include page="/WEB-INF/views/common/header.jsp" />

                <!-- 전체 큰 페이지  -->
                <div class="P-top">


                    <!-- 리뷰/별점 전체 페이지  -->
                    <div class="P-maindisplay">
                        <!-- 안에 목록  -->
                        <div class="P-main">
                            <div class="P-reviewTitle">리뷰/별점</div>


                            <input type="hidden" name="boardNo" value="${board.boardNo}">

                            <c:set var="rsmi" value="${board.memberId}" />
                            <c:set var="length" value="${fn:length(rsmi)}" />

                            <div class="P-reviewBox">
                                <div class="P-profile_area">
                                    <div class="P-id" id="P-id">작성자 : <span>***${fn:substring(rsmi,3,length)}</span>
                                    </div>

                                    <div>
                                        <div class="P-room1" id="P-room1"> 지점: <span>${board.hotelTitle}</span>
                                        </div>
                                        <div class="P-room2" id="P-room2"> 객실명 : <span>${board.roomName}</span>
                                        </div>
                                        <div class="P-room3">작성날짜 : <span>${board.boardDate}</span></div>
                                    </div>
                                </div>
                                <div class="P-img"><a href="#"><img src="${contextPath}${board.imageRename}"
                                            class="PreviewImg"></a></div>
                                <div id="P-rs-content">${board.boardContent}</div>
                                <div>
                                    <div class="P-star">
                                        <c:if test="${board.reviewStar == 1}">

                                            <form name="P-myform" id="P-myform" method="post" action="./save">
                                                <fieldset>
                                                    <input type="radio" id="5-stars" name="rating" value="5"
                                                        class="P-myformYellow" v-model="ratings" />
                                                    <label for="5-stars" class="star P-myformYellow">⭐</label>

                                                    <input type="radio" id="4-stars" name="rating" value="4"
                                                        v-model="ratings" />
                                                    <label for="4-stars" class="star P-myformYellow">⭐</label>

                                                    <input type="radio" id="3-stars" name="rating" value="3"
                                                        v-model="ratings" />
                                                    <label for="3-stars" class="star P-myformYellow">⭐</label>

                                                    <input type="radio" id="2-stars" name="rating" value="2"
                                                        v-model="ratings" />
                                                    <label for="2-stars" class="star P-myformYellow">⭐</label>

                                                    <input type="radio" id="1-star" name="rating" value="1"
                                                        v-model="ratings" />
                                                    <label for="1-star" class="star pyellow">⭐</label>
                                                </fieldset>
                                            </form>

                                        </c:if>


                                        <c:if test="${board.reviewStar == 2}">

                                            <form name="P-myform" id="P-myform" method="post" action="./save">
                                                <fieldset>
                                                    <input type="radio" id="5-stars" name="rating" value="5"
                                                        class="P-myformYellow" v-model="ratings" />
                                                    <label for="5-stars" class="star P-myformYellow">⭐</label>

                                                    <input type="radio" id="4-stars" name="rating" value="4"
                                                        v-model="ratings" />
                                                    <label for="4-stars" class="star P-myformYellow">⭐</label>

                                                    <input type="radio" id="3-stars" name="rating" value="3"
                                                        v-model="ratings" />
                                                    <label for="3-stars" class="star P-myformYellow">⭐</label>

                                                    <input type="radio" id="2-stars" name="rating" value="2"
                                                        v-model="ratings" />
                                                    <label for="2-stars" class="star pyellow">⭐</label>

                                                    <input type="radio" id="1-star" name="rating" value="1"
                                                        v-model="ratings" />
                                                    <label for="1-star" class="star pyellow">⭐</label>
                                                </fieldset>
                                            </form>

                                        </c:if>

                                        <c:if test="${board.reviewStar == 3}">

                                            <form name="P-myform" id="P-myform" method="post" action="./save">
                                                <fieldset>
                                                    <input type="radio" id="5-stars" name="rating" value="5"
                                                        class="P-myformYellow" v-model="ratings" />
                                                    <label for="5-stars" class="star P-myformYellow">⭐</label>

                                                    <input type="radio" id="4-stars" name="rating" value="4"
                                                        v-model="ratings" />
                                                    <label for="4-stars" class="star P-myformYellow">⭐</label>

                                                    <input type="radio" id="3-stars" name="rating" value="3"
                                                        v-model="ratings" />
                                                    <label for="3-stars" class="star pyellow">⭐</label>

                                                    <input type="radio" id="2-stars" name="rating" value="2"
                                                        v-model="ratings" />
                                                    <label for="2-stars" class="star pyellow">⭐</label>

                                                    <input type="radio" id="1-star" name="rating" value="1"
                                                        v-model="ratings" />
                                                    <label for="1-star" class="star pyellow">⭐</label>
                                                </fieldset>
                                            </form>

                                        </c:if>

                                        <c:if test="${board.reviewStar == 4}">

                                            <form name="P-myform" id="P-myform" method="post" action="./save">
                                                <fieldset>
                                                    <input type="radio" id="5-stars" name="rating" value="5"
                                                        class="P-myformYellow" v-model="ratings" />
                                                    <label for="5-stars" class="star P-myformYellow">⭐</label>

                                                    <input type="radio" id="4-stars" name="rating" value="4"
                                                        v-model="ratings" />
                                                    <label for="4-stars" class="star pyellow">⭐</label>

                                                    <input type="radio" id="3-stars" name="rating" value="3"
                                                        v-model="ratings" />
                                                    <label for="3-stars" class="star pyellow">⭐</label>

                                                    <input type="radio" id="2-stars" name="rating" value="2"
                                                        v-model="ratings" />
                                                    <label for="2-stars" class="star pyellow">⭐</label>

                                                    <input type="radio" id="1-star" name="rating" value="1"
                                                        v-model="ratings" />
                                                    <label for="1-star" class="star pyellow">⭐</label>
                                                </fieldset>
                                            </form>

                                        </c:if>

                                        <c:if test="${board.reviewStar == 5}">

                                            <form name="P-myform" id="P-myform" method="post" action="./save">
                                                <fieldset>
                                                    <input type="radio" id="5-stars" name="rating" value="5"
                                                        class="P-myformYellow" v-model="ratings" />
                                                    <label for="5-stars" class="star pyellow">⭐</label>

                                                    <input type="radio" id="4-stars" name="rating" value="4"
                                                        v-model="ratings" />
                                                    <label for="4-stars" class="star pyellow">⭐</label>

                                                    <input type="radio" id="3-stars" name="rating" value="3"
                                                        v-model="ratings" />
                                                    <label for="3-stars" class="star pyellow">⭐</label>

                                                    <input type="radio" id="2-stars" name="rating" value="2"
                                                        v-model="ratings" />
                                                    <label for="2-stars" class="star pyellow">⭐</label>

                                                    <input type="radio" id="1-star" name="rating" value="1"
                                                        v-model="ratings" />
                                                    <label for="1-star" class="star pyellow">⭐</label>
                                                </fieldset>
                                            </form>

                                        </c:if>


                                        <!-- +클릭 시 span 표출 -->
                                        <!-- 
                                            <div onclick="fn_find()" class="P-tag-con">+</div>
                                            <div id="search"><span class="P-tag-top">
                                                    <img src="https://em-content.zobj.net/thumbs/120/apple/354/red-heart_2764-fe0f.png"
                                                        alt=""> 커플이랑 가기 좋아요

                                                </span></div> -->

                                    </div>

                                    <!--                                     <div class="tagClass">
                                        <c:set var="tag" value="${fn:split(board.tagContent,',,')}" />

                                        <c:forEach var="i" begin="0" end="${fn:length(tag) - 1}" step="1">

                                            <span class="P-tag-top">
                                            
                                                    <input type="text" value="✅ ${tag[i]}" disabled>
                                            </span>

                                        </c:forEach>
                                    </div> -->

                                    <!-- 진행하기 -->
                                    <div class="tagClass">
                                        <c:set var="tag" value="${fn:split(board.tagContent,',,')}" />

                                        <span class="P-tag-top1">
                                            <input type="text" value="✅ ${tag[0]}" disabled>
                                        </span>
                                   
                                            <span class="P-tag-con">
                                                <input type="button" value="+" onclick="appendText()">
                                            </span>
                  
                                        <c:forEach var="i" begin="1" end="${fn:length(tag) - 1}" step="1">
                                       
                                            <span class="P-tag-top2" id="P-tag-top2">
                                                <input type="text" value="➰ ${tag[i]}" disabled>
                                            </span>

                                        </c:forEach>
                                    </div>

                                </div>
                                <div class="P-rs-btn">

                                    <c:if test="${loginMember.memberNo == board.memberNo}">

                                        <form action="update?no=${board.boardNo}" method="POST">
                                            <button id="P-rs-update-btn">수정</button>
                                            <input type="hidden" name="memberId" value="${board.memberId}">
                                            <input type="hidden" name="hotelName" value="${board.hotelTitle}">
                                            <input type="hidden" name="roomName" value="${board.roomName}">
                                            <input type="hidden" name="pic" value="${board.imageRename}">
                                            <input type="hidden" name="content" value="${board.boardContent}">
                                            <input type="hidden" name="tag" value="${board.tagContent}">
                                            <input type="hidden" name="star" value="${board.reviewStar}">
                                        </form>
                                    </c:if>

                                    <c:if test="${loginMember.memberNo == board.memberNo || loginMember.memberAdmin == 'Y'.charAt(0)}">
                                        <form action="delete">
                                            <input type="hidden" name="memberId" value="${board.memberId}">
                                            <input type="hidden" name="no" value="${param.no}">
                                            <button id="P-rs-delete-btn">삭제</button>
                                        </form>
                                    </c:if>

                                    <c:if test="${loginMember.memberNo != board.memberNo}">
                                        <button id="P-rs-Declar-btn">신고</button>
                                    </c:if>
                                </div>


                                <input type="hidden" value="${board.boardNo}" name="boardNo">
                                <input type="hidden" value="${board.memberNo}" name="memberNo">

                                <!-- 신고하기 창 -->
                                <form action="show">
                                    <input type="hidden" name="no" value="${param.no}">

                                    <div id="P-popup-Declar">

                                        <div id="P-popup-area">
                                            <div id="P-popup-title">신고하기</div>

                                            <div id="P-popup-out">
                                                <button id="P-popup-outbtn">X</button>
                                            </div>

                                        </div>


                                        <div class="P-popup-writer-area">
                                            <textarea name="" id="P-popup-content"></textarea>
                                        </div>
                                        <div class="P-declar-btnarea">
                                            <button id="P-declar-btn">신고하기</button>
                                        </div>
                                    </div>
                                </form>
                            </div>




                            <div class="P-blank"></div>



                        </div>
                    </div>
                </div>

                <jsp:include page="/WEB-INF/views/common/footer.jsp" />

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                    crossorigin="anonymous">
                    </script>

                <!--   <script>
                    const contextPath = "${contextPath}"
                    const memberNo = "${board.memberNo}"
                    const boardNo = "${board.boardNo}"
                </script> -->

                <script src="${contextPath}/resources/js/reviewShow.js"></script>

            </body>

            </html>