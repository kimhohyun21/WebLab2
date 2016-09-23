package com.model;

import java.util.*;
import com.model.*;
import com.dao.*;

public class ListModel {
	public List<MemberDTO> handlerRequest() throws Exception{
		List<MemberDTO> list=new ArrayList<>();
		list.add(new MemberDTO("최씨", "여자","경기"));
		list.add(new MemberDTO("정명공주", "여자","제주"));
		list.add(new MemberDTO("이순신", "남자","광주"));
		
		return list;
	}
}
