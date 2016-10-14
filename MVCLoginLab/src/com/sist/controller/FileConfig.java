package com.sist.controller;

import java.io.*;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
			String path="C:\\webProjects\\webLab2\\MVCLoginLab\\src\\";
			for(String pack : list){
				//==> src\\com\\sist\\member\\model
				
				path=path+pack.replace(".", "\\");
				File file=new File(path);
				File[] files=file.listFiles();
				for(File f: files){
					String name=f.getName(); //==> MemberModel.java
					String ext=name.substring(name.lastIndexOf(".")+1); //==> java
					if(ext.equals("java")){
						String temp=pack+"."+name.substring(0, name.lastIndexOf(".")); 
						//==> com.sist.member.model.MemberModel
						
						fList.add(temp);
					}
				}
				path="C:\\webProjects\\webLab2\\MVCLoginLab\\src\\";
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return fList;
	}
}
