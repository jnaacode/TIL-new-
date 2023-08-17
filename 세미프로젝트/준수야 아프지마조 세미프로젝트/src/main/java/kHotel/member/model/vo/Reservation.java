
package kHotel.member.model.vo;

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

public class Reservation {
	
	private int roomNo;
	private String hotelName;
	private String roomName;
	private int roomPrice;
	private String roomImage;
	private String roomInfo;
	private String roomStatus;
	private int bookNo;
	private String checkInTime;
	private String checkOutTime;
	private int bookPerson;
	private String checkFl;
	private int calculateNo;
	private int memberNo;
	private String memberName;
	private int couponNo;
	private String couponName;
	private int couponSale;
	private String couponDate;
	private String couponSt;
	private int couponCount;
	private int hotelPay;
	private String memberTel;
	private String memberEmail;
	private String bank;
	private String payPlan;
	private String calSt;
}
