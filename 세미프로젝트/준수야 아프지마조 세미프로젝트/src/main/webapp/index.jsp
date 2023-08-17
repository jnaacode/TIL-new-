<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="resources/css/header.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/RoomChoice.css">
    <link rel="stylesheet" href="resources/css/banner.css">
    <link rel="stylesheet" href="resources/css/footer.css">
    <link rel="stylesheet" href="resources/css/jhj1.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/7bc7245179.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/slick-carousel/slick/slick.min.js"></script>

    <!-- body2 -->
    <link rel="stylesheet" href="resources/css/body2.css">
    
    <title>메인화면</title>
</head>
<body>
    <div>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <!-- 배너 사진 -->
        <div>
            <div class="L-banner">
                <ul class="L-slide">
                    <li><img src="resources/images/main사진 4.jpg" class="L-slideImg" alt=""></li>
                    <li><img src="resources/images/메인1.png" class="L-slideImg" alt=""></li>
                    <li><img src="resources/images/메인2.png" class="L-slideImg" alt=""></li>
                </ul>
                <div class="L-controller">
                    <span class="L-prev">&lang;</span>
                    <span class="L-next">&rang;</span>
        
                </div>
            </div>
        </div>

        <!-- 호텔 예약 -->
        <form action="book/reservationFinal" method="POST" onsubmit="return reservation();">
        <input type="hidden" name="memberNo" value="${loginMember.memberNo}">
        <div class="C-reservation">
            <div class="C-rsv-main">
                <div class="C-rsv-main-text">지점 / 객실 / 날짜 / 인원 선택</div>
            </div>
            <div class="C-rsv-head">
                <div class="C-choiceHotel">
                    <div>
                        호텔선택
                    </div>
                    <div>
                        <select name="C-hotel-choice" id="C-hotel-choice">
                            <option name="location" value="none" selected>호텔을 선택해주세요</option>
                            <option name="location" id="GANGNAM" value="GANGNAM">K-호텔 강남점</option>
                            <option name="location" id="JONGRO" value="JONGRO">K-호텔 종로점</option>
                            <option name="location" id="DANGSAN" value="DANGSAN">K-호텔 당산점</option>
                        </select>
                    </div>
                </div>
                <div class="C-choiceRoom">
                    <div>객실선택</div>
                    <div>
                        <select name="C-room-choice" id="C-room-choice">
                            <option name="Room" value="none" selected>객실을 선택해주세요</option>
                            <option name="Room" id="Deluxe" value="DELUXE">Deluxe Room</option>
                            <option name="Room" id="Standard" value="STANDARD">Standard Room</option>
                            <option name="Room" id="Suite" value="SUITE">suite Room</option>
                        </select>
                    </div>
                </div>
                <div class="C-checkInOut">
                    <div>
                        체크인
                    </div>
                    <div>
                        <input type="date" name="C-checkInTime" class="C-checkIn" id="C-start">
                    </div>
                </div>
                <div class="C-dateView">
                    <div class="C-countdate" id="C-countdate">
                        0박
                    </div>
                </div>
                <div class="C-checkInOut">
                    <div>
                        체크아웃
                    </div>
                    <div>
                        <input type="date" name="C-checkOutTime" class="C-checkOut" id="C-end">
                    </div>
                </div>
                <div class="C-CountPerson">
                    <div>
                        <div>성인</div>
                        <div class="C-person">
                            <button type="button" id="C-Aminusbutton">-</button>
                            <input type="text" name="C-adult" id="C-adult" value="0" placeholder="0">
                            <button type="button" id="C-Aplusbutton">+</button>
                        </div>
                    </div>
                    <div>
                        <div>어린이</div>
                        <div class="C-person">
                            <button type="button" id="C-Cminusbutton">-</button>
                            <input type="text" name="C-children" id="C-children" value="0" placeholder="0">
                            <button type="button" id="C-Cplusbutton">+</button>
                        </div>
                    </div>
                </div>
                <div class="C-rsv-button">
                    <button id="C-reservationBtn">예약</button>
                </div>
            </div>
    </form>
        
        <!-- 바디 중간 -->
        <div class="J-1">
            <!-- J-1 넓이 100% -->
    
            <div class="J-2">
                <!-- J-2 넓이 1200px  -->
    
                <div class="J-3">
    
                    <div class="J-5">
                        <div id="J5-1">
                            <img class="fade-in" id="J-img1" src="https://www.lottehotel.com/content/dam/lotte-hotel/lotte/seoul/main/230119-558-mai-LTSE.jpg" >
                        </div>
    
                        <div id="J5-2">
                            
                            K-호텔은 강남, 종로, 당산 등 서울의 중심 관광지들로의 접근성이 뛰어나 <br>
                            서울 관광을 위한 최적의 위치를 자랑합니다. 
                            
                            
    
                        </div>
                    </div>
    
                    
                    <div class="J-6">
                        
                        <div id="J6-1">
                            
                            한국 최고의 럭셔리 비즈니스호텔인 K-호텔은 1,015실 규모를 자랑하며, <br>
                            고급진 인테리어로 격양된 분위기를 조성합니다.
                        </div>
                        
                        <div id="J6-2">
                            <img class="fade-in" id="J-img2" src="https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/76Cz/image/D-oNM9gJGbRPFYohIDcYPlyobzs.jpg" >
                        </div>
                    </div>
    
                </div>
    
                <div class="J-7">
    
                    <div class="JJ-7">
    
                         <img id="J-img3" src="resources/images/13.png">
                         <img id="J-img4" src="resources/images/14.png" >
                    </div>
    
                </div>
    
                 <div  class="J-4">
    
                    
                </div> 
    
            </div>
    
        </div>


        <!-- body2 -->
        <article class="H-royal">

            <h2>일상을 더 품격있게</h2>
         
            <div class="H-royal_inner">
         
              <section>
                <div>
                  <img class="H-img" src="https://eshop.lottehotel.com/uploads/banner/6b2686c6b8133b8e2a29844f15c42c23.png" alt="해온 프리미엄 배딩">
                </div>
                <div>
                  <div>
                    <h3>해온 프리미엄베딩</h3>
                    <p>국내최고 케이호텔에서만 느낄 수 있는 고품격<br>
                      he:on Bedding Package를 집에서 편안하게 느껴보세요.</p>
                    </div>
                </div>
              </section>
         
              <section>
                <div>
                  <img class="H-img" src="https://eshop.lottehotel.com/uploads/banner/b2bbeedfa09e1040cb5901d0aca57325.jpg" alt="시그니엘 드립백 커피">
                </div>
                <div>
                  <div>
                    <h3>시그니엘 드립백 커피</h3>
                    <p>시그니엘의 전문 바리스타가 직접 개발한<br>
                    프리미엄 원두 세트로 하루를 향기롭게 시작해보세요.</p>
                  </div>
                </div>
              </section>
         
            </div>
         
          </article>
      
          
      
      <div class="con-min-width gray">
      
        <div class="box-3-title con text-align-center">
            <h1>HOTEL</h1>
            <p>호텔 서울에서 진행되는 다양한 이벤트를 만나보세요.</p>
        </div>
      
        <div class="box-2 con">
            <nav class="menu-box-1">
                <ul class="row">
                    <li class="cell">
                        <a href="#" class="">
                                <div class="img">
                            <img src="https://www.busanparadisehotel.co.kr/upload/202002/1582869043542.jpg" alt="">
                              </div> 
                      <div class="txt row">
                          <span class="cell vvv">레스토랑 및 부대시설 영업시간 변경 안내</span>
                            <span class="sub cell">일부 영업장 휴장 및 단축 운영을 한시적으로 실시합니다.</span>         
                      </div>
                        </a>
                    </li>
                    <li class="cell">
                        <a href="#" class="">
                                <div class="img">
                            <img src="https://www.busanparadisehotel.co.kr/upload/202002/1582265303742.jpg" alt="">
                              </div>
                      <div class="txt row">
                          <span class="cell vvv">SPRING OCEAN SPA CIMER</span>
                            <span class="sub cell">설레는 봄, 따스한 봄 꽃 선물</span>         
                      </div>
                        </a>
                    </li>
                    <li class="cell">
                        <a href="#" class="">
                                <div class="img">
                            <img src="https://www.busanparadisehotel.co.kr/upload/202002/1582270177500.jpg" alt="">
                              </div>
                      <div class="txt row">
                          <span class="cell vvv">신나는 봄방학 프로모션</span>
                            <span class="sub cell">사랑스런 아이들과 함께 맛있는 음식을 맛보며 즐거운 추억을</span>
                      </div>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
      
          
      </div>

          

        <!-- footer -->
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </div>
    
   <script src="${contextPath}/resources/js/RoomChoice.js"></script>
    <script src="resources/js/banner.js"></script>
    <script src="resources/js/jhj2.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="resources/js/header.js"></script>
</body>
</html>