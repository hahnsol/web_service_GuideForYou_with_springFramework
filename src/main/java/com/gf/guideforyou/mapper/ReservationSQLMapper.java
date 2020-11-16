package com.gf.guideforyou.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gf.guideforyou.vo.Customer_EvaluationBasicVo;
import com.gf.guideforyou.vo.MemberBasicVo;
import com.gf.guideforyou.vo.ReservationBasicVo;



public interface ReservationSQLMapper {

	@Insert("INSERT INTO GF_RESERVATION_INFO VALUES(GF_RESERVATION_INFO_SEQ.NEXTVAL,#{tour_idx},#{member_idx},#{reservation_call},#{reservation_participate},#{reservation_wish},'b','n',SYSDATE)")
	public void insertReservation(ReservationBasicVo vo);
	
	//this sql updates reservation_confirm column y or n    
	@Update("UPDATE GF_RESERVATION_INFO SET RESERVATION_CONFIRM=#{reservation_confirm} WHERE RESERVATION_IDX=#{reservation_idx}")
	public void updateReservationConfirm(ReservationBasicVo vo);
	
	//this sql is update reservation form 
	@Update("UPDATE GF_RESERVATION_INFO SET RESERVATION_CALL=#{reservation_call},RESERVATION_PARTICIPATE=#{reservation_participate},RESERVATION_WISH=#{reservation_wish}  WHERE RESERVATION_IDX=#{reservation_idx}")
	public void updateReservationForm(ReservationBasicVo vo);
	
	
	//this sql is used in confirmReservationPage
	@Select("SELECT * FROM GF_RESERVATION_INFO WHERE RESERVATION_IDX=#{reservation_idx}")
	public ReservationBasicVo selectReservationInfoByReservationIdx(ReservationBasicVo vo);
	
	
	// 가이드 예약 신청 내역 페이지에서 총 참여 인원수 를 구하는 쿼리문
	@Select("SELECT SUM(RESERVATION_PARTICIPATE) FROM GF_RESERVATION_INFO WHERE TOUR_IDX=#{tour_idx}")
	public String selectSumParticiateByTourIdx(ReservationBasicVo vo);
	
	
	@Select("SELECT * FROM GF_RESERVATION_INFO WHERE TOUR_IDX=#{tour_idx}")
	public ArrayList<ReservationBasicVo> selectReservationInfoByTourIdx(ReservationBasicVo vo);
	
	//this sql check unconplete review member
	@Select("SELECT * FROM GF_CUSTOMER_EVALUATION WHERE TOUR_IDX=#{tour_idx} AND MEMBER IDX=#{member_idx}")
	public Customer_EvaluationBasicVo selectCompleteReview(Customer_EvaluationBasicVo vo);
	
	//Na 추가
		//예약 삭제
		@Delete("DELETE FROM GF_RESERVATION_INFO WHERE RESERVATION_IDX=#{reservation_idx}")
		public void deleteByIdx(ReservationBasicVo vo);
			
		//신청투어예약확인 페이지 리스트
		@Select("SELECT * FROM GF_RESERVATION_INFO WHERE MEMBER_IDX=#{member_idx}")
		public ArrayList<ReservationBasicVo> selectCustomerReservationAll(MemberBasicVo vo);
		
		//유기조  추가
		
		@Update("UPDATE GF_RESERVATION_INFO SET RESERVATION_CONFIRM='y' WHERE RESERVATION_IDX=#{reservation_idx}")
		public void updateReservationY(int reservation_idx);
		
		@Update("UPDATE GF_RESERVATION_INFO SET RESERVATION_CONFIRM='n' WHERE RESERVATION_IDX=#{reservation_idx}")
		public void updateReservationN(int reservation_idx);
		
		// 가이드 예약 신청 내역 페이지에서 투어 참여 확정 인원수 를 구하는 쿼리문
		@Select("SELECT SUM(RESERVATION_PARTICIPATE) FROM GF_RESERVATION_INFO WHERE TOUR_IDX=#{tour_idx} AND RESERVATION_CONFIRM='y'")
		public String selectSumYesParticiateByTourIdx(ReservationBasicVo vo);
		
		
		//Na 추가
		//예약 삭제
		@Delete("DELETE FROM GF_RESERVATION_INFO WHERE RESERVATION_IDX=#{reservation_idx}")
		public void deleteByReservationIdx(ReservationBasicVo vo);
				
		//예약 삭제 시 reservation_tour_cancel #{reservation_tour_cancel}
		@Update("UPDATE GF_RESERVATION_INFO SET RESERVATION_TOUR_CANCEL='y' WHERE RESERVATION_IDX=#{reservation_idx}")
		public void updateReservationCancel(ReservationBasicVo vo);
		
		//++한솔추가
		@Select("SELECT * FROM GF_RESERVATION_INFO WHERE MEMBER_IDX=#{member_idx} AND RESERVATION_CONFIRM='y' AND RESERVATION_TOUR_CANCLE='n' ")
		public ArrayList<ReservationBasicVo> selectReservationForWriteReview(int member_idx);
	
}
