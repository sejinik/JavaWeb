package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */

//sessionbindingListner를 제외하고는 애너테이션을 이용해서 리스너로 등록
@WebListener
public class LoginImpl implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user=0;

    public LoginImpl() {}

    public LoginImpl(String id,String pw) {
    	this.user_id=id;
    	this.user_pw=pw;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("세션 생성");
         ++total_user;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("세션 소멸");
         --total_user;
    }
	
}
