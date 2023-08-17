package kHotel.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardList {

	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private char boardSt;
	private int boardCode;
	private String memberName;
	private String memberId;
	private int memberNo;
	private String boardName;
	
}
