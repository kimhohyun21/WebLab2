package com.sist2;

import java.lang.reflect.*;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args){
		try{
			Scanner scan=new Scanner(System.in);
			System.out.println("명령어 입력: ");
			
			String cmd=scan.nextLine();
			Class clsName=Class.forName("com.sist2.BoardModel");
			Object obj=clsName.newInstance();
			
			//BoardModel 안에 있는 메소드를 array로 받아 오기
			Method[] methods=clsName.getDeclaredMethods();
			
			//메소드를 하나씩 출력
			for(Method m : methods){
				RequestMapping rm=m.getAnnotation(RequestMapping.class);
				if(cmd.equals(rm.value())){
					String msg=(String) m.invoke(obj);
					System.out.println(msg);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
