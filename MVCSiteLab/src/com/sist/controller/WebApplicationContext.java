package com.sist.controller;
/*
 * # SAX (Simple API for XML)
 * 	1) SAX의 정의
 * 		- SAX도 일종의 API임.
 *     	- DOM과 마찬가지로 XML을 조작하는 프로그램을 작성할 때 표준으로 제공받을 수 있는 API임.
 *  
 *  2) SAX와 DOM 비교
 *  	- DOM은 문서 전체를 메모리에 읽어들여 조작하는 방식
 *  		==> '트리 기반 API'
 *  		==> DOM 단점 : XML 문서가 커질 경우 메모리 소모가 큼 ==> DOM 단점을 극복하는 대안으로 나온게 SAX임.
 *		- SAX는 문서를 처음부터 차례로 읽어가면서 처리하는 방식
 *     		==> '이벤트 기반 API'
 *   		==> 장점 : 적은 메모리를 가진 시스템에서 XML문서를 처리할 수 있음.
 */
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



import java.io.*;
public class WebApplicationContext {
	private Map clsMap=new HashMap();
	
	public WebApplicationContext(String path){
		try{
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser();
			HandlerMapping hm=new HandlerMapping();
			
			sp.parse(new File(path), hm);
			clsMap=hm.map;
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public Object getBean(String key){
		return clsMap.get(key);
	}
}




































