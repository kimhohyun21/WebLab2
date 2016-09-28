package com.dao;

import java.sql.*;
import java.util.*;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private final String url="jdbc:oracle:thin:@211.238.142.88:1521:ORCL";
	private final String user="scott";
	private final String password="tiger";
	
	//1. 드라이버 등록
	public BoardDAO(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//2. 연결 객체 생성
	public void getConnection(){
		try{
			conn=DriverManager.getConnection(url,user,password);	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//3. 연결 해제 객체 생성
	public void disConnection(){
		try{
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//4. 기능 추가 : 1) 목록 ==> SELECT
	public List<BoardDTO> boardListData(int page){
		List<BoardDTO> list=new ArrayList<>();
		
		try{
			getConnection();
			
			String sql="SELECT no, name, subject, regdate, hit, "
						+ "group_tab, TO_CHAR(regdate, 'YYYY-mm-DD') "
						+ "FROM board ORDER BY group_id DESC, group_step ASC";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			int rowSize=5;
			int i=0;
			int j=0;
			int pagecnt=(page*rowSize)-rowSize;
			
			while(rs.next()){
				if(i<rowSize && j>=pagecnt){
					BoardDTO dto=new BoardDTO();
					
					dto.setNo(rs.getInt(1));
					dto.setName(rs.getString(2));
					dto.setSubject(rs.getString(3));
					dto.setRegdate(rs.getDate(4));
					dto.setHit(rs.getInt(5));
					dto.setGroup_tab(rs.getInt(6));
					dto.setDbday(rs.getString(7));
					
					list.add(dto);
					
					i++;
				}
				j++;
			}
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disConnection();
		}
		
		return list;
	}
	
	/*
	 * 3)추가 ==> insert
	 * 4)수정 ==> update
	 * 5)답변 ==> insert
	 * 
	 */
	
	//4. 기능 추가 : 2) 총페이지 구하기 ==> CEIL(COUNT(*)/5)
	public int boardTotal(){
		int total=0;
		
		try{
			getConnection();
			
			String sql="SELECT CEIL(COUNT(*)/5) FROM board";
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
	
	//4. 기능 추가 : 3) 총 게시물 수 구하기 ==> count(*)
	public int boardCount(){
		int total=0;
		
		try{
			getConnection();
			
			String sql="SELECT COUNT(*) FROM board";
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
	
	//5. 기능 추가 : 4) 내용보기 ==> SELECT ~ WHERE
	public BoardDTO boardContentData(int no){
		BoardDTO dto=new BoardDTO();
		
		try{
			getConnection();
			
			//히트수 증가
			String sql="UPDATE board SET hit=hit+1 WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
			ps.close();
			
			//데이터 읽기
			sql="SELECT no, name, subject, content, regdate, hit FROM board WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs=ps.executeQuery();
			rs.next();
			
			dto.setNo(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setSubject(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setRegdate(rs.getDate(5));
			dto.setHit(rs.getInt(6));
			
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disConnection();
		}
		
		return dto;
	}
	
	//5. 기능 추가 : 5) 내용 추가 ==> insert
	public void boardInsert(BoardDTO dto){
		try{
			getConnection();
			
			String sql="INSERT INTO board(no, name, subject, content, pwd, group_id) "
						+ "VALUES((SELECT NVL((MAX(no)+1),1) FROM board), ?, ?, ?, ?, "
						+ "(SELECT NVL((MAX(group_id)+1),1) FROM board))";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getSubject());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getPwd());
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disConnection();
		}
	}
}	

