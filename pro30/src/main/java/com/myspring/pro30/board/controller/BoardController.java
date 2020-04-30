package com.myspring.pro30.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface BoardController {
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse rsHttpServletResponse) throws Exception;
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartHttpServletRequest, HttpServletResponse response) throws Exception;
}
