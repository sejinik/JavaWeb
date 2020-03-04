package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String hp = request.getParameter("hp");
		
		out.println("<html><body>");
		if(id != null && id.length() !=0 ) {
			out.print("이미 로그인 상태입니다!<br><br>");
			out.print("아이디 : "+id+"<br>");
			out.print("비밀번호 : "+pw+"<br>");
			out.print("주소 : "+address+"<br>");
			out.print("메일 : "+email+"<br>");
			out.print("폰 : "+hp+"<br>");
			out.print("</body></html>");
		} else {
			out.print("로그인 하지 않았습니다.<br><br>");
			out.print("로그인 하세요<br>");
			out.print("<a href='login.html'>로그인하기</a>");
		}
	}



}
