package com.gf.guideforyou.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gf.guideforyou.vo.Customer_EvaluationBasicVo;
import com.gf.guideforyou.vo.MemberBasicVo;
import com.gf.guideforyou.vo.ReservationBasicVo;


public interface Customer_EvaluationSQLMapper {
	
	@Insert("INSERT INTO GF_CUSTOMER_EVALUATION VALUES(GF_CUSTOMER_EVALUATION_SEQ.NEXTVAL,#{tour_idx},#{member_idx},#{customer_score},#{customer_review})")
	public void insertCustomerEvaluation(Customer_EvaluationBasicVo vo);

	// 고객의 총 평점을 구하는 쿼리문
	@Select("SELECT ROUND(AVG(CUSTOMER_SCORE)) FROM GF_CUSTOMER_EVALUATION WHERE MEMBER_IDX=#{member_idx}")
	public int selectAvg_Score(int member_idx); 
	
	//투어 idx로 
	@Select("SELECT * FROM GF_CUSTOMER_EVALUATION WHERE TOUR_IDX=#{tour_idx}")
	public ArrayList<Customer_EvaluationBasicVo> selectCustomerByTourIdx(Customer_EvaluationBasicVo vo);
	
	@Delete("DELETE GF_CUSTOMER_EVALUATION WHERE CUSTOMER_IDX=#{customer_idx}")
	public void deleteReviewByCustomer_Idx(int customer_idx);
	
	
	//추가된  sql문 입니다   유기조!!!
	//member_idx로  유기조 변경
		@Select("SELECT * FROM GF_CUSTOMER_EVALUATION WHERE MEMBER_IDX=#{member_idx}")
		public ArrayList<Customer_EvaluationBasicVo> kijoSelectCustomerByMemberIdx(MemberBasicVo vo);
		
		// 고객의 총 평점을 구하는 쿼리문
		@Select("SELECT ROUND(AVG(CUSTOMER_SCORE)) FROM GF_CUSTOMER_EVALUATION WHERE MEMBER_IDX=#{member_idx}")
		public String kijoselectAvg_Score(int member_idx); 
		
		//유기조  2차로 추가된 것입니다
		@Select("SELECT * FROM GF_RESERVATION_INFO WHERE TOUR_IDX=#{tour_idx} AND RESERVATION_CONFIRM ='y' AND MEMBER_IDX NOT IN(SELECT MEMBER_IDX FROM GF_CUSTOMER_EVALUATION WHERE TOUR_IDX=#{tour_idx})")
		public ArrayList<Customer_EvaluationBasicVo>  kijoSelectCustomerByMemberTour(ReservationBasicVo vo);
}
