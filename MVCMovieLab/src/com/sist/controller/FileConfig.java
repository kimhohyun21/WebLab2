package com.sist.controller;

import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;

public class FileConfig {
	List<String> list=new ArrayList<>();
	
	public FileConfig(String path){
		try{
			SAXParserFactory spf=SAXParserFactory.newInstance();
			//파서기 생성
			SAXParser sp=spf.newSAXParser();
			
			//
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
			String path="C:\\webProjects\\webLab2\\MVCMovieLab\\src\\";			
			
			for(String pack : list){
				path=path+pack.replace(".", "\\");
				File dir=new File(path);
				File[] files=dir.listFiles();
				
				for(File f : files){
					String name=f.getName(); //MainModel.java
					String ext=name.substring(name.lastIndexOf(".")+1); //java
					
					if(ext.equals("java")){
						String temp=pack+"."+name.substring(0, name.lastIndexOf("."));
						//com.sist.model.MainModel
						fList.add(temp);
					}
				}
			}
			
			path="C:\\webProjects\\webLab2\\MVCMovieLab\\src\\";			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return fList;
	}
}
