package com.sist.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

public class EmpDAO {
	private static SqlSessionFactory ssf;
	
	//mybytis�� �̿��� db���� ����
	static{
		try{
			Reader reader=Resources.getResourceAsReader("config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//��� ��� ȣ���ϴ� ����� mybytis�� ����
	public static List<EmpDTO> empAllData(){
		return ssf.openSession().selectList("empAllData");
	}
}
