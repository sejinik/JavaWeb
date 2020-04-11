package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.dao.MemberDAOImpl;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAOImpl memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List<MemberVO> listMembers()  throws DataAccessException{
		return memberDAO.selectAllMemberList();
	}

	@Override
	public int addMember(MemberVO memberVO)  throws DataAccessException{
		return memberDAO.addMember(memberVO);
	}

	@Override
	public int removeMember(String id)  throws DataAccessException {
		return memberDAO.removeMember(id);
	}

}
