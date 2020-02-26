package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	//DB 접속정보
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "c##sejin";
	private static final String pwd = "1234";
	private Connection con;
	private Statement stmt;
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<>();
		try {
			//DB연결
			connDB();
			//query 저장
			String query = "select * from t_member";
			System.out.println(query);
			//query의 결과를 rs에 담는다
			ResultSet rs = stmt.executeQuery(query);
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
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//Oracle과 연동 
	private void connDB() {
		try {
			//driver 확인
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			//해당 url,user,pwd를 이용해 연결
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection 생성  성공");
			//연결 후 statement 설정
			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
