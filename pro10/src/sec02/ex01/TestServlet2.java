package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//디렉토리 이름만 일치하는 URL 패턴
@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath();
		String url = request.getRequestURL().toString();
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Test Servlet2</title>");
		out.print("</head><body bdcolor ='yellow'>");
		out.print("<b>TestServlet2입니다.</b><br>");
		out.print("<b>컨텍스트명 : "+context+"</b><br>");
		out.print("<b>전체경로 : "+url+"</b><br>");
		out.print("<b>매핑명 : "+mapping+"</b><br>");
		out.print("<b>URI : "+uri+"</b><br>");
		out.print("</body></html>");
		out.close();
	}


}
