package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardVO;

@RestController
@RequestMapping("/boards")
public class BoardRestController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardRestController.class);
	
	// http://localhost:8088/controller/boards/
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> addBoard(@RequestBody BoardVO vo) {
		
		log.info(" addBoard() 호출 ");
		
		log.info(" 글쓰기 정보 : "+vo);
		
		// 서비스 - 
		
		// 글 처리 결과에 따른 상태 정보 리턴
		
		return null;
		
	}
	
	
}
