package com.sist.controller;
/*
 * # SAX (Simple API for XML)
 * 	1) SAX�� ����
 * 		- SAX�� ������ API��.
 *     	- DOM�� ���������� XML�� �����ϴ� ���α׷��� �ۼ��� �� ǥ������ �������� �� �ִ� API��.
 *  
 *  2) SAX�� DOM ��
 *  	- DOM�� ���� ��ü�� �޸𸮿� �о�鿩 �����ϴ� ���
 *  		==> 'Ʈ�� ��� API'
 *  		==> DOM ���� : XML ������ Ŀ�� ��� �޸� �Ҹ� ŭ ==> DOM ������ �غ��ϴ� ������� ���°� SAX��.
 *		- SAX�� ������ ó������ ���ʷ� �о�鼭 ó���ϴ� ���
 *     		==> '�̺�Ʈ ��� API'
 *   		==> ���� : ���� �޸𸮸� ���� �ý��ۿ��� XML������ ó���� �� ����.
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




































