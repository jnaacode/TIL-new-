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
public class Event {
	
	private int eventNo;
	private String eventTitle;
	private String eventContent;
	private String eventDt;
	private String eventFL;
	private String bingoFl;
	private String updownFl;
	private int memberNo;
	
	private List<EventImage> imageList;

}
