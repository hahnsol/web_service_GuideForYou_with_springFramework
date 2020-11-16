package com.gf.guideforyou.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gf.guideforyou.vo.Guide_EvaluationBasicVo;
import com.gf.guideforyou.vo.TourBasicVo;


public interface Guide_EvaluationSQLMapper {

	
	//가이드 총 평점을 구하는 쿼리문 // 변경 2차 머지
	@Select("SELECT ROUND(AVG(GUIDE_SCORE),1) FROM GF_GUIDE_EVALUATION WHERE TOUR_IDX IN(SELECT TOUR_IDX FROM GF_TOUR_ENROLLMENT WHERE MEMBER_IDX=#{member_idx})")
	public String selectAvg_Score(int member_idx); 
	
	//가이드 리뷰와 평점을 가져오는 쿼리문
	@Select("SELECT * FROM GF_GUIDE_EVALUATION WHERE TOUR_IDX IN(SELECT TOUR_IDX FROM GF_TOUR_ENROLLMENT WHERE MEMBER_IDX=#{member_idx})")
	public ArrayList<Guide_EvaluationBasicVo> selectAllGuide_EvaluationByMemberIdx(int member_idx);

	//유기조  가이드 평점 구하는 공식  투어 idx를 이용해서
	@Select("SELECT ROUND(AVG(GUIDE_SCORE),1) FROM GF_GUIDE_EVALUATION WHERE TOUR_IDX=#{tour_idx}")
	public double getAvgScoreByTour_idx(int tour_idx); 
		
	
	
	//나효수
	//가이드리뷰 작성 페이지에서  리뷰를 insert 하는 쿼리문
	//가이드에게 리뷰주기 페이지에서 넘겨준 tour_idx와 내 member_idx를 받아서 만든다 
	@Insert("INSERT INTO GF_GUIDE_EVALUATION VALUES(GF_GUIDE_EVALUATION_SEQ.NEXTVAL,#{tour_idx},#{member_idx},#{guide_score},#{guide_review})")
	public void insertGuideEvauation(Guide_EvaluationBasicVo vo);
	
	
	///유기조 추가
	
	@Select("SELECT * FROM GF_GUIDE_EVALUATION WHERE TOUR_IDX=#{tour_idx}")
	public ArrayList<Guide_EvaluationBasicVo> selectGuideInfo(TourBasicVo vo);
	
	@Select("SELECT ROUND(AVG(GUIDE_SCORE),1) FROM GF_GUIDE_EVALUATION WHERE TOUR_IDX IN(SELECT TOUR_IDX FROM GF_TOUR_ENROLLMENT WHERE MEMBER_IDX=#{member_idx})")
	public String kijoselectAvg_Score(int member_idx); 
	
	@Select("SELECT * FROM GF_GUIDE_EVALUATION WHERE MEMBER_IDX=#{member_idx}")
	public ArrayList<Guide_EvaluationBasicVo> getGuideInfoByMember_idx(int member_idx);
	
	//++한솔추가
		@Select("SELECT * FROM GF_GUIDE_EVALUATION WHERE TOUR_IDX=#{tourBasicVo.tour_idx} AND MEMBER_IDX=#{member_Idx}")
		public Guide_EvaluationBasicVo selectReviesWirtten(@Param("tourBasicVo") TourBasicVo vo, @Param("member_Idx") int member_idx);
}
