package com.jonglo.service;

import java.util.List;

import com.jonglo.VO.BoardVO;

public interface BoardService {
		
	// list
	public List<BoardVO> getList();

	// content_view - get content
	public BoardVO getContent(int bgroup);
	
	// content_view - hit update
	public void uphit(BoardVO bvo);
	
	// content_view - get reply
	public List<BoardVO> getReply(int bgroup);

	// content_view - count reply
	public int countReply(BoardVO bvo);

	// delete - Board
	public void deleteBoard(int bgroup);

	//insert
	public void insert(BoardVO bvo);

	//update
	public void update(BoardVO bvo);
}
