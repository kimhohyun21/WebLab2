package com.sist.controller;

import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlerMapping extends DefaultHandler{
	Map map=new HashMap();
	
	/*
	 * qName : 태그
	 * attributes : 속성
	 *
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try{
			if(qName.equals("bean")){
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				Class clsName=Class.forName(cls);
				Object obj=clsName.newInstance();
				map.put(id, obj);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
