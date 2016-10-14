package com.sist.dao;

import java.io.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CreateSqlSessionFactory {
	private static SqlSessionFactory ssf; // SqlSession ���� ==> Connection
	
	static {
		try{
			Reader reader=Resources.getResourceAsReader("config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
			///SqlSessionFactoryBuilder ==> MyBatis ���� ������ �������� SqlSession�� ����
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSsf() {
		return ssf;
	}	
	
}
