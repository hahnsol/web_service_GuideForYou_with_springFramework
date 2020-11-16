package com.gf.guideforyou.mapper;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gf.guideforyou.vo.MemberBasicVo;
import com.gf.guideforyou.vo.ReservationBasicVo;
import com.gf.guideforyou.vo.TourBasicVo;



public interface Tour_EnrollSQLMapper {

	
	@Select("SELECT * FROM GF_TOUR_ENROLLMENT WHERE LOCATION_IDX=#{location_idx} ORDER BY TOUR_IDX DESC")
	public ArrayList<TourBasicVo> selectAllByLocationIdx(TourBasicVo vo);
	
	@Select("SELECT * FROM GF_TOUR_ENROLLMENT WHERE MEMBER_IDX=#{member_idx} ORDER BY TOUR_IDX DESC")
	public ArrayList<TourBasicVo> selectTourByMemberIdx(TourBasicVo vo);
	
	
	//THIS SQL GET COMPLETE TOUR
	@Select("SELECT * FROM GF_TOUR_ENROLLMENT WHERE MEMBER_IDX=#{member_idx} AND TOUR_COMPLETE='y'")
	public ArrayList<TourBasicVo> selectConfirmTourByMemberIdx(TourBasicVo vo);
	
	@Select("SELECT * FROM GF_TOUR_ENROLLMENT WHERE TOUR_IDX=#{tour_idx}")
	public TourBasicVo selectTourByTourIdx(TourBasicVo vo);
	
	
	@Insert("INSERT INTO GF_TOUR_ENROLLMENT VALUES(GF_TOUR_ENROLLMENT_SEQ.NEXTVAL,#{member_idx},#{location_idx},#{tour_tourspot},#{tour_max_number},"
			+ "#{tour_vehicle},TO_DATE(#{tour_tourdate},'yyyy-MM-dd'),#{tour_intro},#{tour_content},'n',SYSDATE,"
			+ "#{tour_photo1 , jdbcType=VARCHAR},#{tour_photo2 , jdbcType=VARCHAR},#{tour_photo3, jdbcType=VARCHAR},#{tour_photo4, jdbcType=VARCHAR},#{tour_photo5, jdbcType=VARCHAR})")
	public void insertTour(TourBasicVo vo); 
	
	
	//유기조 추가한 sql문  신용정보 페이지에 활용합니다 
	@Select("SELECT * FROM GF_TOUR_ENROLLMENT WHERE MEMBER_IDX=#{member_idx}")
	public ArrayList<TourBasicVo> credit_infoTourListByMemberIdx(MemberBasicVo vo);
	
	//Na 추가
		@Select("SELECT * FROM GF_TOUR_ENROLLMENT WHERE TOUR_IDX=#{tour_idx}")
		public TourBasicVo selectReservationTourByTourIdx(ReservationBasicVo vo);
		
		//tourContent 삭제 ++한솔 추가
		@Delete("DELETE FROM GF_TOUR_ENROLLMENT WHERE TOUR_IDX=#{tour_idx}")
		public void deleteTourContent(TourBasicVo vo);
		
		//tourContent 수정 ++한솔 추가
		@Update("UPDATE GF_TOUR_ENROLLMENT SET LOCATION_IDX=#{location_idx}, TOUR_TOURSPOT=#{tour_tourspot}, TOUR_MAX_NUMBER=#{tour_max_number}, TOUR_VEHICLE=#{tour_vehicle}, TOUR_TOURDATE=TO_DATE(#{tour_tourdate},'yyyy-MM-dd'), TOUR_INTRO=#{tour_intro}, TOUR_CONTENT=#{tour_content}, TOUR_PHOTO1=#{tour_photo1 , jdbcType=VARCHAR},TOUR_PHOTO2=#{tour_photo2 , jdbcType=VARCHAR},TOUR_PHOTO3=#{tour_photo3 , jdbcType=VARCHAR},TOUR_PHOTO4=#{tour_photo4 , jdbcType=VARCHAR},TOUR_PHOTO5=#{tour_photo5 , jdbcType=VARCHAR} WHERE TOUR_IDX=#{tour_idx}")
		public void updateTourContent(TourBasicVo vo);
		
		//jinsunmi 추출 ++한솔 추가
		@Select("SELECT * FROM (SELECT TOUR_IDX FROM GF_GUIDE_EVALUATION WHERE TOUR_IDX IN (SELECT TOUR_IDX FROM GF_TOUR_ENROLLMENT WHERE MEMBER_IDX IN (SELECT MEMBER_IDX FROM GF_TOUR_ENROLLMENT WHERE LOCATION_IDX=#{para.location_idx} GROUP BY MEMBER_IDX) AND TOUR_TOURDATE <= TO_DATE(#{endDate},'yyyy-MM-dd')  AND TOUR_TOURDATE >= TO_DATE(#{startDate},'yyyy-MM-dd')) GROUP BY TOUR_IDX ORDER BY ROUND(AVG(GUIDE_SCORE),1) DESC) WHERE ROWNUM <= 3")
		public ArrayList<TourBasicVo> selectJinSunMi(@Param("para") TourBasicVo vo, @Param("startDate") String year, @Param("endDate") String month);
		
		
		//++한솔추가 customer섹터-->리뷰작성할 투어목록
		@Select("SELECT * FROM GF_TOUR_ENROLLMENT WHERE TOUR_IDX=#{tour_idx} AND TOUR_COMPLETE='y'")
		public TourBasicVo selectCompleteTourByTourIdx(ReservationBasicVo vo);
				
		@Select("SELECT * FROM GF_TOUR_ENROLLMENT WHERE TOUR_IDX=#{tour_idx} AND TOUR_COMPLETE='n'")
		public TourBasicVo selectReservationTourNotCompleteByTourIdx(ReservationBasicVo vo);
		
		@Update("UPDATE GF_TOUR_ENROLLMENT SET TOUR_COMPLETE = 'y' WHERE TOUR_COMPLETE='n' AND TOUR_TOURDATE < SYSDATE")
		public void updateTour_complete();
		
}
