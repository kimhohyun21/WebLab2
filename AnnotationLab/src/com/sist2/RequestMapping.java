package com.sist2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * #������̼� ���� ����
 * 	1. @������̼� ����
 * 	2. @������̼� Ÿ�ٿ� ����
 * 	3. @������̼� ���(������ ����)
 * 	4. �Ϸ�
 * 
 * ==> MVC �𵨿� ����
 * 		: ������ beans.xml�� ������ Model�� ����Ʈ��, 
 * 		  DispatcherSevlet�� ������ ������ ���
 * 		  @������̼��� Ȱ���ϸ� ȿ�뼺�� ���� �� �� ����	
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMapping {
	public String value();
	
}
