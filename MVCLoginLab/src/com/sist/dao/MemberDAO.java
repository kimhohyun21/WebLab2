package com.sist.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDAO {
	private static SqlSessionFactory ssf; // SqlSession 생성 ==> Connection
	
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	//기능추가 : 로그인
	public int memeberIdCheck(String id){
		//PS, RS
		SqlSession session=ssf.openSession();
		int count=session.selectOne("memberIdCheck", id);
		session.close(); // 리소스 반환
		
		return count;
	}
	
	public MemberVO memberGetPwd(String id){
		SqlSession session=ssf.openSession();
		MemberVO vo=session.selectOne("memberGetPwd", id);
		session.close();
		
		return vo;
	}
}
