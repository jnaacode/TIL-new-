<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>리뷰/별점 수정</title>

            <link rel="stylesheet" href="${contextPath}/resources/css/review2.css">
        </head>

        <body>

            <main>

                <jsp:include page="/WEB-INF/views/common/header.jsp" />
                <form action="${contextPath}/board/review/reviewAlter?no=${param.no}" enctype="multipart/form-data"  method="POST" onsubmit="return reviewVaildate()"> 
                <div class="J-body">

                    <div class="J-body2">

                        <div class="J-body2-1">
                            리뷰 / 벌점 수정
                        </div>

                        <div class="J-body2-2">

                            <table>

                                <tr>
                                    <td id="J-text3">
                                        작성자
                                    </td>

                                    <td>
                                        <input type="text" placeholder="작성자명" id="J-text" name="updateId" value="${rvUpdate.userId}">
                                    </td>

                                    <td id="J-text3">
                                        지점
                                    </td>

                                    <td>
                                        <input type="text" placeholder="작성일" id="J-text" name="updateHotel" value="${rvUpdate.hotelName}">
                                    </td>
                                </tr>

                                <tr>
                                    <td id="J-text3">
                                        객실명
                                    </td>

                                    <td>
                                        <input type="text" name="updateRoom" value="${rvUpdate.roomName}"> 
                                    </td>

                                    <td id="J-text3">
                                        사진
                                    </td>

                                    <td id="J-PIC">
                                        <label for="J-reviewImage2">사진 선택</label>
                                        <input type="file" name="JreviewImage" id="J-reviewImage2" accept="image/*">
                                        <!-- accept="image/* : 이미지 파일 확장자만 선택 허용" -->
                                    </td>
                                </tr>


                                <tr>
                                    <td>
                                        <button type="button" id="J-delBtn">사진 지우기</button>
                                    </td>
                                    <td colspan="3" id="J-reviewImg1">

                                        <img src="${contextPath}${rvUpdate.reviewImg}" id="J-reviewImage3" name="updateImg2">
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>
                                        별점
                                    </td>

                                    <td colspan="3">
                                        <div name="J-myform" id="J-myform">
                                            <fieldset>
                                                <input type="radio" id="5-stars" name="updateStar" value="5" class="star2"
                                                    v-model="ratings" />
                                                <label for="5-stars" class="star pr-4">⭐</label>
                                                <input type="radio" id="4-stars" name="updateStar" value="4" class="star2"
                                                    v-model="ratings" />
                                                <label for="4-stars" class="star">⭐</label>
                                                <input type="radio" id="3-stars" name="updateStar" value="3" class="star2"
                                                    v-model="ratings" />
                                                <label for="3-stars" class="star">⭐</label>
                                                <input type="radio" id="2-stars" name="updateStar" value="2" class="star2"
                                                    v-model="ratings" />
                                                <label for="2-stars" class="star">⭐</label>
                                                <input type="radio" id="1-star" name="updateStar" value="1" class="star2"
                                                    v-model="ratings" />
                                                <label for="1-star" class="star">⭐</label>
                                            </fieldset>
                                        </div>
                                    </td>
                                </tr>
                                
                                <tr>

                                    <td>
                                        태그
                                    </td>

                                    <td>
                                        <input type="checkbox" class="tag" name="updateTag" value="깨끗해요">
                                        <pre>깨끗해요</pre>
                                        <input type="checkbox" class="tag" name="updateTag" value="아이와 가기 좋아요">
                                        <pre>아이와 가기 좋아요</pre>
                                        <input type="checkbox" class="tag" name="updateTag" value="조용해서 쉬기 좋아요">
                                        <pre>조용해서 쉬기 좋아요</pre>
                                    </td>

                                    <td>

                                    </td>

                                    <td> 
                                        <input type="checkbox" class="tag" name="updateTag" value="침구가 고급스러워요">
                                        <pre>침구가 고급스러워요</pre>
                                        <input type="checkbox" class="tag" name="updateTag" value="애인과 가기 좋아요">
                                        <pre>애인과 가기 좋아요</pre>
                                        <input type="checkbox" class="tag" name="updateTag" value="파티하기 좋아요">
                                        <pre>파티하기 좋아요</pre>
                                    </td>
                                </tr>

                                <tr>
                                    <td id="J-text2">
                                        내용
                                    </td>

                                    <td colspan="3">
                                        <textarea id="J-text1"  name="updateContent">${rvUpdate.content}</textarea>
                                    </td>
                                </tr>
                            </table>

                        </div>

                        <div class="J-body2-3">
                            <button id="J-cancle" type="button" onclick="location.href='${contextPath}/board/review/show?no=${boardNo}'">리뷰 수정 취소</button>
                            <button id="J-alter">리뷰 수정</button>
                            <!-- 리뷰 작성 취소 누를 시 이전 페이지로 돌아갈건지 알림창 띄우고 확인 누르면 이동. -->
                        </div>
                        <input type="hidden" name="Jdelete" id="J-delete" value="0">
                    </div>

                    <input type="hidden" name="reviewTitle" value="리뷰입니다.">
                </div>
                <input type="hidden" name="rating2" class="star3">
                <input type="hidden" name="memberId" value="${rvUpdate.userId}">
                <input type="hidden" name="hotelName" value="${rvUpdate.hotelName}">
                <input type="hidden" name="roomName" value="${rvUpdate.roomName}">
                <input type="hidden" name="pic" value="${rvUpdate.reviewImg}">
                <input type="hidden" name="content" value="${rvUpdate.content}">
                <input type="hidden" name="tag" value="${rvUpdate.tag}">
                <input type="hidden" name="star" value="${rvUpdate.star}">
                
            </form>
                <!-- ------------------------------------------------------------------------- -->
               
                <jsp:include page="/WEB-INF/views/common/footer.jsp" />


            </main>

            <script>
                const contextPath = "${contextPath}"; // 최상위 경로를 JS 전역변수로 선언
            </script>

            <script src="${contextPath}/resources/js/review2.js"></script>
        </body>

        </html>