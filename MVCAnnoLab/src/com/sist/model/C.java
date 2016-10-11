package com.sist.model;

import com.sist.controller.Controller;

//2. 어노테이션 적용
@Controller("c.do")
public class C implements Model{

	@Override
	public String execute() {
		return "C Class";
	}

}
