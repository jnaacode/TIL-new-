package com.ncs.test.member.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.test.member.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;


	public int loginMember(Member loginMember) {
		return sqlSession.selectOne("mapper.loginMember",loginMember);
	}





}
