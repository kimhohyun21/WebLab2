package com.sist;
/*
 * #Java Annotation
 * 	3. Custom Annotations Ÿ���� ���ǿ� ����
 * 		3) ������̼� ����
 * 			- �⺻ ������Ʈ value : ������̼� ������ �� ������Ʈ �̸� ���� ����* 		
 * 			 
 * 
 */
public class Service {
	
	@PrintAnnotation
	public void method1(){
		System.out.println("�޼ҵ�1 ����");
	}
	
	@PrintAnnotation("*")
	public void method2(){
		System.out.println("�޼ҵ�2 ����");
	}
	
	@PrintAnnotation(value="#", number=20)
	public void method3(){
		System.out.println("�޼ҵ�3 ����");
	}
	
}
