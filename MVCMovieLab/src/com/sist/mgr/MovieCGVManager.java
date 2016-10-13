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
                무비차트 - 예매율순
            </h4>
            <ol>
            
                <li>
                    <div class="box-image" >
                        <strong class="rank">No.1</strong>   
                        <a href="/movies/detail-view/?midx=79011">
                            <span class="thumb-image">
                                <img src="http://img.cgv.co.kr/Movie/Thumbnail/Poster/000079/79011/79011_185.jpg" alt="미스 페레그린과 이상한 아이들의 집 포스터" onerror="errorImage(this)"/>
                                <span class="ico-grade grade-12">12세 이상</span>
                            </span>
                            
                        </a>
                        <span class="screentype">
                            
                                <a class="forDX" href="#" title="4DX 상세정보 바로가기" data-regioncode="4D14">4DX</a>
                            
                                <a class="threeD" href="#" title="3D 상세정보 바로가기" data-regioncode="3D">3D</a>
                            
                        </span>
                    </div>
                    
                    <div class="box-contents">
                        <a href="/movies/detail-view/?midx=79011">
                            <strong class="title">미스 페레그린과 이상한 아이들의 집</strong>
                        </a>

                        <div class="score">
                            <strong class="percent">예매율<span>18.5%</span></strong>
                            <!--[2015-12-10] 에그포인트 적용 범위1~ 3위. start : add_mwpark-->
                            <div class="egg-gage small">
                                <span class="egg great"></span>
                        <span class="percent">91%</span>
                     </div>
                            <!--[2015-12-10] 에그포인트 적용 범위 1~ 3위. end : add_mwpark-->
                            <!-- [2015-12-11] 무비 차트 평점 개편 별점 UI 삭제 start : del_mwpark
                                <div class="point">
                                    <em>91.0</em>
                                </div>
                            [2015-12-11] 무비 차트 평점 개편 별점 UI 삭제 start : del_mwpark-->
                        </div>

                        <span class="txt-info">
                            <strong>
                                2016.09.28 
                                <span>개봉</span>
                                
                            </strong>
                        </span>
                        <span class="like"> 
                            <button class="btn-like" value="79011">영화 찜하기</button>
                            <span class="count"> 
                                <strong><i>19,022</i><span>명이 선택</span></strong> 
                                <i class="corner-RT"></i><i class="corner-LT"></i><i class="corner-LB"></i><i class="corner-RB"></i><i class="corner-arrow"></i>
                            </span>
                            <a class="link-reservation" href="/ticket/?MOVIE_CD=20010891&MOVIE_CD_GROUP=20010891">예매</a>
                        </span>
                    </div> 
 */
public class MovieCGVManager {
   String[] feel={"사랑","로맨스","매력","즐거움","스릴",
         "소름","긴장","공포","유머","웃음","개그",
         "행복","전율","경이","우울","절망","신비",
         "여운","희망","긴박","감동","감성","휴머니즘",
         "자극","재미","액션","반전","비극","미스테리",
         "판타지","꿈","설레임","흥미","풍경","일상",
         "순수","힐링","눈물","그리움","호러","충격","잔혹"
   };
   
   int[] feelCount=new int[feel.length];
   
   //기능 추가
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
        	 vo.setRegdate(dElem.text().substring(0, dElem.text().lastIndexOf("개봉")));
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

