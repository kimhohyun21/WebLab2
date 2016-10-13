package com.sist.mgr;

//캡슐화 (VO,DTO)
/*
 * private : 자신의 클래스내에서만 사용이 가능.
 */

public class MovieVO {
   private String title;
   private String poster;
   private String grade;
   private int rank;
   private String regdate;
   private double reserve;
   private int like;
   
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getPoster() {
      return poster;
   }
   public void setPoster(String poster) {
      this.poster = poster;
   }
   public String getGrade() {
      return grade;
   }
   public void setGrade(String grade) {
      this.grade = grade;
   }
   public int getRank() {
      return rank;
   }
   public void setRank(int rank) {
      this.rank = rank;
   }
   public String getRegdate() {
      return regdate;
   }
   public void setRegdate(String regdate) {
      this.regdate = regdate;
   }
   public double getReserve() {
      return reserve;
   }
   public void setReserve(double reserve) {
      this.reserve = reserve;
   }
   public int getLike() {
      return like;
   }
   public void setLike(int like) {
      this.like = like;
   }
   
   
}