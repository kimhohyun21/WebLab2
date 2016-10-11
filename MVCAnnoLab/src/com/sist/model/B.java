package com.sist.model;

import com.sist.controller.Controller;

//2. 어노테이션 적용
@Controller("b.do")
public class B implements Model{

	@Override
	public String execute() {
		return "B Class";
	}

}
