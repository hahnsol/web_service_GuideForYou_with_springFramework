package com.gf.guideforyou.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.guideforyou.mapper.Customer_EvaluationSQLMapper;
import com.gf.guideforyou.mapper.Guide_EvaluationSQLMapper;
import com.gf.guideforyou.mapper.MemberSQLMapper;
import com.gf.guideforyou.mapper.ReservationSQLMapper;
import com.gf.guideforyou.mapper.Tour_EnrollSQLMapper;
import com.gf.guideforyou.vo.Customer_EvaluationBasicVo;
import com.gf.guideforyou.vo.Guide_EvaluationBasicVo;
import com.gf.guideforyou.vo.MemberBasicVo;
import com.gf.guideforyou.vo.MemberTourCustomerJoin;
import com.gf.guideforyou.vo.MemberTourGuideJoin;
import com.gf.guideforyou.vo.MemberTourJoinVo;
import com.gf.guideforyou.vo.ReservationBasicVo;
import com.gf.guideforyou.vo.ReservationCGMemberVo;
import com.gf.guideforyou.vo.ReservationMemberTourJoinVo;
import com.gf.guideforyou.vo.SessionUserDataVo;
import com.gf.guideforyou.vo.TourBasicVo;



@Service
public class CustomerMypageServiceImpl implements CustomerMypageService{
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	@Autowired 
	private Tour_EnrollSQLMapper tour_EnrollSQLMapper;
	@Autowired
	private ReservationSQLMapper reservationSQLMapper;
	@Autowired
	private Customer_EvaluationSQLMapper customer_EvaluationSQLMapper;
	@Autowired 
	private Guide_EvaluationSQLMapper guide_EvaluationSQLMapper;
	
	
	//게스트 예약신청내역 가져오기
	@Override
	public ArrayList<ReservationMemberTourJoinVo> customerGetReservationList(MemberBasicVo vo) {
		// TODO Auto-generated method stub
		ArrayList<ReservationMemberTourJoinVo> customerReservationList = new ArrayList<ReservationMemberTourJoinVo>();
		
		ArrayList<ReservationBasicVo> customerRContentList = reservationSQLMapper.selectCustomerReservationAll(vo);
		
		System.out.println(vo.getMember_idx()+"의 예약신청list size="+customerRContentList.size());
		
		for(ReservationBasicVo reservation : customerRContentList) {
			
			if(reservation.getReservation_tour_cancle().equals("n")) {
			
				//reservationVo로 tourInfo추출
				TourBasicVo tourInfo = tour_EnrollSQLMapper.selectReservationTourNotCompleteByTourIdx(reservation);
			
				if(tourInfo == null) {
					continue;
				}
				
				System.out.println("투어_idx="+tourInfo.getTour_idx());
				
				int guideInfo_idx = tourInfo.getMember_idx();
				
				System.out.println("가이드Member_idx="+guideInfo_idx);
				
				//가이드 nick추출
				MemberBasicVo guideInfo = memberSQLMapper.selectMemberInfoByMemberIdx(guideInfo_idx);
			
				//예약정보와 가이드정보, tour정보 join
				ReservationMemberTourJoinVo reservationTourJoin = new ReservationMemberTourJoinVo(reservation,guideInfo,tourInfo);
			
				//예약리스트에 추가
				customerReservationList.add(reservationTourJoin);
				
			}
			
//			System.out.println(reservation.getReservation_idx());
//			TourBasicVo tourVo = new TourBasicVo();
//			if(reservation.getReservation_tour_cancle().equals("n")) {
//
//				tourVo.setTour_idx(reservation.getTour_idx());
//				TourBasicVo tour = tour_EnrollSQLMapper.selectTourByTourIdx(tourVo);
//				
//				TourBasicVo tourInfo = tour_EnrollSQLMapper.selectTourByTourIdx(tour);
//				System.out.println(tourInfo.getTour_idx());
//				if(tourInfo.getTour_complete().equals("n")) {
//					MemberBasicVo member = memberSQLMapper.selectMemberInfoByMemberIdx(tourInfo.getMember_idx());
//					
//					ReservationMemberTourJoinVo customerRData = new ReservationMemberTourJoinVo(reservation, member, tourInfo);
//					
//					customerReservationList.add(customerRData);
//				}
//			}
			
			
			
		}
		
		return customerReservationList;
	}


	@Override
	public ReservationCGMemberVo watchCustomerReservationInfo(ReservationBasicVo vo) {
		
		ReservationBasicVo reservation = reservationSQLMapper.selectReservationInfoByReservationIdx(vo);

		TourBasicVo tour = tour_EnrollSQLMapper.selectReservationTourByTourIdx(reservation);
		
		MemberBasicVo memberG = memberSQLMapper.selectMemberInfoByMemberIdx(tour.getMember_idx());
		
		MemberBasicVo memberC = memberSQLMapper.selectMemberInfoByMemberIdx(reservation.getMember_idx());
		
		ReservationCGMemberVo customerRData = new ReservationCGMemberVo(reservation, memberG, memberC, tour);
		
		return customerRData;
	}
	
	@Override
	public void updateCustomerReservationForm(ReservationBasicVo vo) {
		
		reservationSQLMapper.updateReservationForm(vo);
	}
	
	@Override
	public void cancelReservation(ReservationBasicVo vo) {
		
		reservationSQLMapper.updateReservationCancel(vo);
	}
	
