package com.sist.dao;

import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//미리 설정된 Conncetion의 주소 값 얻기
	public void getConnection(){
		try{
			//저장된 정보를 JNDI로 찾아 올 필요가 있음
			Context init=new InitialContext();
			//pool이 설정된 context를 찾아가기 위한 연결 설정 
			Context c=(Context) init.lookup("java://comp/env"); 
			//pool이 설정된 context를 찾는 설정, type을 리턴 받아 체크
			DataSource ds=(DataSource) c.lookup("jdbc/oracle"); 
			conn=ds.getConnection();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void disConnection(){
		try{
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//기능 추가 1 : 목록 출력
	public List<BoardVO> boardListData(int page){
		List<BoardVO> list=new ArrayList<>();
		
		try{
			getConnection();
			
			//페이지 목록 수 설정
			int rowSize=10 ;
			int start=(rowSize*page)-(rowSize-1); // 1, 11, 21, 31...
			int end=rowSize*page; //10, 20, 30...
			
			String sql="SELECT no, subject, name, regdate, hit, group_tab, TO_CHAR(regdate, 'YYYY-MM-DD'), num "
						+ "FROM (SELECT no, subject, name, regdate, hit, group_tab, rownum as num "
						+ "FROM (SELECT no, subject, name, regdate, hit, group_tab "
						+ "FROM replyBoard ORDER BY group_id DESC, group_step ASC)) "
						+ "WHERE num BETWEEN "+start+" AND "+end;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				vo.setGroup_tab(rs.getInt(6));
				vo.setDbday(rs.getString(7));
				
				list.add(vo);
			}
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disConnection();
		}
		
		return list;
	}
	
	//기능 추가 2 : 전체 페이지 수 카운트
	public int boardTotalpage(){
		int total=0;
		
		try{
			getConnection();
			
			String sql="SELECT CEIL(COUNT(*)/10) FROM replyBoard";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			
			total=rs.getInt(1);
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disConnection();
		}
		
		return total;
	}
	
	//기능 추가 3: 데이터 행수 체크
	public int rowCount(){
		int rowCount=0;
		
		try{
			getConnection();
			
			String sql="SELECT COUNT(*) FROM replyBoard";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			
			rowCount=rs.getInt(1);
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disConnection();
		}
		
		return rowCount;
	}
}
