package com.jonglo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jonglo.VO.BoardVO;
import com.jonglo.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper bmapper;
	
	//list
	@Override
	public List<BoardVO> getList() {
		log.info("service list");
		
		return bmapper.getList();
	}
	
	//get Content
	@Override
	public BoardVO getContent(int bgroup) {
		log.info("service get content");
		return bmapper.getContent(bgroup);
	}

	// hit update
	@Override
	public void uphit(BoardVO bvo) {
		log.info("service hit update");
		bmapper.uphit(bvo);
	}

	// get Reply
	@Override
	public List<BoardVO> getReply(int bgroup) {
		log.info("service get reply");
		return bmapper.getReply(bgroup);
	}

	// count reply
	@Override
	public int countReply(BoardVO bvo) {
		log.info("service count reply");
		return bmapper.countReply(bvo);
	}
	

	@Override
	public void deleteBoard(int bgroup) {
		log.info("service -- delete board");
		bmapper.deleteBoard(bgroup);
	}

	@Override
	public void insert(BoardVO bvo) {
		bmapper.insert(bvo);
	}

	@Override
	public void update(BoardVO bvo) {
		bmapper.update(bvo);
		
	}
	
}
