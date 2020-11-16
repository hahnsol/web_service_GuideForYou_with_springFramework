package com.gf.guideforyou.service;

import java.util.ArrayList;

import com.gf.guideforyou.vo.Guide_Avg_ScoreVo;
import com.gf.guideforyou.vo.JinSunMiVo;
import com.gf.guideforyou.vo.Location_CategoryBasicVo;
import com.gf.guideforyou.vo.MemberBasicVo;
import com.gf.guideforyou.vo.MemberTourJoinVo;
import com.gf.guideforyou.vo.ReservationBasicVo;
import com.gf.guideforyou.vo.SessionUserDataVo;
import com.gf.guideforyou.vo.TourBasicVo;

public interface MainContentService {

		//투어 날짜가 지났는지 확인하기 위해서 만듬
		public void compareToCurrentDate();
	
	
		//kindOfLocalPage--지역이름가져오기
		public Location_CategoryBasicVo getLocalName(TourBasicVo vo);
		
		//kindOfLocalPage--이달의 투어왕추출
		public ArrayList<JinSunMiVo> getJinSunMi(TourBasicVo vo);
		
		//kindOfLocalPage--전체게시물,가이드정보,가이드평점 가져오기,이달의 투어왕정보가져오기 
		public ArrayList<Guide_Avg_ScoreVo> getLocalPageContentLists(TourBasicVo vo);
		
		
		public ArrayList<ReservationBasicVo> checkUserBooking(TourBasicVo vo);
		
		//tourGuideContentPage--해당게시물가져오기, tourContentUpdatePage--수정할게시물정보가져오기
		public MemberTourJoinVo getGuideContent(TourBasicVo vo);
		
		//tourEnrollPage-- 가이드(member 정보), tourReservationPage--투어예약자정보가져오기, jinSunMiPage--진선미정보가져오기
		public MemberBasicVo getMemberInfo(int vo);
			
		//tourInsert--투어등록하기
		public void insertTourEnroll(TourBasicVo vo);
		
		//tourContentUpdateAction--tour투어수정
		public void updateTourContent(TourBasicVo vo);
		
		//tourDeleteAction--투어삭제하기
		public void deleteTourContent(TourBasicVo vo);
		
		//reservationInsertAction--투어예약하기
		public void insertReservation(ReservationBasicVo vo);
		
		//reservationInsertAction--투어정보(idx)가져오기
		public TourBasicVo getTourInfo(int tour_idx);
		
		//jinSunMiPage--진선미tourList가져오기
		public ArrayList<TourBasicVo> getTourList(TourBasicVo vo);
		 
		
}
