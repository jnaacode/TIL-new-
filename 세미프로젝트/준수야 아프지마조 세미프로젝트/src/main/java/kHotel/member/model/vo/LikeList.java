package kHotel.member.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class LikeList {
	
	private int roomNo;
	private int memberNo;
	private String hotelNm1;
	private String hotelNm2;
	private String hotelNm3;
	private String roomNm1;
	private String roomNm2;
	private String roomNm3;
	private int count;
	private int count2;
	private int count3;

}
