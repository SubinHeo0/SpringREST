package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	// http://localhost:8088/controller/create
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createGET() {
		log.info("createGET() 호출");
	}
	
}