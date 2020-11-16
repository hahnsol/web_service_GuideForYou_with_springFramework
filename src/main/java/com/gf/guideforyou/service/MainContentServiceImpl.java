package com.gf.guideforyou.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.guideforyou.mapper.Guide_EvaluationSQLMapper;
import com.gf.guideforyou.mapper.Location_CategorySQLMapper;
import com.gf.guideforyou.mapper.MemberSQLMapper;
import com.gf.guideforyou.mapper.ReservationSQLMapper;
import com.gf.guideforyou.mapper.Tour_EnrollSQLMapper;
import com.gf.guideforyou.vo.*;

@Service
public class MainContentServiceImpl implements MainContentService {

	@Autowired
	private Tour_EnrollSQLMapper tourMapper;
	@Autowired
	private MemberSQLMapper memberMapper;
	@Autowired
	private Guide_EvaluationSQLMapper guideEvaluationMapper;
	@Autowired
	private Location_CategorySQLMapper locationMapper;
	@Autowired
	private ReservationSQLMapper reservationMapper;
	
	@Override
	public Location_CategoryBasicVo getLocalName(TourBasicVo vo) {
		
		Location_CategoryBasicVo locationVo = locationMapper.selectLocalNameByLocationIdx(vo);
		
		return locationVo;
	}
	
	
	@Override
	public void compareToCurrentDate() {
		// 투어 날짜가  오늘 날짜를 지난 경우 투어 완료로 변경

		tourMapper.updateTour_complete();
		
	}
	
	
	@Override
	public ArrayList<JinSunMiVo> getJinSunMi(TourBasicVo vo) {
		
		
		ArrayList<JinSunMiVo> JinsunmiInfoList= new ArrayList<JinSunMiVo>();
		
		//이번달 투어왕 진선미의 투어정보,개인정보,평점을 한번에 담을 리스트준비
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		
		String startDate = year+"/"+month+"/"+"01";
		String endDate = year+"/"+month+"/"+"31";
		
		System.out.println(startDate);
		System.out.println(endDate);
		ArrayList<TourBasicVo> selectJinsunmi = tourMapper.selectJinSunMi(vo, startDate, endDate);
		
		
		if(selectJinsunmi.size() == 0) {
			System.out.println("진선미 없음");
			JinsunmiInfoList.add(null);
			return JinsunmiInfoList;
			
		}else {
			for(TourBasicVo jinsunmi : selectJinsunmi) {
				//진선미의 tourInfo가져오기
				TourBasicVo tour = new TourBasicVo();
				tour.setTour_idx(jinsunmi.getTour_idx());
				
				TourBasicVo jinsunmiTourInfo = tourMapper.selectTourByTourIdx(tour); //selectTourBuTourIdx는 int가 아닌 vo형태를 넘겨받기 때문에 tour_idx int를 집어넣은 vo 형태를 새로 만들어 넣어줌. 
				//진선미의 memberInfo가져오기
				System.out.println(jinsunmiTourInfo.getTour_idx());
				MemberBasicVo jinsunmiMemberInfo  = memberMapper.selectMemberInfoByMemberIdx(jinsunmiTourInfo.getMember_idx());
				//진선미 멤버,투어,투어평점join하기
				System.out.println(jinsunmiMemberInfo.getMember_idx());
				
				double avg = guideEvaluationMapper.getAvgScoreByTour_idx(jinsunmiTourInfo.getTour_idx());
				
				System.out.println(avg);
				
				JinSunMiVo jinsunmiInfo = new JinSunMiVo(jinsunmiMemberInfo,jinsunmiTourInfo,avg);
				
				//list에 추가
				
				JinsunmiInfoList.add(jinsunmiInfo);
			}
			return JinsunmiInfoList;
		}
		
		
		
		
	}
	
