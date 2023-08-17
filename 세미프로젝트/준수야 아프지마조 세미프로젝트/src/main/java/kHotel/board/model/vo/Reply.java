package kHotel.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reply {
	
	private int replyNo;
	private String replyContent;
	private String createDt;
	private String replySt;
	private String memberId;
	private int boardNo;
	private int memberNo;

}
