package com.spring.ex04;

import java.io.IOException;
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
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}
