package edu.kh.project.board.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@NoArgsConstructor 컴파일러가 알아서 생성해주니까 안써도 된다
public class Comment {
	
	private int commentNo;
    private String commentContent;
    private String commentCreateDate;
    private int boardNo;
    private int memberNo;
    private String commentDeleteFlag;
    private int parentNo;
    private String memberNickname;
    private String profileImage;

}
