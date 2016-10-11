package com.sist;

import java.lang.reflect.Method;

/*
 * #Java Annotation
 * 	4. 어노테이션 이용  : 런타임시 어노테이션 정보 얻기
 * 		1) 클래스에 적용된 어노테이션 정보 얻기
 * 			: 클래스 .class 의 어노테이션 정보를 얻는 메소드 이용
 * 		2) 필드, 생성자, 메소드에 적용된 어노테이션 정보 얻기
 * 			: java.lang.reflect 패키지의 Field, Constructor, Method 클래스의 배열을 얻어냄
 * 				- Field[], getField() 
 * 					==> 필드 정보를 Field 배열로 리턴
 * 				- Constructor[], getConstructors()
 * 					==> 생성자 정보를 Constructor배열로 리턴
 * 				- Method[], getDeclaredMethods()
 * 					==> 메소드 정보를 Method배열로 리턴
 * 
 */
public class PrintAnnotationTest {
	public static void main(String[] args) {
		//Service 클래스로부터 메소드 정보를 얻음.
		Method[] declaredMethods=Service.class.getDeclaredMethods();
		
		//Method 객체를 하나씩 처리
		for(Method method : declaredMethods){
			//PrintAnnotation 객체 얻기
			if(method.isAnnotationPresent(PrintAnnotation.class)){
				//PrintAnnotation 객체 얻기
				//특정타입에 대한 Annotation을 리턴
				PrintAnnotation printAnnotation=method.getAnnotation(PrintAnnotation.class);
				
				//메소드 이름 출력
				System.out.println("["+method.getName()+"]");
				
				//어노테이션 내용(-,*,# 구분선) 출력
				for(int i=0;i<printAnnotation.number();i++){
					System.out.println(printAnnotation.value());
				}
				System.out.println();
				
				try{
					//해당 메소드를 호출함
					method.invoke(new Service());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
