package com.model;

import java.util.*;
import com.model.*;
import com.dao.*;

public class ListModel {
	public List<MemberDTO> handlerRequest() throws Exception{
		List<MemberDTO> list=new ArrayList<>();
		list.add(new MemberDTO("�־�", "����","���"));
		list.add(new MemberDTO("�������", "����","����"));
		list.add(new MemberDTO("�̼���", "����","����"));
		
		return list;
	}
}
