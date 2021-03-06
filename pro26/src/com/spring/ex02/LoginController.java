package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	
	@RequestMapping(value= {"/test/loginForm.do","/test/loginForm2.do"},method = {RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
	@RequestMapping(value="/test/login.do",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		mav.setViewName("result");
		return mav;
	}
	
	//@RequestParam을 이용해서 매개변수가 userID면 변수 userID에 넣는다
	@RequestMapping(value="/test/login2.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login2(@RequestParam("userID") String userID, @RequestParam(value="userName", required=true) String userName, @RequestParam(value="email", required=false) String email , HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("userID : "+userID);
		System.out.println("userName : "+userName);
		System.out.println("email : "+email);
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		mav.addObject("email",email);
		mav.setViewName("result");
		return mav;
	}
	
	// Map을 통해 info라는 맵에 넘어오는 매개변수들을 저장하는것도 가능하다 "이름" : 값 형태로 저장된다
	@RequestMapping(value="/test/login3.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login3(@RequestParam Map<String, String> info, HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("info",info);
		mav.setViewName("result");
		return mav;
	}
	
	// 넘어오는 매개변수를 LoginVO 객체인 loginVO에 이름이 같은 속성에 자동으로 매핑시킨다.
	// 그 후 info 라는 이름으로 mav에 바인딩 시킨다
	// jsp에서 info 로 접근해서 바로 사용가능하다!
	@RequestMapping(value="/test/login4.do",method=RequestMethod.POST)
	public ModelAndView login4(@ModelAttribute("info") LoginVO loginVO ,HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("result");
		return mav;
	}
	
}
