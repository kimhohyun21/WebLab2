package com.sist2;

public class BoardModel {
	@RequestMapping("list")
	public String board_list(){
		////
		return "게시판 목록";
	}
	
	@RequestMapping("content")
	public String board_content(){
		////
		return "내용보기";
	}
	
	@RequestMapping("insert")
	public String board_insert(){
		////
		return "글쓰기";
	}
	
	@RequestMapping("update")
	public String board_update(){
		////
		return "수정하기";
	}
	
	@RequestMapping("delete")
	public String board_delete(){
		////
		return "삭제하기";
	}
}
