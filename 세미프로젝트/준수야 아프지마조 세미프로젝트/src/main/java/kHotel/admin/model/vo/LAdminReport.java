package kHotel.admin.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor


public class LAdminReport {
	
	private int boardNo;			// 게시글 번호
	private String reportContent;	// 신고 내용
	private String reportDt;		// 신고 날짜
	private String writePerson;		// 글 작성자
	private String reportPerson;	// 신고자
	private int memberNo; //회원번호
	

} 
