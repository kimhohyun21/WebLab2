package com.sist.model;

import com.sist.controller.Controller;

//2. ������̼� ����
@Controller("b.do")
public class B implements Model{

	@Override
	public String execute() {
		return "B Class";
	}

}
