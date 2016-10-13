package com.sist.mgr;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.bcel.internal.generic.AALOAD;

/*
 *  <div class="sect-movie-chart">
            <h4 class="hidden">
                ������Ʈ - ��������
            </h4>
            <ol>
            
                <li>
                    <div class="box-image" >
                        <strong class="rank">No.1</strong>   
                        <a href="/movies/detail-view/?midx=79011">
                            <span class="thumb-image">
                                <img src="http://img.cgv.co.kr/Movie/Thumbnail/Poster/000079/79011/79011_185.jpg" alt="�̽� �䷹�׸��� �̻��� ���̵��� �� ������" onerror="errorImage(this)"/>
                                <span class="ico-grade grade-12">12�� �̻�</span>
                            </span>
                            
                        </a>
                        <span class="screentype">
                            
                                <a class="forDX" href="#" title="4DX ������ �ٷΰ���" data-regioncode="4D14">4DX</a>
                            
                                <a class="threeD" href="#" title="3D ������ �ٷΰ���" data-regioncode="3D">3D</a>
                            
                        </span>
                    </div>
                    
                    <div class="box-contents">
                        <a href="/movies/detail-view/?midx=79011">
                            <strong class="title">�̽� �䷹�׸��� �̻��� ���̵��� ��</strong>
                        </a>

                        <div class="score">
                            <strong class="percent">������<span>18.5%</span></strong>
                            <!--[2015-12-10] ��������Ʈ ���� ����1~ 3��. start : add_mwpark-->
                            <div class="egg-gage small">
                                <span class="egg great"></span>
                        <span class="percent">91%</span>
                     </div>
                            <!--[2015-12-10] ��������Ʈ ���� ���� 1~ 3��. end : add_mwpark-->
                            <!-- [2015-12-11] ���� ��Ʈ ���� ���� ���� UI ���� start : del_mwpark
                                <div class="point">
                                    <em>91.0</em>
                                </div>
                            [2015-12-11] ���� ��Ʈ ���� ���� ���� UI ���� start : del_mwpark-->
                        </div>

                        <span class="txt-info">
                            <strong>
                                2016.09.28 
                                <span>����</span>
                                
                            </strong>
                        </span>
                        <span class="like"> 
                            <button class="btn-like" value="79011">��ȭ ���ϱ�</button>
                            <span class="count"> 
                                <strong><i>19,022</i><span>���� ����</span></strong> 
                                <i class="corner-RT"></i><i class="corner-LT"></i><i class="corner-LB"></i><i class="corner-RB"></i><i class="corner-arrow"></i>
                            </span>
                            <a class="link-reservation" href="/ticket/?MOVIE_CD=20010891&MOVIE_CD_GROUP=20010891">����</a>
                        </span>
                    </div> 
 */
public class MovieCGVManager {
   String[] feel={"���","�θǽ�","�ŷ�","��ſ�","����",
         "�Ҹ�","����","����","����","����","����",
         "�ູ","����","����","���","����","�ź�",
         "����","���","���","����","����","�޸Ӵ���",
         "�ڱ�","���","�׼�","����","���","�̽��׸�",
         "��Ÿ��","��","������","���","ǳ��","�ϻ�",
         "����","����","����","�׸���","ȣ��","���","��Ȥ"
   };
   
   int[] feelCount=new int[feel.length];
   
   //��� �߰�
   public List<MovieVO> getMovieData(){
      List<MovieVO> mv=new ArrayList<>();
      
      try{
         Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/?ft=0").get();
         
         Elements titleElem=doc.select("div.box-contents strong.title");
         Elements imageElem=doc.select("div.box-image a span.thumb-image img");
         Elements gradeElem=doc.select("div.box-image a span.thumb-image span");
         Elements rankElem=doc.select("div.box-image strong.rank");
         
         Elements percentElem=doc.select("div.box-contents div.score strong.percent span");
         Elements likeElem=doc.select("div.box-contents span.like span.count strong i");
         Elements starElem=doc.select("div.box-contents span.percent");
         Elements dayElem=doc.select("div.box-contents span.txt-info strong");
         
         for(int i=0;i<7;i++){
        	 Element tElem=titleElem.get(i);
        	 Element iElem=imageElem.get(i);
        	 String img=iElem.attr("src");
        	 
        	 Element gElem=gradeElem.get(i);
        	 Element rElem=rankElem.get(i);
        	 
        	 Element pElem=percentElem.get(i);
        	 Element lElem=likeElem.get(i);
        	 Element sElem=starElem.get(i);
        	 Element dElem=dayElem.get(i);        	 
        	 
        	 MovieVO vo=new MovieVO();
        	 vo.setTitle(tElem.text());
        	 vo.setReserve(Double.parseDouble(pElem.text().substring(0, pElem.text().lastIndexOf("%"))));
        	 vo.setPoster(img);	
        	 vo.setLike(Integer.parseInt(lElem.text().replace(",", "")));
        	 vo.setRegdate(dElem.text().substring(0, dElem.text().lastIndexOf("����")));
        	 vo.setRank(Integer.parseInt(rElem.text().substring(3)));
        	 vo.setGrade(gElem.text());
        	 
        	 mv.add(vo);
         }
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      return mv;
   }
   
}

