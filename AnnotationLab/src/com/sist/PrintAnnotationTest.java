package com.sist;

import java.lang.reflect.Method;

/*
 * #Java Annotation
 * 	4. ������̼� �̿�  : ��Ÿ�ӽ� ������̼� ���� ���
 * 		1) Ŭ������ ����� ������̼� ���� ���
 * 			: Ŭ���� .class �� ������̼� ������ ��� �޼ҵ� �̿�
 * 		2) �ʵ�, ������, �޼ҵ忡 ����� ������̼� ���� ���
 * 			: java.lang.reflect ��Ű���� Field, Constructor, Method Ŭ������ �迭�� ��
 * 				- Field[], getField() 
 * 					==> �ʵ� ������ Field �迭�� ����
 * 				- Constructor[], getConstructors()
 * 					==> ������ ������ Constructor�迭�� ����
 * 				- Method[], getDeclaredMethods()
 * 					==> �޼ҵ� ������ Method�迭�� ����
 * 
 */
public class PrintAnnotationTest {
	public static void main(String[] args) {
		//Service Ŭ�����κ��� �޼ҵ� ������ ����.
		Method[] declaredMethods=Service.class.getDeclaredMethods();
		
		//Method ��ü�� �ϳ��� ó��
		for(Method method : declaredMethods){
			//PrintAnnotation ��ü ���
			if(method.isAnnotationPresent(PrintAnnotation.class)){
				//PrintAnnotation ��ü ���
				//Ư��Ÿ�Կ� ���� Annotation�� ����
				PrintAnnotation printAnnotation=method.getAnnotation(PrintAnnotation.class);
				
				//�޼ҵ� �̸� ���
				System.out.println("["+method.getName()+"]");
				
				//������̼� ����(-,*,# ���м�) ���
				for(int i=0;i<printAnnotation.number();i++){
					System.out.println(printAnnotation.value());
				}
				System.out.println();
				
				try{
					//�ش� �޼ҵ带 ȣ����
					method.invoke(new Service());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
