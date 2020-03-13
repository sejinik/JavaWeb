# JavaWeb
자바 웹을 다루는 기술 실습코드입니다

## 오류목록
### oracle 18c에서 계정생성시 
  - username에 c## 추가 ex) sejin -> c##sejin
----
### ora-28040: 일치하는 인증 프로토콜 없음
  - C:\app\USER\product\18.0.0\dbhomeXE\network\admin 에서 sqlnet.ora 파일 마지막줄에 다음 
  - SQLNET.ALLOWED_LOGON_VERSION_SERVER=9
  - SQLNET.ALLOWED_LOGON_VERSION_CLIENT=9
----

### Multiple annotations found at this line
  - JSP에서 표현언어를 사용할 때 톰캣에서는 돌아가지만 이클립스에서 해당 에러가 발생할 때
  - Build path => Add Library => Server Runtime Library 추가
