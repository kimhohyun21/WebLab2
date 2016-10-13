package com.sist.controller;

import java.io.*;
import java.util.*;

public class FileConfig {
	public static List<String> componentScan(String pack){
		List<String> list=new ArrayList<>();
		
		try{
			String path="C:\\webProjects\\webLab2\\MVCAnnoLab\\src\\";
			path=path+pack.replace(".", "\\");
			//path="C:\webProjects\webLab2\MVCAnnoLab\src\com\sist\model";
			//path에서 궁극적으로 com.sist.model.A, com.sist.model.B. com.sist.model.C를 읽어 올수 있게 됨
			
			File dir=new File(path);
			File[] files=dir.listFiles(); // A, B, C가 담기게 됨
			
			for(File file : files){
				String name=file.getName(); // A.java
				String ext=name.substring(name.lastIndexOf(".")+1); //java
				if(ext.equals("java")){
					String clsName=pack+"."+name.substring(0, name.lastIndexOf(".")); //com.sist.model.A, B, C
					list.add(clsName);					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
}
