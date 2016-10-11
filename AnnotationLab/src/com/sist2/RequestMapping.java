package com.sist2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * #어노테이션 적용 순서
 * 	1. @어노테이션 정의
 * 	2. @어노테이션 타겟에 적용
 * 	3. @어노테이션 사용(업무에 적용)
 * 	4. 완료
 * 
 * ==> MVC 모델에 적용
 * 		: 이전의 beans.xml로 정의한 Model의 리스트나, 
 * 		  DispatcherSevlet이 종류가 많아질 경우
 * 		  @어노테이션을 활용하면 효용성이 높아 질 수 있음	
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMapping {
	public String value();
	
}
