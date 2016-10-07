package com.sist.dao;

import java.util.*;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * # OOP와 RDBC
 * 	: 웹어플리케이션 개발의 큰 패러다임 2가지
 * 		==> 웹개발에서 JDBC코드를 작성하는 일이 가장 많은 시간 소비 (작성 때 마다 반복)
 * 			- 데이터베이스 자원 설정
 * 			- SQL 실행
 * 			- 조회 결과 설정
 * 			- 데이터베이스 자원 반납
 *   
 * 
 * 
 * # Mybatis
 * 	1) 정의
 * 		- 관계형 데이터베이스 프로그래밍을 위한 퍼시스턴스 프레임워크
 * 	  	- SQL을 자바코드가 아닌 XML로 따로 분리하여 관리하도록 지원
 * 		- SQL 실행 결과를 Map 객체에 매핑해줌
 * 	
 * 	2) 특징 
 * 		- 파라미터를 전달하고 결과 셋에서 데이터 추출을 간단히 처리기능
 * 		- SQL을 XML이나 어노테이션으로 관리 가능
 * 		- 트랜잭션 처리 지원
 * 		- JDBC 단순화
 * 
 * 
 */


public class BoardDAO {
	//모든 MyBatis 애플리케이션은 SqlSessionFactory 인스턴스를 사용
	private static SqlSessionFactory ssf;
	
	static{
		try{
			//SqlSessionBuilder를 사용하여 SqlSession 객체 생성
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<BoardVO> boardListData(Map map){
		//Sqlsseion을 생성하면 DB연결이 됨
		SqlSession session=ssf.openSession();
		
		//list생성이 mapper.xml단에서 한번 끝냄
		List<BoardVO> list=session.selectList("boardListData", map);
		session.close();
		
		return list;
	}
	
	public static int boardTotalPage(){
		SqlSession session=ssf.openSession();
		int total=session.selectOne("boardTotalPage");
		session.close();
		
		return total;
	}
	
	public static BoardVO contentData(int no){
		SqlSession session=ssf.openSession();
		
		//조회수 증가
		session.update("boardHitIncrement", no);
		session.commit(); //commit은 이쪽에서 완료
		
		//vo불러오기
		BoardVO vo=session.selectOne("boardContentData", no) ;
		session.close(); // 사용 후 세션 종료
		
		return vo;		
	}
	
	public static void boardinsert(BoardVO vo){
		SqlSession session=ssf.openSession();
		
		//vo입력하기
		session.insert("boardInsert", vo);
		session.commit();
		session.close();
	}
}
