package com.spring.ex04;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO {
	private static SqlSessionFactory sqlMapper = null;
	private static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	
	public List<MemberVO> selectAllMemberList(){
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memberList = session.selectList("mapper.member.selectAllMemberList");
		return memberList;
	}
	
	public MemberVO selectMemberById(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		MemberVO memberVO = (MemberVO) session.selectOne("mapper.member.selectMemberById",id);
		return memberVO;
	}
	
	public List<MemberVO> selectMemberByPwd(String pwd) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> membersList = session.selectList("mapper.member.selectMemberByPwd",pwd);
		return membersList;
	}
	
	public int insertMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.insert("mapper.member.insertMember", memberVO);
		session.commit();
		return result;
	}
	
	public int insertMember2(HashMap member) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.insert("mapper.member.insertMember2", member);
		session.commit();
		return result;
	}
	
	public int updateMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result=session.update("mapper.member.updateMember",memberVO);
		session.commit();
		return result;
	}
	
	public int deleteMember(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.delete("mapper.member.deleteMember",id);
		session.commit();
		return result;
	}
	
}
