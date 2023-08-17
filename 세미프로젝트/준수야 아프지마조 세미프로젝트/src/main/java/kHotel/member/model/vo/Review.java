package kHotel.member.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Review {

	private int memberNo;
	private String content;
	private String userId;
	private int star;
	private String rename;
	private int boardNo;
	private String tag;
	private String reviewImg;
	private int board;
	private String hotelName;
	private String roomName;
	private int bookNo;
	
}
