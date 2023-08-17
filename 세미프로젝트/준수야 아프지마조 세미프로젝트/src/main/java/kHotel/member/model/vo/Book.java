package kHotel.member.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Book {

		private int bookNo;
		private String bookHotel;
		private String bookRoom;
		private String checkInTime;
		private String checkOutTime;
		private int adult;
		private int child;
		private String checkFl;
		
	

}
