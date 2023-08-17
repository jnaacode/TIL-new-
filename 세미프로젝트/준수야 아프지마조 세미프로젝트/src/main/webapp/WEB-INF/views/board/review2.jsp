<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="resources/css/review2.css">
</head>
<body>
    
    <main>

        <header class="J-header">
        </header>

        <div class="J-body">
            
            <div class="J-body2">

                <div class="J-body2-1">
                    리뷰 / 벌점 수정
                </div>

                <div class="J-body2-2">

                    <table>

                        <tr>
                            <td>
                                작성자
                            </td>

                            <td>
                                <input type="text" placeholder="작성자명" id="J-text">
                            </td>

                            <td>
                                작성일
                            </td>

                            <td>
                                <input type="text" placeholder="작성일" id="J-text">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                객실명
                            </td>

                            <td >
                                <select >
                                    <option>-----------</option>
                                    <option>객실명1</option>
                                    <option>객실명2</option>
                                    <option>객실명3</option>
                                </select>
                            </td>

                            <td>
                                사진
                            </td>

                            <td id="J-PIC">
                                <button>사진추가</button><div></div>
                            </td>
                        </tr>


                        <tr>
                            <td></td>
                            <td colspan="3">
                               <!--  <img src="resources/images/리뷰1.png"> -->
                            </td>
                        </tr>

                        <tr>
                            <td>
                                별점
                            </td>

                            <td colspan="3">
                                <form name="J-myform" id="J-myform" method="post" action="./save">
                                    <fieldset>
                                        <label for="rate1">⭐</label><input type="radio" name="rating" value="5" id="rate1">
                                        <label for="rate2">⭐</label><input type="radio" name="rating" value="4" id="rate2">
                                        <label for="rate3">⭐</label><input type="radio" name="rating" value="3" id="rate3">
                                        <label for="rate4">⭐</label><input type="radio" name="rating" value="2" id="rate4">
                                        <label for="rate5">⭐</label><input type="radio" name="rating" value="1" id="rate5">
                                    </fieldset>
                                </form>
                            </td>
                        </tr>

                        <tr>

                            <td >
                               
                            </td>

                            <td>
                                <input type="checkbox" id="in">
                                <pre>깨끗해요</pre>
                                <input type="checkbox">
                                <pre>아이와 가기 좋아요</pre>
                                <input type="checkbox">
                                <pre>조용해서 쉬기 좋아요</pre>
                            </td>

                            <td>
                                
                            </td>

                            <td>
                                <input type="checkbox">
                                <pre>침구가 고급스러워요</pre>
                                <input type="checkbox">
                                <pre>애인과 가기 좋아요</pre>
                                <input type="checkbox"> 
                                <pre>파티하기 좋아요</pre>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                내용
                            </td>

                            <td colspan="3">
                                <textarea id="J-text1" placeholder="내용을 입력해주세요"></textarea>
                            </td>
                        </tr>
                    </table>

                </div>

                <div class="J-body2-3">
                    <button>리뷰 수정 취소</button><button>리뷰 수정</button>
                </div>

            </div>


        </div>
        
            <!-- ------------------------------------------------------------------------- -->
        <div class="k-first-div">
            <div class="k-f-container">
                <div>
                    <img src="resources/images/logo_w_2.png" style="width: 180px;">
                </div>
                <div>
                    <span>호텔소식</span>
                    <span> | </span>
                    <span>갤러리</span>
                    <span> | </span>
                    <span>고객문의</span>
                </div>
                <div id="k-sns">
                    <div>
                        <a href="#">
                            <img src="https://www.lottehotel.com/content/dam/lotte-hotel/common/footer/footer-sns-blog.png">
                        </a>
                    </div>
                    <div>
                        <a href="#">
                            <img src="https://www.lottehotel.com/content/dam/lotte-hotel/common/footer/footer-sns-instagram.png">
                        </a>
                    </div>
                    <div>
                        <a href="#">
                            <img src="https://www.lottehotel.com/content/dam/lotte-hotel/common/footer/footer-sns-youtube.png">
                        </a>
                    </div>
                    <div>
                        <a href="#">
                            <img src="https://www.lottehotel.com/content/dam/lotte-hotel/common/footer/footer-sns-facebook.png">
                        </a>
                    </div>
                    
                </div>
            </div>
        </div>
        
        <div class="k-second-div">
            <div>
                <span>케이호텔 소개</span>
                <span> | </span>
                <span>사이트맵</span>
                <span> | </span>
                <span>개인정보처리방침</span>
                <span> | </span>
                <span>이메일무단수집금지</span>
                <span> | </span>
                <span>윤리경영(부정제보)</span>
            </div>
        </div>
        
        <div class="k-third-div">
            <div>
                <div>케이호텔(주) 서울특별시 강남구 테헤란로 14길 6</div>
                <div>TEL 1544-9970</div>
                <div>Copyright © 2023 khotel.co.,Ltd. All rights reserved.</div>
            </div>
            <div>
                <img src="resources/images/copyright.png">
            </div>
        </div>





    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous">
    </script>
    <script src="resources/js/review2.js"></script>
</body>
</html>