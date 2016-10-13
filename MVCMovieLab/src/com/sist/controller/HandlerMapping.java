package com.sist.controller;

import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/*
 * <?xml encoding="EUC-KR">  
 * 							 ==> startDocument() : 문서가 시작
 * <beans>					 ==> startElement()
 * 	<context:component />	 ==> startElement() 속성 읽기 endElement()
 *  <context:component />	 ==> startElement() 속성 읽기 endElement()	
 *  <context:component />	 ==> startElement() 속성 읽기 endElement()		
 * </beans>					 ==> endElement()
 * 							 ==> endDocument() : 문서 끝
 * 
 * 
 * 
 */
public class HandlerMapping extends DefaultHandler{
	List<String> list=new ArrayList<>();
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		 try{
			 if(qName.equals("context:component-scan")){
				 String pack=attributes.getValue("base-package"); // 패키지 이름
				 list.add(pack);
			 }
				 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
}
