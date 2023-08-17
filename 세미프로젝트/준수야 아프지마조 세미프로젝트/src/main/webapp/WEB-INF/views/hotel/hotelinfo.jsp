<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${contextPath}/resources/css/hotelinfo.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/7bc7245179.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <title>호텔 소개</title>
</head>
<body>
    
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div class="L-maindisplay">
           
        <jsp:include page="/WEB-INF/views/common/hotelSidebar.jsp"/>
        

        <div class="L-main">
            <div>소개</div>
            <img src="${contextPath}/resources/images/hotelInfo1.jpg">
            <p>
                국내 최고의 럭셔리 비즈니스 호텔인 K호텔은 1,015실 규모를 자랑하며 서울에 자리잡고 있습니다. 
                
				강남, 종로, 당산 등 서울의 중심 관광지들로의 접근성이 뛰어나 서울 관광을 위한 최적의 위치를 자랑합니다.
				
				세계적인 인테리어 회사들이 참가하여 설계한 독창적인 인테리어의 객실은 최신 트렌드를 반영하고 있으며, 
				
				성공적인 비즈니스를 위한 클럽 플로어에서는 품위와 정교함을 느끼실 수 있습니다. 
				
				또한, K호텔에서는 따뜻하고 고급의 가족모임과 럭셔리 웨딩, 
				
				대규모 국제회의 진행 등의 비즈니스 행사를 위한 최상의 시설을 제공하고 있으며, 
				
				최고급 레스토랑 또한 국빈 등 VIP고객을 모시기에 최적의 선택입니다.
            </p>
        </div>
    </div>

    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>






    <script src="${contextPath}/resources/js/hotelinfo.js"></script>
</body>
</html>