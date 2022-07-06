package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	// http://localhost:8088/controller/create
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createGET() {
		log.info("createGET() 호출");
	}
	
	// http://localhost:8088/controller/all
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String readGET() {
		return "read";
	}
	
	// http://localhost:8088/controller/461
	@RequestMapping(value = "/{bno}", method = RequestMethod.GET)
	public String readContentGET(@PathVariable("bno") Integer bno, Model model) {
		System.out.println("################# readContentGET() ");
		
		System.out.println("조회 글번호 : "+bno);
		
		// 서비스 동작 호출
		BoardVO vo = service.readContent(bno);
		System.out.println(vo);
		
		model.addAttribute("vo", vo);
		
		return "content";
		
	}
	
}
