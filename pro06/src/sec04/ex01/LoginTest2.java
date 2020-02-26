package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginTest2")
public class LoginTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("loginTest2 init");
	}

	
	public void destroy() {
		System.out.println("loginTest2 destroy");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		System.out.println("ID : "+id);
		System.out.println("PW : "+pw);
			
		if(id==null || id.length()==0) {
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요!!!");
			out.print("<br>");
			out.print("<a href='http://localhost:8090/pro06/test01/login.html'>로그인 창으로 이동</a>");
			out.print("</body>");
			out.print("</html>");
		} else if(id.equals("admin")) {
			out.print("<html>");
			out.print("<body>");
			out.print("<h3>admin님이 로그인 하셨습니다</h3>");
			out.print("<input type='button' value='회원정보 수정하기'>");
			out.print("<input type='button' value='회원정보 삭제하기'>");
			out.print("</body>");
			out.print("</html>");
		} else {
			out.print("<html>");
			out.print("<body>");
			out.print(id+"님 로그인 하셨습니다!!");
			out.print("</body>");
			out.print("</html>");
		}
	}

}
