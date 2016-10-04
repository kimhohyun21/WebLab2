package com.sis.xml;
/*
 * # XML (DOM, SAX)
 * 
 * 	1. XML Parser의 정의
 * 		: XML과 DTD를 이어서 문서의 정확성을 검증하고, 
 * 		    문서 재사용과 문서 구조에 접근할 수 있게 해주는 라이브러리 형태의 프로그램
 *  
 *  2. XML Parser의 종류
 *  	1) DOM(Document Object Model)
 *  		- XML 문서를 트리구조 형태로 Access할 수 있게 해주는 API
 *  			==> 파싱기법 : TREE-WORKING 기반
 *  			==> 처리방법 : 메모리에 로딩, Tree자료 구조화
 *  			==> 접근방식 : Random Access 방식
 *  		- 장점
 *  			==> 문서구조 동적 변경, 복잡한 연산 처리, 문서 생성, 편집 가능
 *  		- 단점 
 *  			==> 메모리 요구량이 많음, 상대적으로 처리 속도가 느림
 * 
 *  	2) SAX(The Simple API for XML)
 *  		- 자료구조를 만들지 않고 XML 문서를 스캔해 가면서
 *  		     순차적으로 이벤트를 발생시켜 XML 문서에 접근할 수 있게 해주는 API
 *  			==> 파싱기법 : Event 기반
 *  			==> 처리기법 : Scan, 순차적 이벤트 발생 처리
 *  			==> 접근방식 : Streaming 방식
 *  
 *  		- 장점
 *  			==> 메모리 효율이 좋음, 단순/속도 빠름, XML 문서크기에 무관
 *  		- 단점
 *  			==> 다량의 문서처리, 일부분만 접근시 유효성 처리가 어렵다, 데이터 변환이 미흡함
 *  
 */
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import org.w3c.dom.*;

public class SawonXML {
	//저장위치 (메모리) ==> Document(Datebase)를 메모리상으로 읽어 들일 예정 ==> 오라클의 ORCL
	private Document doc;
	private static SawonXML xml; //==> 자기 자신을 static으로 가짐
	
	//최상위 태그를 멤버필드로 추가 ==> 오라클의 table
	private Element root;
	String path="C:\\webProjects\\webLab2\\XMLLab2\\WebContent\\WEB-INF\\sawon.xml";
	
	public SawonXML(){
		try{
			//파서기 얻기 ==> dom을 파싱하기 위해서
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			doc=db.parse(new File(path)); //==> db까지 접근
			root=doc.getDocumentElement(); //==> table까지 접근
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//싱글톤패턴으로 sawonxml 객체 생성
	public static SawonXML newInstance(){
		if(xml==null){
			xml=new SawonXML();
		}
		return xml;
	}
	
	//기능
	public List<SawonVO> sawonAllData(){
		List<SawonVO> list=new ArrayList<>();
		
		try{
			NodeList node=root.getElementsByTagName("list"); //xml안의 하위노드
			for(int i=0; i<node.getLength();i++){
				
				//첫번째 정도전 데이터 불러오기
				node=root.getElementsByTagName("sabun");
				String sabun=node.item(i).getFirstChild().getNodeValue();
										 //===============
										 //  첫 번째 자식 노드
				node=root.getElementsByTagName("name");
				String name=node.item(i).getFirstChild().getNodeValue();
				
				node=root.getElementsByTagName("dept");
				String dept=node.item(i).getFirstChild().getNodeValue();
				
				node=root.getElementsByTagName("loc");
				String loc=node.item(i).getFirstChild().getNodeValue();
				
				node=root.getElementsByTagName("hiredate");
				String hiredate=node.item(i).getFirstChild().getNodeValue();
				
				SawonVO vo=new SawonVO();
				vo.setSabun(Integer.parseInt(sabun));
				vo.setName(name);
				vo.setDept(dept);
				vo.setLoc(loc);
				vo.setHiredate(hiredate);
				
				list.add(vo);
			}
			
			
		}catch(Exception e){
			
		}
		
		return list;
	}
	
	//삭제
	public void sawonDelete(int sabun){
		
		try{
			NodeList node=root.getElementsByTagName("list");
			for(int i=0;i<node.getLength();i++){
				node=root.getElementsByTagName("sabun");
				String sa=node.item(i).getFirstChild().getNodeValue();
				int xmlsa=Integer.parseInt(sa); 
				
				//==> list 삭제를 위해 노드를 다시 초기화
				node=root.getElementsByTagName("list");
				
				if(sabun==xmlsa){
					Element elem=(Element) node.item(i); // 해당 list 엘리먼트
					root.removeChild(elem); //root에서 해당 list 엘리먼트를 지워라
					
					//삭제후 변경 사항을 저장
					xmlSave();
					break;
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/*
	 * #변경 사항 저장 메소드
	 * 	- DOM 객체를 수정, 삭제, 추가하는 것은 모두 메모리상에서 이루어짐
	 * 		==> 메모리상에서 변경된 내용을 영구 보존을 위해
	 *     		다시 파일형태의 XML 문서로 저장해야 함
	 * 		==> 고급 기술 XSLT 변환기를 사용해서 파일로 저장해야함.
	 *
	 * #XSL(eXtensible Stylesheet Language)
	 * 	- XML문서의 스타일을 저장하는 언어 (HTML의 스타일언어 : css)
	 * 		==> 데이터를 저장하기 위한 구조를 정의하는 문서
	 * 	- XSLT는 XSL의 한 부분
	 * 		==> XML 문서를 조작하여 다른 형태의 문서(HTML, PDF, XML, WML.....)를  변환하는 역할
	 * 
	 * # XSLT 변환기
	 * 	- javax.xml.transform.Transformer 추상클래스를 상속한 객체
	 * 
	 */
	public void xmlSave(){
		try{
			TransformerFactory tff=TransformerFactory.newInstance();
			Transformer tf=tff.newTransformer();
			
			//출력 포멧 설정 ==> xml 저장 양식
			tf.setOutputProperty(OutputKeys.INDENT, "yes"); //==> xml 문서를 출력하는데 공백을 포함 할 것임
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //==> 문자 인코딩
			
			//DOMSource객체 생성 ==> DOM 소스 클래스를 사용하기 위해
			DOMSource dom=new DOMSource(doc); //doc는 root노드로 그 하위에 포함된 모든 노드를 넘겨주게 됨
			
			//StreamResult객체 생성 ==> 만들어지는 result객체 생성 
			StreamResult sr=new StreamResult(path); // sawon.xml과 같은 위치, 삭제 후의 결과가 동일한 파일로 저장됨
			
			//파일 저장
			tf.transform(dom, sr);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
