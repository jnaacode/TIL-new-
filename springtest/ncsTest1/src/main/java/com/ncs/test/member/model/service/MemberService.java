package com.ncs.test.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.test.member.model.vo.Member;

public interface MemberService {

	int memberLogin(Member loginMember);


}
