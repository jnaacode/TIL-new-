<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>마이페이지 사이드바</title>

      <link rel="stylesheet" href="${contextPath}/resources/css/sidebar.css">

      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <script>
        $(document).ready(function () {
          $(".H-side-bar .H-side-item").click(function (e) {
            var $this = $(this);
            var $parent = $this.closest('li');
            var $siblings = $this.siblings('dl');

            if ($siblings.length && !$siblings.is(':visible')) {
              $parent.addClass('H-active').siblings('li').removeClass('H-active').find('dl').removeClass('H-block').addClass('none');
              $siblings.removeClass('H-none').addClass('H-block');
            } else {
              $parent.removeClass('H-active');
              $siblings.removeClass('H-block').addClass('H-none');
            }
          });
        });
      </script>

      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
      <script src="https://kit.fontawesome.com/7bc7245179.js" crossorigin="anonymous"></script>

      <link rel="stylesheet" href="resources/css/footer.css">

      <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    </head>



    </head>

    <body>




      <div class="H-snb">
        <ul class="H-side-bar">
          <li class="">
            <a href="#" class="H-side-item">내 정보</a>
            <dl class="H-none">
              <dd class="H-active"><a href="${contextPath}/member/mypage">- 회원 정보 확인</a></dd>
              <dd class=""><a href="${contextPath}/member/mypage/changePw">- 비밀번호 변경</a></dd>
              <dd class=""><a href="${contextPath}/member/mypage/deleteMember">- 탈퇴 요청</a></dd>
            </dl>
          </li>
          <li>
            <a href="#" class="H-side-item">예약</a>
            <dl class="H-none">
              <dd class=""><a href="${contextPath}/member/mypage/reservations1">- 현재 예약 확인</a></dd>
              <dd class=""><a href="${contextPath}/member/mypage/reservations2">- 이전 예약 확인</a></dd>
            </dl>
          </li>
          <li>
            <a href="${contextPath}/member/mypage/coupon?cp=1" class="H-side-item">쿠폰</a>

          </li>
          <li>

            <a href="#" class="H-side-item">내가 쓴 글</a>
            <dl class="H-none">
              <dd class=""><a href="${contextPath}/member/mypage/mypageWirte">- REVIEW</a></dd>
              <dd class=""><a href="${contextPath}/member/mypage/mypageQna">- QnA</a></dd>
            </dl>
          </li>
          <li>
            <a href="${contextPath}/member/mypage/likePage" class="H-side-item">찜</a>

          </li>
        </ul>

      </div>





      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
      <script src="/Javascipt/header.js"></script>
    </body>

    </html>