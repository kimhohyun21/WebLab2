package com.sist.dao;

import java.sql.*;
import java.util.*;

public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private final String url="jdbc:oracle:thin:@211.238.142.88:1521:ORCL";
	private final String user="scott";
	private final String pwd="tiger";
	
	//����̹� ���
	public EmpDAO(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//����Ŭ ����
	public void getConnection(){
		try{
			conn=DriverManager.getConnection(url,user,pwd);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//����Ŭ �ݱ�
	public void disConnection(){
		try{
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//��� emp�� List�� �ҷ����� ���
	public List<EmpVO> empAllData(){
		List<EmpVO> list=new ArrayList<>();
			
		try{
			getConnection();
			
			String sql="SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				EmpVO vo=new EmpVO();
				
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setMgr(rs.getInt(4));
				vo.setHiredate(rs.getDate(5));
				vo.setSal(rs.getInt(6));
				vo.setComm(rs.getInt(7));
				vo.setDeptno(rs.getInt(8));
				
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
	
	/*
	   	�׷��� �� ������ ����
	   "valueField": "sal",
	   "titleField": "ename",
	 */
	public String empChart(){
		String json=null;
		
		try{
			getConnection();
			
			String sql="SELECT ename, sal FROM emp";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			json="[";
			while(rs.next()){
				json+="{'ename': '"+rs.getString(1)+"', 'sal': '"+rs.getInt(2)+"'}, ";
			}
			json=json.substring(0, json.lastIndexOf(","));
			json+="]";
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disConnection();
		}
		return json;
	}
	
	public String empChart1(){
		String json=null;
		
		try{
			getConnection();
			
			String sql="SELECT job, SUM(sal) FROM emp GROUP BY job";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			json="[";
			while(rs.next()){
				json+="{'ename': '"+rs.getString(1)+"', 'sal': '"+rs.getInt(2)+"'}, ";
			}
			json=json.substring(0, json.lastIndexOf(","));
			json+="]";
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disConnection();
		}
		return json;
	}
	
	public String empChart2(){
		String json=null;
		
		try{
			getConnection();
			
			String sql="SELECT deptno, SUM(sal) FROM emp GROUP BY deptno";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			json="[";
			while(rs.next()){
				json+="{'ename': '"+rs.getString(1)+"�� �μ�', 'sal': '"+rs.getInt(2)+"'}, ";
			}
			json=json.substring(0, json.lastIndexOf(","));
			json+="]";
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disConnection();
		}
		return json;
	}
	
	public String empChart3(){
		String json=null;
		
		try{
			getConnection();
			
			String sql="SELECT SUBSTR(hiredate, 1, 2), SUM(sal) FROM emp GROUP BY SUBSTR(hiredate, 1, 2)";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			json="[";
			while(rs.next()){
				json+="{'ename': '"+rs.getString(1)+"', 'sal': '"+rs.getInt(2)+"'}, ";
			}
			json=json.substring(0, json.lastIndexOf(","));
			json+="]";
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disConnection();
		}
		return json;
	}
}
