package com.sist;
/*
 * #Java Annotation
 * 	3. Custom Annotations 타입의 정의와 적용
 * 		3) 어노테이션 적용
 * 			- 기본 엘리먼트 value : 어노테이션 적용할 때 엘리먼트 이름 생략 가능* 		
 * 			 
 * 
 */
public class Service {
	
	@PrintAnnotation
	public void method1(){
		System.out.println("메소드1 실행");
	}
	
	@PrintAnnotation("*")
	public void method2(){
		System.out.println("메소드2 실행");
	}
	
	@PrintAnnotation(value="#", number=20)
	public void method3(){
		System.out.println("메소드3 실행");
	}
	
}
