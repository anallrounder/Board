package com.jonglo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jonglo.VO.BoardVO;
import com.jonglo.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Boardcontroller {
	
	private final BoardService bservice;
	
	// list
	@RequestMapping(method = RequestMethod.GET, value = "/board/list")
	public ModelAndView boardList(ModelAndView mav) throws Exception {
		log.info("controller -- list");
		
		mav.addObject("blist", bservice.getList());
		mav.setViewName("board/list");
		
		return mav;
	}
	
	// content_view
	@GetMapping("/board/content/{bgroup}")
	public ModelAndView contentView(HttpServletRequest request, ModelAndView mav, BoardVO bvo) throws Exception {
		log.info("controller -- contentView" + bvo.getBgroup(), bvo);
		
		mav.addObject("content_view", bservice.getContent(bvo.getBgroup())); //컨텐트 조회 
		bservice.uphit(bvo); //조회수 업데이트
		
		mav.addObject("rlist", bservice.getReply(bvo.getBgroup())); //댓글 조회
		//mav.addObject("countReply", bservice.countReply(bvo)); // 댓글수 카운트
		
		mav.setViewName("board/content_view");
		
		return mav;
	}
	
	//delete - board 
	@DeleteMapping("/board/{bid}")
	public ModelAndView delete(ModelAndView mav, @PathVariable("bid") int bid) throws Exception {
		log.info("controller - delete");
		
		bservice.deleteBoard(bid);
		
		mav.setViewName("redirect:/board/list");
		
		return mav;
	}
	
	//write_view
	@GetMapping("/board/write_view")
	public ModelAndView writeView(ModelAndView mav) throws Exception {
		log.info("controller -- write_view");
		
		mav.setViewName("/board/write_view");	
		
		return mav;
	}
	
	//insert
	@PostMapping("/board/write")
	public ModelAndView write(ModelAndView mav, BoardVO bvo) throws Exception {
		bservice.insert(bvo);
		mav.setViewName("redirect:/board/list");
		return mav;
	}
	
	// modify_view
	@GetMapping("/board/{bid}/mod")
	public ModelAndView modifyView(ModelAndView mav, BoardVO bvo) throws Exception {
		log.info("controller -- contentView" + bvo);
		
		mav.addObject("modify_view", bservice.getContent(bvo.getBid())); //컨텐트 조회
		mav.addObject("rlist", bservice.getReply(bvo.getBgroup())); //댓글 조회
	//	mav.addObject("countReply", bservice.countReply(bvo.getBgroup())); // 댓글수 카운트
		
		mav.setViewName("/board/modify_view");
		
		return mav;
	}
	
	//modify
	@PutMapping("/board/{bid}")
	public ModelAndView modify(ModelAndView mav, BoardVO bvo) throws Exception {
		log.info("controller -- modify" );
		
		bservice.update(bvo);
		
		mav.setViewName("redirect:/board/list");
		
		return mav;
	}
}
