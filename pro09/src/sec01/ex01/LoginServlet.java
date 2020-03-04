package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		String email = request.getParameter("user_email");
		String hp = request.getParameter("user_hp");
		
		String data = "안녕하세요!<br> 로그인하셨습니다. <br><br>";
		data+="<html><body>";
		data+="아이디 : "+id+"<br>";
		data+="비밀번호 : "+pw+"<br>";
		data+="주소 : "+address+"<br>";
		data+="메일 : "+email+"<br>";
		data+="휴대폰 : "+hp+"<br>";
		data+="</body></html>";
		out.print(data);
	}
}
