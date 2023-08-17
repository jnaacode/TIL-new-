package kHotel.member.model.vo;

import java.util.List;

import kHotel.board.model.vo.EventImage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Event {
	
	private int eventNo;
	private String eventTitle;
	private String eventContent;
	private String eventDt;
	private String bingoFl;
	private String updownFl;
	private int memberNo;
	private String imgRename;
	
	private List<EventImage> imageList;
	


}
