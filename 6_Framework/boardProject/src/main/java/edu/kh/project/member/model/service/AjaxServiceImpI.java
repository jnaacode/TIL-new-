package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.AjaxDAO;

@Service // 서비스임을 명시를 해주고 + bean으로 등록
public class AjaxServiceImpI implements AjaxService{
	
	@Autowired // DI(객체로 등록되어 있는 것중에 AjaxDAO있으면 객체로 넣어줘!)
	private AjaxDAO dao;

	
	//이메일로 닉네임 조회
	@Override
	public String selectNickname(String email) {
		return dao.selectNickname(email);
	}


	// 닉네임으로 전화번호 조회
	@Override
	public String selectMemebrTel(String nickname) {
		return dao.selectMemebrTel(nickname);
	}


	//이메일 중복 확인 
	@Override
	public int checkEmail(String email) {
		return dao.checkEmail(email);
	}


	@Override
	public int checkNickname(String nickname) {
		
		return dao.checkNickname(nickname);
	}

}
