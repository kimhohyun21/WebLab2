package com.sist.dao;

import java.util.*;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * # OOP�� RDBC
 * 	: �����ø����̼� ������ ū �з����� 2����
 * 		==> �����߿��� JDBC�ڵ带 �ۼ��ϴ� ���� ���� ���� �ð� �Һ� (�ۼ� �� ���� �ݺ�)
 * 			- �����ͺ��̽� �ڿ� ����
 * 			- SQL ����
 * 			- ��ȸ ��� ����
 * 			- �����ͺ��̽� �ڿ� �ݳ�
 *   
 * 
 * 
 * # Mybatis
 * 	1) ����
 * 		- ������ �����ͺ��̽� ���α׷����� ���� �۽ý��Ͻ� �����ӿ�ũ
 * 	  	- SQL�� �ڹ��ڵ尡 �ƴ� XML�� ���� �и��Ͽ� �����ϵ��� ����
 * 		- SQL ���� ����� Map ��ü�� ��������
 * 	
 * 	2) Ư¡ 
 * 		- �Ķ���͸� �����ϰ� ��� �¿��� ������ ������ ������ ó�����
 * 		- SQL�� XML�̳� ������̼����� ���� ����
 * 		- Ʈ����� ó�� ����
 * 		- JDBC �ܼ�ȭ
 * 
 * 
 */


public class BoardDAO {
	//��� MyBatis ���ø����̼��� SqlSessionFactory �ν��Ͻ��� ���
	private static SqlSessionFactory ssf;
	
	static{
		try{
			//SqlSessionBuilder�� ����Ͽ� SqlSession ��ü ����
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<BoardVO> boardListData(Map map){
		//Sqlsseion�� �����ϸ� DB������ ��
		SqlSession session=ssf.openSession();
		
		//list������ mapper.xml�ܿ��� �ѹ� ����
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
		
		//��ȸ�� ����
		session.update("boardHitIncrement", no);
		session.commit(); //commit�� ���ʿ��� �Ϸ�
		
		//vo�ҷ�����
		BoardVO vo=session.selectOne("boardContentData", no) ;
		session.close(); // ��� �� ���� ����
		
		return vo;		
	}
	
	public static void boardinsert(BoardVO vo){
		SqlSession session=ssf.openSession();
		
		//vo�Է��ϱ�
		session.insert("boardInsert", vo);
		session.commit();
		session.close();
	}
}
