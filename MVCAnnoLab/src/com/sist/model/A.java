package com.sist.model;

import com.sist.controller.Controller;

//2. ������̼� ����
@Controller("a.do")
public class A implements Model{

	@Override
	public String execute() {
		return "A Class";
	}

}
