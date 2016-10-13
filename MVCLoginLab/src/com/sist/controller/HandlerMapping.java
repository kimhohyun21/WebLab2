package com.sist.controller;

import java.util.*;
import java.io.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlerMapping extends DefaultHandler {
	List<String> list=new ArrayList<>();
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try{
			
			if(qName.equals("context:component-scan")){
				String pack=attributes.getValue("base-package");
				list.add(pack);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
