package com.sist2;

public class BoardModel {
	@RequestMapping("list")
	public String board_list(){
		////
		return "�Խ��� ���";
	}
	
	@RequestMapping("content")
	public String board_content(){
		////
		return "���뺸��";
	}
	
	@RequestMapping("insert")
	public String board_insert(){
		////
		return "�۾���";
	}
	
	@RequestMapping("update")
	public String board_update(){
		////
		return "�����ϱ�";
	}
	
	@RequestMapping("delete")
	public String board_delete(){
		////
		return "�����ϱ�";
	}
}
