
// 요소의 투명도를 처리하는 함수
function fadeInOnScroll() {
  var elements = document.getElementsByClassName("fade-in");
  for (var i = 0; i < elements.length; i++) {
    var element = elements[i];
    var elementTop = element.getBoundingClientRect().top;
    var elementBottom = element.getBoundingClientRect().bottom;
    var isVisible = elementTop < window.innerHeight && elementBottom >= 0;

    if (isVisible) {
      element.classList.add("active");
    } else {
      element.classList.remove("active");
    }
  }
}

// 스크롤 이벤트 리스너 등록
window.addEventListener("scroll", fadeInOnScroll);
window.addEventListener("resize", fadeInOnScroll);
// 초기 로드 시에도 페이드 인 효과 적용을 위해 실행
fadeInOnScroll();

// 자동 슬라이드 함수
function autoSlide() {
    var slider = document.querySelector('.JJ-7');
    var firstSlide = slider.firstElementChild;

    // 첫 번째 이미지를 맨 뒤로 이동
    slider.appendChild(firstSlide);

    // 슬라이더를 왼쪽으로 이동하여 다음 이미지 표시
    slider.style.transform = 'translateX(-' + firstSlide.offsetWidth + 'px)';
}

// 3초마다 자동 슬라이드 호출
setInterval(autoSlide, 3000);
