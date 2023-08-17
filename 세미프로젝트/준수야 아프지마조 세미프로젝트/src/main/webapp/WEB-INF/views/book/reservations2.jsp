<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="resources/css/reservations2.css">

    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/7bc7245179.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">





</head>
<body>

    <main>

        <header class="J-header">

        </header>

        <div class="J-BODY">

            <div class="J-BODY2"></div>

            <div class="J-BODY3">

                <div class="J-J">
                    <div class="J-J1">
                        이전 예약 내역

                    </div>

                    <div class="J-J2">

                        <div class="accordion test" id="accordionExample" >
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="headingOne">
                                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne"
                                        aria-expanded="true" aria-controls="collapseOne">
                                        <input type="text">
                                    </button>
                                </h2>
                                <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne"
                                    data-bs-parent="#accordionExample">
                                    <div class="accordion-body">
                                        <div class="J-PIC">
                                            <img src="resources/images/Deluxe-Room_1.jpg">
                                        </div>
                                        <div class="J-text">
                                            <input type="" placeholder="">
                                            <input type="">
                                            <input type="">
                                            <input type="">
                                            <button id="J-btn">별점 / 리뷰 작성</button>
                                        </div>

                              
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="headingTwo">
                                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo"
                                        >
                                        <input typr="text">
                                    </button>
                                </h2>
                                <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo"
                                    data-bs-parent="#accordionExample">
                                    <div class="accordion-body">
                                        <div  class="J-PIC">
                                            <img src="resources/images/standard-Room_1.jpg" >
                                        </div>
                                        <div class="J-text">
                                            <input type="">
                                            <input type="">
                                            <input type="">
                                            <input type="">
                                            <button id="J-btn">별점 / 리뷰 작성</button>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="headingThree">
                                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree"
                                      >
                                        <input typr="text">
                                    </button>
                                </h2>
                                <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree"
                                    data-bs-parent="#accordionExample">
                                    <div class="accordion-body">
                                        <div  class="J-PIC">
                                            <img src="resources/images/suite-Room_1.jpg">
                                        </div>
                                        <div class="J-text">
                                            <input type="">
                                            <input type="">
                                            <input type="">
                                            <input type="">
                                            <button id="J-btn">별점 / 리뷰 작성</button>
                                        </div>
                                       
                    
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>

                    <div class="J-J3">
                        홈페이지 버튼

                    </div>




                </div>


            </div>


            
        </div>








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
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>

    <script src="resources/js/reservations2.js"></script>
</body>
</html>