	@Override
	public ReservationCGMemberVo getReservationData(ReservationBasicVo vo) {
		
		ReservationBasicVo reservation = reservationSQLMapper.selectReservationInfoByReservationIdx(vo);

		TourBasicVo tour = tour_EnrollSQLMapper.selectReservationTourByTourIdx(reservation);
		
		MemberBasicVo memberG = memberSQLMapper.selectMemberInfoByMemberIdx(tour.getMember_idx());
		
		MemberBasicVo memberC = memberSQLMapper.selectMemberInfoByMemberIdx(reservation.getMember_idx());
		
		ReservationCGMemberVo customerRData = new ReservationCGMemberVo(reservation, memberG, memberC, tour);
		
		return customerRData;
	}
	
	
	

	//내가 작성한 리뷰
	@Override
	public ArrayList<MemberTourGuideJoin> getIWriteReview(MemberBasicVo vo) {

		ArrayList<MemberTourGuideJoin> MTGJoinVo = new ArrayList<MemberTourGuideJoin>();
		
		ArrayList<Guide_EvaluationBasicVo> myGuideInfo =
				guide_EvaluationSQLMapper.getGuideInfoByMember_idx(vo.getMember_idx());
		
		for(Guide_EvaluationBasicVo g : myGuideInfo) {
			
			TourBasicVo tour = new  TourBasicVo();
			tour.setTour_idx(g.getTour_idx());
			
			TourBasicVo myPartyTour = tour_EnrollSQLMapper.selectTourByTourIdx(tour);
			
			MemberBasicVo guideMemberInfo =
						memberSQLMapper.selectMemberInfoByMemberIdx(myPartyTour.getMember_idx());
			
			MemberTourGuideJoin mtg = 
					new  MemberTourGuideJoin(guideMemberInfo, myPartyTour, g);
			
			MTGJoinVo.add(mtg);
		}
		
		return MTGJoinVo;
	}
	
	//내가 받은 리뷰
	@Override
	public ArrayList<MemberTourCustomerJoin> getIGotReview(MemberBasicVo vo) {

		
		ArrayList<MemberTourCustomerJoin> MTCJoinVo = new ArrayList<MemberTourCustomerJoin>();
		
		ArrayList<Customer_EvaluationBasicVo> myCustomerInfo =
				customer_EvaluationSQLMapper.kijoSelectCustomerByMemberIdx(vo);
		
		for(Customer_EvaluationBasicVo c : myCustomerInfo) {
			TourBasicVo tour = new TourBasicVo();
			tour.setTour_idx(c.getTour_idx());
			
			TourBasicVo myPartyTour = tour_EnrollSQLMapper.selectTourByTourIdx(tour);
			
			MemberBasicVo guideInfo = memberSQLMapper.selectMemberInfoByMemberIdx(myPartyTour.getMember_idx());
			
			MemberTourCustomerJoin mtc = 
					new MemberTourCustomerJoin(guideInfo, myPartyTour, c);
			
			MTCJoinVo.add(mtc);
		}
		
		return MTCJoinVo;
	}
	

	//++한솔 추가 
	@Override
	public ArrayList<MemberTourJoinVo> tourListForWriteReview(int member_idx) {
		
		ArrayList<MemberTourJoinVo> tourMemberListForReview = new ArrayList<MemberTourJoinVo>();
		
		//나의 예약확정list추출
		ArrayList<ReservationBasicVo> customerReservation = reservationSQLMapper.selectReservationForWriteReview(member_idx);
		
		System.out.println("예약확정갯수="+customerReservation.size());//3
		
		if(customerReservation.size()!=0) {
			for(int i=0; i<customerReservation.size(); i++) {
				//완료된투어추출
				TourBasicVo completedTour = tour_EnrollSQLMapper.selectCompleteTourByTourIdx(customerReservation.get(i));
				
				if(completedTour == null) {
					System.out.println("존재하지않는투어-->넘어감");
					continue;
				} else {
					System.out.println("완료된투어idx="+completedTour.getTour_idx());
					//리뷰를쓴투어는생략
					Guide_EvaluationBasicVo existReview = guide_EvaluationSQLMapper.selectReviesWirtten(completedTour, member_idx);
					if(existReview != null) {
						continue;
					} else {
						//가이드 정보 추출
						System.out.println("가이드멤버idx="+completedTour.getMember_idx());
						int guideMemberIdx = completedTour.getMember_idx();
						MemberBasicVo guideInfo = memberSQLMapper.selectMemberInfoByMemberIdx(guideMemberIdx);
						//투어랑 가이드정보 join
						MemberTourJoinVo tourMemberInfoForReview = new MemberTourJoinVo(guideInfo,completedTour);
						//리스트에 추가
						tourMemberListForReview.add(tourMemberInfoForReview);
					}//안쪽else
					
				}//바깥쪽else
				System.out.println("for문"+(i+1)+"번 돌았음");
			}//for문
			
		}
		
		System.out.println("서비스쪽에서 넘겨줄 list size="+tourMemberListForReview.size());
		
		return tourMemberListForReview;
	}
	
	
	
	
	//++한솔추가
	public MemberTourJoinVo getGuideInfoTourInfo(TourBasicVo vo) {
		
		//리뷰쓸투어정보가져오기
		TourBasicVo tourInfo = tour_EnrollSQLMapper.selectTourByTourIdx(vo);
		//리뷰쓸가이드정보가져오기
		MemberBasicVo guideInfo = memberSQLMapper.selectMemberInfoByMemberIdx(tourInfo.getMember_idx());
		
		MemberTourJoinVo guideNTourInfoForWriteReview = new MemberTourJoinVo(guideInfo,tourInfo);
		
		return guideNTourInfoForWriteReview;
	}
	
	
	//++한솔추가
	public void insertGuideReview(Guide_EvaluationBasicVo vo) {
		//가이드리뷰테이블에 저장
		guide_EvaluationSQLMapper.insertGuideEvauation(vo);
	}
	
	

	
}