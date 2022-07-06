package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	
	// 글쓰기 (create)
	public int createBoard(BoardVO vo);
	
	// 글조회 (read)
	public List<BoardVO> readBoardList();
	
	// 글본문조회
	public BoardVO readContent(Integer bno);
	
	// 글 수정
	public Integer updateBoard(BoardVO vo);
	
	// 글 삭제
	public Integer deleteBoard(Integer bno);
	
}
