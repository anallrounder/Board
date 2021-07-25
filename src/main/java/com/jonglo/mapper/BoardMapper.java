package com.jonglo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jonglo.VO.BoardVO;

@Mapper
public interface BoardMapper {

	// list
	public List<BoardVO> getList();
	
	/* content_view */
	
	// get content
	public BoardVO getContent(int bgroup);

	// hit update
	public void uphit(BoardVO bvo);

	// get reply
	public List<BoardVO> getReply(int bgroup);

	// count reply
	public int countReply(BoardVO bvo);
	
	// delete Board
	public void deleteBoard(int bgroup);
	
	//insert
	public void insert(BoardVO bvo);

	//update
	public void update(BoardVO bvo);

}
