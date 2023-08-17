package kHotel.board.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private char boardSt;
	private int boardCode;
	private String memberName;
	private String memberId;
	private int memberNo;
	
	private int roomNo;
	private String roomName;
	private String hotelTitle;
	private String imageRename;
	
	private int reviewStar;
	private String tagContent;
	private List<String> tagList;

}
