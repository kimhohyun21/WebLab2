package com.sist.dao;

import java.io.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CreateSqlSessionFactory {
	private static SqlSessionFactory ssf; // SqlSession 생성 ==> Connection
	
	static {
		try{
			Reader reader=Resources.getResourceAsReader("config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
			///SqlSessionFactoryBuilder ==> MyBatis 설정 파일을 바탕으로 SqlSession을 생성
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSsf() {
		return ssf;
	}	
	
}
