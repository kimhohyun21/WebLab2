package com.sist.model;

import com.sist.controller.Controller;

//2. 어노테이션 적용
@Controller("a.do")
public class A implements Model{

	@Override
	public String execute() {
		return "A Class";
	}

}
