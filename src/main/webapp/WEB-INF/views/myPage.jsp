<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/myPage_css/myPageTotalCss.css">
    <link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <title>my page</title>
</head>
<body>
    
         <c:choose>
        	<c:when test="${empty memberSession }">
        		<header>
        			<div class="header_wrapper">
            			<a href="./indexPage">
                			<div class="header_column1">
                   				<img src="MainImages/logo3.gif" alt="로고">
                   				<div class="header-web_name">GuideForYou</div>
                			</div>
            			</a>
            			<div class="header_column2">
                			<a href="./loginPage" class="headerWhenNotLogin headerWhenNotLogin_first login-blackLine_first ">
                    			<div class="header-login blackText">로그인</div>
                			</a>
                			<a href="./joinMemberPage" class="headerWhenNotLogin login-blackLine_second ">
                    			<div class="header-join blackText">회원가입</div>
                			</a>
            			</div>
        			</div>
    			</header>
        	</c:when>
        	<c:otherwise>
        		<header>
                	<div class="header_wrapper">
                    	<a href="./indexPage">
                        	<div class="header_column1">
                           		<img src="MainImages/logo3.gif" alt="로고">
                           		<div class="header-web_name">GuideForYou</div>
                        	</div>
                    	</a>
                    	<div class="header_column2">
                        	<a href="./myPage" class="headerWhenLogin headerWhenLogin_first notLogin-blackLine_first">
                            	<c:choose>
                        			<c:when test="${memberSession.member_profile_photo == 'n' }">
                        				<img alt="member_profile_photo" class="header_memberProfilePhoto" src="MainImages/basicMemberProfile.jpg">
                        			</c:when>
                        			<c:otherwise>
                        				<img alt="member_profile_photo" class="header_memberProfilePhoto" src="${memberSession.member_profile_photo}">
                        			</c:otherwise>
                        		</c:choose> 
                            	<div class="header-row blackText">마이페이지</div>
                        	</a>
                        	<a href="./logoutAction" class="headerWhenLogin headerWhenLogin_second notLogin-blackLine_second">
                            	<div class="header-row blackText">로그아웃</div>
                        	</a>
                        	<a href="./tourEnrollPage" class="headerWhenLogin headerWhenLogin_third notLogin-blackLine_third">
                            	<div class="header-row blackText">투어게시</div>
                        	</a>
                    	</div>
                	</div>
            	</header>
        	</c:otherwise>
        </c:choose>
        

        <main class="mypage_main align-items">
            <section class="mypage_main_profile">
                <div class="main_header_container container"> 
                    <div class="mypage_main_profile_top">
                        <div class="mypage_main_profile_top_title">My Page</div> 
                        <a href="./checkPasswordPage" class="mypage_main_profile_top_icon">  <!-- 내정보 수정 페이지 로 이동  아무것도 넘기지 않았습니다 -->
                            <i class="fas fa-cog profile_bottom_icon"></i>
                            <div class="mypageModify">내 정보 수정</div>
                        </a>
                    </div>
                
                    <div class="mypage_main_profile_bottom d-flex justify-content-center">
                        <div class="mypage_main_profile_bottom_left col-11 ">
                        
                        	<c:choose>
                        		<c:when test="${guideMemberSessionInfo.member_profile_photo == 'n'}">
                        			<a href="./credit_infoPage?member_idx=${guideMemberSessionInfo.member_idx}" class="mypage_main_profile_bottom_photo">
                            			<img src="myPageImg/basic_img.jpg" class="img-thumbnail">
                            		</a>  <!-- 세션에서 member_idx를 넘김 but  할수 있다면 controller에서 세션 정보를 받을수 있을까?? 나는 가능  머지 할경우도 가능 한지 확인해보기-->
                        		</c:when>
                        		<c:otherwise>
                        			<a href="./credit_infoPage?member_idx=${guideMemberSessionInfo.member_idx}" class="mypage_main_profile_bottom_photo">
                            			<img src="${memberSession.member_profile_photo}" class="img-thumbnail">
                            		</a>  <!-- 세션에서 member_idx를 넘김 but  할수 있다면 controller에서 세션 정보를 받을수 있을까?? 나는 가능  머지 할경우도 가능 한지 확인해보기-->
                        		</c:otherwise>
                        	</c:choose>
                            
                            <div class="mypage_main_profile_bottom_nick">${guideMemberSessionInfo.member_nick}</div>
                            <!-- 세션에서 닉네임을 가져옴 -->
                        </div>       
                    </div>     
                </div>
                
            </section>

        <div class="container myPage_wrapper">
            <section class="align-items-center mypage_main_sector ">
                <div class="container mypage_main_sector_guide">
                    <div class="d-flex justify-content-start mypage_main_sector_guide_header">가이드 섹터</div>
                    <div class=" mypage_main_sector_guide_body">
                        <a href="./myBoardReadingPage"><div  class=" guide_body_content"><i class="fas fa-book-open myPageIcon"></i>내 게시글</div></a>
                        <div class="mypage_main_div"></div>
                        <a href="./guideReservationListPage"><div class=" guide_body_booking_confirm"><i class="far fa-calendar-check myPageIcon"></i>내 투어 예약 관리</div></a>
                        <div class="mypage_main_div"></div>
                        <a href="./guideWriteReviewPage"><div class=" guide_body_write_review"><i class="fas fa-pencil-alt myPageIcon"></i>리뷰작성</div></a>
                        <div class="mypage_main_div"></div>
                        <a href="./guideManageReviewPage"><div class="guide_body_manage_review"><i class="fas fa-eraser myPageIcon"></i>리뷰 관리</div></a>
                    </div>
                </div>
                <div class="container mypage_main_sector_customer">
                    <div class="d-flex justify-content-start mypage_main_sector_customer_header">게스트 섹터</div>
                    <div class="mypage_main_sector_customer_body ">
                        <a href="./customerReservationListPage"><div class="customer_body_booking"><i class="fas fa-plane-departure myPageIcon"></i>예약 신청내역 </div></a>
                        <div class="mypage_main_div"></div>
                        <a href="./customerEvaluationCheckPage"><div class="customer_body_write_review"><i class="fas fa-pencil-alt myPageIcon"></i>리뷰 작성</div></a>
                        <div class="mypage_main_div"></div>
                        <a href="./customerEvaluationListPage"><div class="customer_body_manage_review"><i class="fas fa-eraser myPageIcon"></i>리뷰 관리</div></a> 
                    </div>
                </div>
            </section>
           </div>
        </main>

        <footer class="mypage_footer">공통 footer ui를 넣을 겁니다</footer>
    
    
    
   
    	
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>