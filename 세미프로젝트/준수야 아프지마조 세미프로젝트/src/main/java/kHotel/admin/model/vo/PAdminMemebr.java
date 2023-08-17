package kHotel.admin.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class PAdminMemebr {
	
	private int memberNo;     //회원번호
	private String memberId;  //회원아이디
	private String memberPw;  //회원비밀번호
	private String memberNm;  //회원이름
	private String memberPno; //주민등록번호
	private String memebrTel; //전화번호
	private String memberEmail;//이메일
	private String memberAdd; // 주소
	private String secessionFl; // 탈퇴여부
	private int reportCount; 	//신고 카운트

}
