package com.sist.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

public class EmpDAO {
	private static SqlSessionFactory ssf;
	
	//mybytis를 이용한 db연결 설정
	static{
		try{
			Reader reader=Resources.getResourceAsReader("config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//사원 목록 호출하는 기능을 mybytis로 구현
	public static List<EmpDTO> empAllData(){
		return ssf.openSession().selectList("empAllData");
	}
}
