package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class Loginservlet extends HttpServlet {

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

		address = URLEncoder.encode(address,"utf-8");
		// second 서블릿으로 get방식으로 url에 변수를 추가해 보낸다
		// 변수가 많거나 보안이 중요하면 못 쓸 방법
		out.print("<a href='/pro09/second?id="+id+
										"&pw="+pw+
										"&address="+address+
										"&email="+email+
										"&hp="+hp+
										"'>두번째 서블릿으로 보내기</a>");
	}

}