	@Override
	public ArrayList<Guide_Avg_ScoreVo> getLocalPageContentLists(TourBasicVo vo) {
		
		//controller로 보내줄 게시글List들
		ArrayList<Guide_Avg_ScoreVo> mainLocalPageContentList = new ArrayList<Guide_Avg_ScoreVo>();
		
		//location_idx에 맞는 tourList추출
		ArrayList<TourBasicVo> kindOfLocalTourList = tourMapper.selectAllByLocationIdx(vo);
		
		//해당 게시글과(투어글과) 가이드의 memberInfo join
		for(TourBasicVo tour : kindOfLocalTourList) {

			if(tour.getTour_complete().equals("n")) {
				//해당투어게시글의 가이드 정보
				MemberBasicVo guideInfo = memberMapper.selectMemberInfoByMemberIdx(tour.getMember_idx());
				//해당투어게시글의 가이드 평점 을 스트링으로 가져온것을 double로 바꿔주어 저장
				String stringGuideScore = guideEvaluationMapper.selectAvg_Score(tour.getMember_idx());
				double doubleGuideScore ;
				
				if(stringGuideScore == null) {
					doubleGuideScore = 0.0;
				} else {
					doubleGuideScore = Double.parseDouble(stringGuideScore);
				}
				
				//투어,가이드정보,가이드평점 join
				Guide_Avg_ScoreVo tourNGuideNScore = new Guide_Avg_ScoreVo(guideInfo, tour, doubleGuideScore);
				//게시글 하나씩 추가
				mainLocalPageContentList.add(tourNGuideNScore);
			}
		}
		
		return mainLocalPageContentList;
	}

	
	@Override
	public ArrayList<ReservationBasicVo> checkUserBooking(TourBasicVo vo ) {
		
		ReservationBasicVo reservationInfo = new ReservationBasicVo();
		reservationInfo.setTour_idx(vo.getTour_idx());
		
		ArrayList<ReservationBasicVo> tourPartyList = reservationMapper.selectReservationInfoByTourIdx(reservationInfo);
		
		return tourPartyList;
	}
	
	
	
	@Override
	public MemberTourJoinVo getGuideContent(TourBasicVo vo) {
		
		//해당 투어게시글 추출
		TourBasicVo tourData = tourMapper.selectTourByTourIdx(vo);
		//해당 투어게시글 가이드 정보 추출
		MemberBasicVo memberData = memberMapper.selectMemberInfoByMemberIdx(tourData.getMember_idx());
		
		//두개 정보 join
		MemberTourJoinVo mainTourContentData = new MemberTourJoinVo(memberData,tourData);
		
		return mainTourContentData;
	}

	
	@Override
	public MemberBasicVo getMemberInfo(int vo) {
		
		//투어등록페이지에서 가이드정보(글쓴이정보 추출)
		MemberBasicVo mainTuourEnrollMemberData = memberMapper.selectMemberInfoByMemberIdx(vo);
				
		return mainTuourEnrollMemberData;
	}

	@Override
	public void insertTourEnroll(TourBasicVo vo) {
		//투어테이블에등록
		tourMapper.insertTour(vo);
	}

	@Override
	public void updateTourContent(TourBasicVo vo) {
		//투어게시글수정
		tourMapper.updateTourContent(vo);
	}

	@Override
	public void deleteTourContent(TourBasicVo vo) {
		//투어게시글 삭제
		tourMapper.deleteTourContent(vo);
	}

	@Override
	public void insertReservation(ReservationBasicVo vo) {
		//투어예약테이블에 등록
		reservationMapper.insertReservation(vo);
	}

	@Override
	public TourBasicVo getTourInfo(int tour_idx) {
		
		TourBasicVo  tour = new TourBasicVo();
		tour.setTour_idx(tour_idx);
		
		TourBasicVo tourContentData = tourMapper.selectTourByTourIdx(tour);
		
		
		return tourContentData;
	}

	@Override
	public ArrayList<TourBasicVo> getTourList(TourBasicVo vo) {
		//tourList추출
		ArrayList<TourBasicVo> TourListSelectByMemberIdx = tourMapper.selectTourByMemberIdx(vo);
		
		return TourListSelectByMemberIdx;
	}

	

	
	
	
	
}