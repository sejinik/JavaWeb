package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
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
	public ModelAndView login2(@RequestParam Map<String, String> info, HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("info",info);
		mav.setViewName("result");
		return mav;
	}
}
