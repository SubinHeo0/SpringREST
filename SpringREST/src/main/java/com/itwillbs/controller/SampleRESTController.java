package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberVO;

// @RestController : jsp 뷰페이지를 연결X, 데이터 값의 형태로 처리
// => 리턴되는 데이터 타입이 모두 @ResponseBody

@RestController
public class SampleRESTController {
	
	
	private static final Logger log = LoggerFactory.getLogger(SampleRESTController.class);

	// http://localhost:8088/controller/test1
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public @ResponseBody String test1() {
		log.info("test1 호출");
		
		return "ITWILL";
	}
	
	// http://localhost:8088/controller/test2
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public MemberVO test2() {
		log.info("test2 호출");
		
		MemberVO vo = new MemberVO();
		vo.setAge(20);
		vo.setName("itwill");
		vo.setTel("010-1234-5678");
		
		return vo;
	}
	
	// http://localhost:8088/controller/test3
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public @ResponseBody List<MemberVO> test3() {
		log.info("test3 호출");
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		for(int i=0;i<10;i++) {
			MemberVO vo = new MemberVO();
			vo.setAge(i);
			vo.setName("itwill"+i);
			vo.setTel("010-1234-567"+i);
			
			memberList.add(vo);
		}
		
		return memberList;
	}
	
	// http://localhost:8088/controller/test4
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public @ResponseBody Map<Integer, MemberVO> test4() {
		log.info("test4 호출");
		
		Map<Integer, MemberVO> memberMap = new HashMap<Integer, MemberVO>();
		
		for(int i=0;i<10;i++) {
			MemberVO vo = new MemberVO();
			vo.setAge(i);
			vo.setName("itwill"+i);
			vo.setTel("010-1234-567"+i);
			
			memberMap.put(i, vo);
			
		}
		
		return memberMap;
	}
	
	// http://localhost:8088/controller/info
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public void testInfo(@RequestBody MemberVO vo) {
		
		//@RequestBody : 브라우저에서 전달된 JSON 형태의 데이터를
		// 해당 객체로 자동 전환(변환) (동일 이름의 요소)
		
		// @ResponseBody : REST 방식의 리턴데이터를 객체 -> JSON 형태로 변경
		
		log.info(" testInfo() 호출 ");
		
		log.info(vo+"");
		
	}
	
	// http://localhost:8088/controller/sendList
	// 상태정보 전달
	@RequestMapping(value = "/sendList", method = RequestMethod.GET)
	public ResponseEntity<Void> sendListAuth(){
		
		log.info("sendListAuth() 호출");
		// 400에러
		//ResponseEntity<Void> en = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		// 404에러
		//ResponseEntity<Void> en = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		// 200
		ResponseEntity<Void> en = new ResponseEntity<Void>(HttpStatus.OK);
		
		return en;
	}
	
	// http://localhost:8088/controller/sendList2
	// 상태정보 전달
	@RequestMapping(value = "/sendList2", method = RequestMethod.GET)
	public ResponseEntity<List<MemberVO>> sendListAuth2(){
		
		log.info("sendListAuth2() 호출");
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		for(int i=0;i<10;i++) {
			MemberVO vo = new MemberVO();
			vo.setAge(i);
			vo.setName("itwill"+i);
			vo.setTel("010-1234-567"+i);
			
			memberList.add(vo);
		}
		
		ResponseEntity<List<MemberVO>> en = null;
		if(memberList != null) {
			en
			= new ResponseEntity<List<MemberVO>>(memberList, HttpStatus.OK);
		} else {
			en
			= new ResponseEntity<List<MemberVO>>(memberList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return en;
	}
	
	// http://localhost:8088/controller/test
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity testEntity() {
		
		HttpHeaders header = new HttpHeaders();
		
		header.add("Content-Type", "text/html; charset=utf-8");
		String msg = "<script>";
		msg += " alert('성공!'); ";
		msg += "</script>";
		
		return new ResponseEntity(msg,header, HttpStatus.OK);
	}
	
}
