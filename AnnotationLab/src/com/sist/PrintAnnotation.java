package com.sist;
/*
 * #Java Annotation
 * 	1. ����
 * 		1) Java 5.0���� ó�� �Ұ���
 * 		2) �ڹ� �ҽ� �ڵ忡 �߰��Ǵ� �������� ��Ÿ������ 
 * 		3) Ŭ����, �޼ҵ�, ����, �Ķ����, ��Ű���� ÷���Ͽ�
 * 		       �����Ϸ��� ���� .class�� ���ԵǾ� ������ Ȥ�� ��Ÿ�ӽ� �̿��
 *  
 *  2. ����
 *  	1) Built-in Annotations	
 * 			: @override, @Deprecated.....
 * 	
 *  	2) Custom Annotations
 *  		: Ex) @Controller, @Servlet, @Entity....
 *  
 *  3. Custom Annotations Ÿ���� ���ǿ� ����
 *  	1) ������̼� ���� ��� 
 *  		: �ڵ�󿡼� ������̼��� ������ �� �ִ� ���
 *  		  java.lang.annotation.ElementType�� ���� ����� ����
 *  			- TYPE : class, interface ��
 *  			- FILED : �ʵ�
 *  			- CONSTRUCTOR : ������
 *  			- METHOD : �޼���
 *  			...
 *  
 *  	2) ������̼� ���� ��å
 *  		: ������̼��� ����Ǵ� �ڵ尡 �����Ǵ� ������ �����ϴ� ��
 *  		  java.lang.annotation.RetentionPolicy�� ���� ����� ����
 *  			- SOURCE : �ҽ� �󿡼��� ������̼� ������ ������
 *  				               �ҽ��� �м��� ���� �ǹ̰� ����
 *  					      ����Ʈ �ڵ忡�� ������ ����
 *  			- CLASS : ����Ʈ �ڵ� ���ϱ��� ������̼� ������ ������
 *  			- RUNTIMe : ����Ʈ �ڵ� ���ϱ��� ������̼� ������ �����Ǹ鼭
 *  						���÷����� �̿��ؼ� ������̼� ������ ���� �� ����
 *  	
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//������̼��� ��������� ���� ����
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintAnnotation {
	String value() default "-"; 
	// value(): ������̼������ �⺻���� ���ԵǴ� Element
	// ������̼� ����� �̸��� ������ �� ����

	int number() default 15;
	// �ΰ� �̻��� Element�� ����� ���� value=�� ���·� ���
	// Ư���� ���� ������� �������� default���� �����
}



