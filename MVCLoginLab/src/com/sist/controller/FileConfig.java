package com.sist.controller;

import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;

public class FileConfig {
	List<String> list=new ArrayList<>();
	
	public FileConfig(String path) {
		try{
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser();
			
			HandlerMapping hm=new HandlerMapping();
			sp.parse(new File(path), hm);
			list=hm.list;
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<String> componentScan(){
		List<String> fList=new ArrayList<>();
		
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return fList;
	}
}
