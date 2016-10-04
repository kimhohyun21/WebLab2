package com.sis.xml;
/*
 * # XML (DOM, SAX)
 * 
 * 	1. XML Parser�� ����
 * 		: XML�� DTD�� �̾ ������ ��Ȯ���� �����ϰ�, 
 * 		    ���� ����� ���� ������ ������ �� �ְ� ���ִ� ���̺귯�� ������ ���α׷�
 *  
 *  2. XML Parser�� ����
 *  	1) DOM(Document Object Model)
 *  		- XML ������ Ʈ������ ���·� Access�� �� �ְ� ���ִ� API
 *  			==> �Ḻ̌�� : TREE-WORKING ���
 *  			==> ó����� : �޸𸮿� �ε�, Tree�ڷ� ����ȭ
 *  			==> ���ٹ�� : Random Access ���
 *  		- ����
 *  			==> �������� ���� ����, ������ ���� ó��, ���� ����, ���� ����
 *  		- ���� 
 *  			==> �޸� �䱸���� ����, ��������� ó�� �ӵ��� ����
 * 
 *  	2) SAX(The Simple API for XML)
 *  		- �ڷᱸ���� ������ �ʰ� XML ������ ��ĵ�� ���鼭
 *  		     ���������� �̺�Ʈ�� �߻����� XML ������ ������ �� �ְ� ���ִ� API
 *  			==> �Ḻ̌�� : Event ���
 *  			==> ó����� : Scan, ������ �̺�Ʈ �߻� ó��
 *  			==> ���ٹ�� : Streaming ���
 *  
 *  		- ����
 *  			==> �޸� ȿ���� ����, �ܼ�/�ӵ� ����, XML ����ũ�⿡ ����
 *  		- ����
 *  			==> �ٷ��� ����ó��, �Ϻκи� ���ٽ� ��ȿ�� ó���� ��ƴ�, ������ ��ȯ�� ������
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
	//������ġ (�޸�) ==> Document(Datebase)�� �޸𸮻����� �о� ���� ���� ==> ����Ŭ�� ORCL
	private Document doc;
	private static SawonXML xml; //==> �ڱ� �ڽ��� static���� ����
	
	//�ֻ��� �±׸� ����ʵ�� �߰� ==> ����Ŭ�� table
	private Element root;
	String path="C:\\webProjects\\webLab2\\XMLLab2\\WebContent\\WEB-INF\\sawon.xml";
	
	public SawonXML(){
		try{
			//�ļ��� ��� ==> dom�� �Ľ��ϱ� ���ؼ�
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			doc=db.parse(new File(path)); //==> db���� ����
			root=doc.getDocumentElement(); //==> table���� ����
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//�̱����������� sawonxml ��ü ����
	public static SawonXML newInstance(){
		if(xml==null){
			xml=new SawonXML();
		}
		return xml;
	}
	
	//���
	public List<SawonVO> sawonAllData(){
		List<SawonVO> list=new ArrayList<>();
		
		try{
			NodeList node=root.getElementsByTagName("list"); //xml���� �������
			for(int i=0; i<node.getLength();i++){
				
				//ù��° ������ ������ �ҷ�����
				node=root.getElementsByTagName("sabun");
				String sabun=node.item(i).getFirstChild().getNodeValue();
										 //===============
										 //  ù ��° �ڽ� ���
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
	
	//����
	public void sawonDelete(int sabun){
		
		try{
			NodeList node=root.getElementsByTagName("list");
			for(int i=0;i<node.getLength();i++){
				node=root.getElementsByTagName("sabun");
				String sa=node.item(i).getFirstChild().getNodeValue();
				int xmlsa=Integer.parseInt(sa); 
				
				//==> list ������ ���� ��带 �ٽ� �ʱ�ȭ
				node=root.getElementsByTagName("list");
				
				if(sabun==xmlsa){
					Element elem=(Element) node.item(i); // �ش� list ������Ʈ
					root.removeChild(elem); //root���� �ش� list ������Ʈ�� ������
					
					//������ ���� ������ ����
					xmlSave();
					break;
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/*
	 * #���� ���� ���� �޼ҵ�
	 * 	- DOM ��ü�� ����, ����, �߰��ϴ� ���� ��� �޸𸮻󿡼� �̷����
	 * 		==> �޸𸮻󿡼� ����� ������ ���� ������ ����
	 *     		�ٽ� ���������� XML ������ �����ؾ� ��
	 * 		==> ��� ��� XSLT ��ȯ�⸦ ����ؼ� ���Ϸ� �����ؾ���.
	 *
	 * #XSL(eXtensible Stylesheet Language)
	 * 	- XML������ ��Ÿ���� �����ϴ� ��� (HTML�� ��Ÿ�Ͼ�� : css)
	 * 		==> �����͸� �����ϱ� ���� ������ �����ϴ� ����
	 * 	- XSLT�� XSL�� �� �κ�
	 * 		==> XML ������ �����Ͽ� �ٸ� ������ ����(HTML, PDF, XML, WML.....)��  ��ȯ�ϴ� ����
	 * 
	 * # XSLT ��ȯ��
	 * 	- javax.xml.transform.Transformer �߻�Ŭ������ ����� ��ü
	 * 
	 */
	public void xmlSave(){
		try{
			TransformerFactory tff=TransformerFactory.newInstance();
			Transformer tf=tff.newTransformer();
			
			//��� ���� ���� ==> xml ���� ���
			tf.setOutputProperty(OutputKeys.INDENT, "yes"); //==> xml ������ ����ϴµ� ������ ���� �� ����
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //==> ���� ���ڵ�
			
			//DOMSource��ü ���� ==> DOM �ҽ� Ŭ������ ����ϱ� ����
			DOMSource dom=new DOMSource(doc); //doc�� root���� �� ������ ���Ե� ��� ��带 �Ѱ��ְ� ��
			
			//StreamResult��ü ���� ==> ��������� result��ü ���� 
			StreamResult sr=new StreamResult(path); // sawon.xml�� ���� ��ġ, ���� ���� ����� ������ ���Ϸ� �����
			
			//���� ����
			tf.transform(dom, sr);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
