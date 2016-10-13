package com.sist;
/*
 * #Java Annotation
 * 	1. 개념
 * 		1) Java 5.0에서 처음 소개됨
 * 		2) 자바 소스 코드에 추가되는 문법적인 메타데이터 
 * 		3) 클래스, 메소드, 변수, 파라미터, 패키지에 첨언하여
 * 		       컴파일러에 의해 .class에 포함되어 컴파일 혹은 런타임시 이용됨
 *  
 *  2. 종류
 *  	1) Built-in Annotations	
 * 			: @override, @Deprecated.....
 * 	
 *  	2) Custom Annotations
 *  		: Ex) @Controller, @Servlet, @Entity....
 *  
 *  3. Custom Annotations 타입의 정의와 적용
 *  	1) 어노테이션 적용 대상 
 *  		: 코드상에서 어노테이션을 적용할 수 있는 대상
 *  		  java.lang.annotation.ElementType에 열거 상수로 정의
 *  			- TYPE : class, interface 등
 *  			- FILED : 필드
 *  			- CONSTRUCTOR : 생성자
 *  			- METHOD : 메서드
 *  			...
 *  
 *  	2) 어노테이션 유지 정책
 *  		: 어노테이션이 적용되는 코드가 유지되는 시점을 지정하는 것
 *  		  java.lang.annotation.RetentionPolicy에 열거 상수로 정의
 *  			- SOURCE : 소스 상에서만 어노테이션 정보를 유지함
 *  				               소스를 분석할 때만 의미가 있음
 *  					      바이트 코드에는 정보가 없음
 *  			- CLASS : 바이트 코드 파일까지 어노테이션 정보가 유지됨
 *  			- RUNTIMe : 바이트 코드 파일까지 어노테이션 정보가 유지되면서
 *  						리플렉션을 이용해서 어노테이션 정보를 얻을 수 있음
 *  	
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//어노테이션의 적용범위와 내용 정의
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintAnnotation {
	String value() default "-"; 
	// value(): 어노테이션적용시 기본으로 포함되는 Element
	// 어노테이션 적용시 이름을 생략할 수 있음

	int number() default 15;
	// 두개 이상의 Element를 기술할 때는 value=값 형태로 기술
	// 특정한 값을 기술하지 않을때는 default값이 적용됨
}



