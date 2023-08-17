package kHotel.admin.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class LAdminPay {
	
	private int calculateNo;		// 결제번호
	private String calculateWay;	// 결제수단
	private String calculateSt;		// 결제상태
	private int calculatePrice;		// 결제금액
	private String accountNumber;	// 결제계좌
	private int bookNo;				// 예약번호
	private String memberId;		// 예약자 아이디
	private String checkInDt;		// 체크인 날짜

}
