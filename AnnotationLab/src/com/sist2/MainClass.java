package com.sist2;

import java.lang.reflect.*;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args){
		try{
			Scanner scan=new Scanner(System.in);
			System.out.println("��ɾ� �Է�: ");
			
			String cmd=scan.nextLine();
			Class clsName=Class.forName("com.sist2.BoardModel");
			Object obj=clsName.newInstance();
			
			//BoardModel �ȿ� �ִ� �޼ҵ带 array�� �޾� ����
			Method[] methods=clsName.getDeclaredMethods();
			
			//�޼ҵ带 �ϳ��� ���
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
