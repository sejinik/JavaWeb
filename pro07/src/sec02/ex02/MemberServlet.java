package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member3")
public class MemberServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	//command값을 이용해 servlet에서 어떤 명령인지 확인한다
	private void doHandle(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		PrintWriter out = res.getWriter();
		String command = req.getParameter("command");
		
		if(command !=null && command.equals("addMember")) {
			String _id = req.getParameter("id");
			String _pw = req.getParameter("pw");
			String _name = req.getParameter("name");
			String _email = req.getParameter("email");
			
			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pw);
			vo.setName(_name);
			vo.setEmail(_email);
			dao.addMember(vo);
		} else if(command !=null && command.equals("delMember")) {
			String id = req.getParameter("id");
			dao.delMember(id);
		}
		List list = dao.listMembers();
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</tr>");
		
		
		for(int i=0;i<list.size();i++) {
			MemberVO vo = (MemberVO)list.get(i);
			String id = vo.getId();
			String pw = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			Date joinDate = vo.getJoinDate();
			
			out.print("<tr>");
			out.print("<td>"+id+"</td>");
			out.print("<td>"+pw+"</td>");
			out.print("<td>"+name+"</td>");
			out.print("<td>"+email+"</td>");
			out.print("<td>"+joinDate+"</td>");
			//직접 command를 delMember로주고 id값에 현재 id를 넣고 삭제하고싶을때 클릭하면 delMember가 실행하게 해준다
			out.print("<td><a href='member3?command=delMember&id="+id+"'>삭제</a></td>");
			out.print("</tr>");
		}
		out.print("</table></body></html>");
		out.print("<a href='MemberForm.html'>새 회원 등록하기</a>");
		
	}
}
