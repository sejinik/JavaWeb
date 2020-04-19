package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Rest 방식의 데이터 처리 지원
@RestController
@RequestMapping("/test/*")
public class TestController {

	static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST!!";
	}
	
	@RequestMapping("/member")
	public MemberVO member() {
		MemberVO vo = new MemberVO();
		vo.setId("sejinik");
		vo.setPwd("123");
		vo.setName("sejin");
		vo.setEmail("sejinik@gmail.com");
		return vo;
	}
	
	@RequestMapping("/membersList")
	public List<MemberVO> listMembers(){
		List<MemberVO> membersList = new ArrayList<MemberVO>();
		
		for(int i=0;i<10;i++) {
			MemberVO member = new MemberVO();
			member.setId("sejin"+i);
			member.setName("name"+i);
			member.setPwd("pwd"+i);
			member.setEmail("mail"+i);
			membersList.add(member);
		}
		return membersList;
	}
	
	@RequestMapping("/membersMap")
	public Map<Integer, MemberVO> membersMap(){
		Map<Integer, MemberVO> membersMap = new HashMap<Integer, MemberVO>();
		for(int i=0;i<5;i++) {
			MemberVO member = new MemberVO();
			member.setId("id"+i);
			member.setPwd("pwd"+i);
			member.setName("name"+i);
			member.setEmail("email"+i);
			membersMap.put(i, member);
		}
		return membersMap;
	}
	
	@RequestMapping(value="/notice/{num}",method=RequestMethod.GET)
	public int notice(@PathVariable("num") int num) throws Exception {
		return num;
	}
	
	@RequestMapping(value="/info",method=RequestMethod.POST)
	public void modify(@RequestBody MemberVO vo	) {
		logger.info(vo.toString());
	}
	
	@RequestMapping(value="/membersList2")
	public ResponseEntity<List<MemberVO>> listMembers2(){
		List<MemberVO> membersList = new ArrayList<MemberVO>();
		
		for(int i=0;i<10;i++) {
			MemberVO member = new MemberVO();
			member.setId("sejin"+i);
			member.setName("name"+i);
			member.setPwd("pwd"+i);
			member.setEmail("mail"+i);
			membersList.add(member);
		}
		return new ResponseEntity<List<MemberVO>>(membersList,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value="/res3")
	public ResponseEntity res3() {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		String message = "<script>";
		message +=" alert('새 회원을 등록합니다'); ";
		message +="location.href='/pro29/test/membersList2'; ";
		message +="</script>";
		return new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	}
}
