package com.itwillbs.persistence;


import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	
	// 글쓰기
	public int create(BoardVO vo);
	
	// 글조회
	public List<BoardVO> readList();
	
	// 본문조회
	public BoardVO read(Integer bno);
	
	// 글 수정
	public Integer update(BoardVO vo);
	
	// 글 삭제
	public Integer delete(Integer bno);
	
}
