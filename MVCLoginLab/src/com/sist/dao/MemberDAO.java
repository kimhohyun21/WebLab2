package com.sist.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDAO {
	private static SqlSessionFactory ssf; // SqlSession ���� ==> Connection
	
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	//����߰� : �α���
	public int memeberIdCheck(String id){
		//PS, RS
		SqlSession session=ssf.openSession();
		int count=session.selectOne("memberIdCheck", id);
		session.close(); // ���ҽ� ��ȯ
		
		return count;
	}
	
	public MemberVO memberGetPwd(String id){
		SqlSession session=ssf.openSession();
		MemberVO vo=session.selectOne("memberGetPwd", id);
		session.close();
		
		return vo;
	}
}
