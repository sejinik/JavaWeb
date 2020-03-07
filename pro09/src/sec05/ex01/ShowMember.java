package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/show")
public class ShowMember extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id="",pw="";
		Boolean isLogOn = false;
		
		//세션이 있다면 가져오고 없다면 null
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			isLogOn = (Boolean)session.getAttribute("isLogOn");
			if(isLogOn) {
				id=(String)session.getAttribute("login.id");
				pw=(String)session.getAttribute("login.pw");
				out.print("<html><body>");
				out.print("아이디 : "+id+"<br>");
				out.print("비밀번호 : "+pw+"<br>");
				out.print("</body></html>");
			} else {
				response.sendRedirect("login3.html");
			}
		} else {
			response.sendRedirect("login3.html");
		}
		
	}


}
