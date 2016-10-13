package com.sist.controller;

import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/*
 * <?xml encoding="EUC-KR">  
 * 							 ==> startDocument() : ������ ����
 * <beans>					 ==> startElement()
 * 	<context:component />	 ==> startElement() �Ӽ� �б� endElement()
 *  <context:component />	 ==> startElement() �Ӽ� �б� endElement()	
 *  <context:component />	 ==> startElement() �Ӽ� �б� endElement()		
 * </beans>					 ==> endElement()
 * 							 ==> endDocument() : ���� ��
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
				 String pack=attributes.getValue("base-package"); // ��Ű�� �̸�
				 list.add(pack);
			 }
				 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
}
