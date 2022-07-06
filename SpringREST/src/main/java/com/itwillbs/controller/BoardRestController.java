package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@RestController
@RequestMapping("/boards")
public class BoardRestController {
	
	@Inject
	private BoardService service;
	
	private static final Logger log = LoggerFactory.getLogger(BoardRestController.class);
	
	// http://localhost:8088/controller/boards/
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> addBoard(@RequestBody BoardVO vo) {
		
		log.info(" addBoard() 호출 ");
		
		log.info(" 글쓰기 정보 : "+vo);
		
		// 서비스 - 
		int result = service.createBoard(vo);
		// 글 처리 결과에 따른 상태 정보 리턴
		ResponseEntity<String> entity = null;
		
		if(result == 1) {
			// 정상 글쓰기 처리
			entity = new ResponseEntity<String>("addOK", HttpStatus.OK);
		}else {
			// 비정상 글쓰기 처리
			entity = new ResponseEntity<String>("addErr", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
		
	}
	
	// http://localhost:8088/controller/boards/all
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> readAll(){
		System.out.println("@@@@@@@@@@@@@@@@@@ readAll()");
		
		// 서비스 동작
		List<BoardVO> boardList = service.readBoardList();
		log.info("boardList : "+boardList);
		
		// 상태에 따른 처리 구분
		ResponseEntity<List<BoardVO>> entity = null;
		
		try {
			entity = new ResponseEntity<List<BoardVO>>(boardList,HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// http://localhost:8088/controller/boards/461
	@RequestMapping(value = "/{bno}", method = RequestMethod.GET)
	public ResponseEntity<BoardVO> readContnet(@PathVariable("bno") Integer bno){
		
		BoardVO vo = service.readContent(bno);
		ResponseEntity<BoardVO> entity = null;
		
		if(vo != null) {
			entity = new ResponseEntity<BoardVO>(vo, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<BoardVO>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	// http://localhost:8088/controller/boards/461
	@RequestMapping(value = "/{bno}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyBoard(
			@RequestBody BoardVO vo, @PathVariable("bno") int bno){
		// 글 번호 정보, 수정 정보 저장
		System.out.println("@@@ bno : "+bno);
		System.out.println("@@@ vo : "+vo);
		vo.setBno(bno);
		System.out.println("@@@ vo : "+vo);
		
		// 서비스 = 글정보 수정동작 호출
		int result = service.updateBoard(vo);
		
		ResponseEntity<String> entity = null;
		// 수정 여부에 따라 메세지 전달
		if(result == 1) {
			entity = new ResponseEntity<String>("modOK", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("modErr", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/{bno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBoard(@PathVariable("bno") int bno){
		// 삭제할 글번호 가져오기
		System.out.println("@@@@@@@@@ bno(del) : "+bno);
		// 서비스 - 글 삭제 동작 호출
		int result = service.deleteBoard(bno);
		
		ResponseEntity<String> entity = null;
		// 삭제 결과에 따른 페이지 이동 처리
		if(result == 1) {
			entity = new ResponseEntity<String>("delOK", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("delErr", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	
}
