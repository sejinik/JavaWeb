package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DataSource를 이용한 db조회
//톰캣에 context.xml파일에서 resource설정
//이 때 name이 DataSource에 대한 JNDI 이름 ( => key값)
//key값을 통해 DataSource와 연결 ( => ConnectionPool과 연결)
public class MemberDAO {
	//DB 접속정보
	/*
	 * private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "c##sejin";
	private static final String pwd = "1234";
	*/
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			//JNDI에 접근하기 위해 기본 경로("java:/comp/env")를 지정한다
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			//톰캣 context.xml에 설정한 name값인 ("jdbc/oracle")을 이용해 톰캣이 미리 연결한 DataSource를 가져온다
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<>();
		try {
			//DB연결
			//connDB();
			
			//DataSoutce를 이용해 DB에 연결
			con = dataFactory.getConnection();
			//query 저장
			String query = "select * from t_member";
			System.out.println("preapreStatement : "+query);
			//query의 결과를 rs에 담는다
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			//query의 끝까지 확인하며 MemberVO 클래스의 형태로 list담는다
			while(rs.next()) {
				//자료형의 형태 그대로 담아오면 된다
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//Oracle과 연동 
	/*private void connDB() {
		try {
			//driver 확인
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			//해당 url,user,pwd를 이용해 연결
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection 생성  성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
