package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import com.sist.dao.*;

public class UpdateModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		MemberVO vo=new MemberVO();
		vo.setId("jung");
		vo.setName("������");
		request.setAttribute("vo", vo);
		
		return "view/update.jsp";
	}

}
