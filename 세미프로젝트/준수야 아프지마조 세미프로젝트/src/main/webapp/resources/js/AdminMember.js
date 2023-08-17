function secessionValidate() {
    // 사용자에게 정말 탈퇴하시겠습니까를 묻는 알림창을 띄웁니다.
    var isConfirmed = confirm('정말 탈퇴 하시겠습니까?');
    return isConfirmed; // 사용자가 확인을 누른 경우에만 폼을 제출합니다.
}
