package com.spring.ex04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/mem4.do")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		
		String action = request.getParameter("action");
		String nextPage="";
		
		if(action==null || action.equals("listMembers")) {
			List<MemberVO> membersList = memberDAO.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			nextPage = "test03/listMembers.jsp";
		} else if(action.equals("selectMemberById")) {
			
			String id = request.getParameter("value");
			memberVO = memberDAO.selectMemberById(id);
			request.setAttribute("member", memberVO);
			nextPage = "/mem4.do?action=listMembers";
			
		} else if(action.equals("selectMemberByPwd")) {
			
			String pwd = request.getParameter("value");
			List<MemberVO> membersList = memberDAO.selectMemberByPwd(pwd);
			request.setAttribute("membersList", membersList);
			nextPage = "/mem4.do?action=listMembers";
			
		} else if(action.equals("memberForm")) {
			nextPage = "test03/memberForm.jsp";
		} else if(action.equals("insertMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			
			int result = memberDAO.insertMember(memberVO);
			System.out.println("insertMember result : "+result);
			
			nextPage = "/mem4.do?action=listMembers";
		} else if(action.equals("insertMember2")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			HashMap<String, String> memberMap = new HashMap<>();
			memberMap.put("id", id);
			memberMap.put("pwd", pwd);
			memberMap.put("name",name);
			memberMap.put("email", email);
			
			int result = memberDAO.insertMember2(memberMap);
			System.out.println("insertMember result : "+result);
			
			nextPage = "/mem4.do?action=listMembers";
		} else if(action.equals("updateMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			
			int result = memberDAO.updateMember(memberVO);
			System.out.println("updateMember result : "+result);
			
			nextPage = "/mem4.do?action=listMembers";
		} else if(action.equals("deleteMember")) {
			String id = request.getParameter("id");
			int result = memberDAO.deleteMember(id);
			System.out.println("deleteMember result : "+result);
			
			nextPage = "/mem4.do?action=listMembers";
			
		} else if(action.equals("searchMember")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			memberVO.setName(name);
			memberVO.setEmail(email);
			
			List<MemberVO> membersList = memberDAO.searchMember(memberVO);
			request.setAttribute("membersList", membersList);
			
			nextPage = "/test03/listMembers.jsp";
		
		} else if(action.equals("foreachSelect")) {
			List<String> nameList = new ArrayList<String>();
			nameList.add("홍길동");
			nameList.add("차범근");
			nameList.add("이순신");
			List membersList = memberDAO.foreachSelect(nameList);
			
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
		
		} else if(action.equals("foreachInsert")) {
			
			List<MemberVO> membersList = new ArrayList<>();
			membersList.add(new MemberVO("m1","1234","박길동","m1@test.com"));
			membersList.add(new MemberVO("m2","1234","이길동","m1@test.com"));
			membersList.add(new MemberVO("m3","1234","김길동","m1@test.com"));
			
			int result = memberDAO.foreachInsert(membersList);
			nextPage = "/mem4.do?action=listMembers";
			
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}
