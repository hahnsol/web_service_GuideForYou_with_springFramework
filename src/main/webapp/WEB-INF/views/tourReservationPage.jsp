<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>tourReservationPage</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo&display=swap" rel="stylesheet"> 
    <style>
        body{
            top:0;
            margin:0;
            padding:0;
            background: url("https://cdn.pixabay.com/photo/2016/01/09/18/27/old-1130731_960_720.jpg") no-repeat center center fixed; 
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover; 
        }
    </style>
</head>
<body class="tourReservationPage_body">
    
    <!--투어예약신청 페이지-->

        <c:choose>
        	<c:when test="${empty memberSession }">
        		<header class="dark_header">
        			<div class="header_wrapper">
            			<a href="./indexPage">
                			<div class="header_column1">
                   				<img src="MainImages/logo3.gif" alt="로고">
                   				<div class="header-web_name">GuideForYou</div>
                			</div>
            			</a>
            			<div class="header_column2">
                			<a href="./loginPage" class="headerWhenNotLogin headerWhenNotLogin_first">
                    			<div class="header-login">로그인</div>
                			</a>
                			<a href="./joinMemberPage" class="headerWhenNotLogin">
                    			<div class="header-join">회원가입</div>
                			</a>
            			</div>
        			</div>
    			</header>
        	</c:when>
        	<c:otherwise>
        		<header class="dark_header">
            		<div class="header_wrapper">
                		<a href="./indexPage">
                    		<div class="header_column1">
                       			<img src="MainImages/logo3.gif" alt="로고">
                       			<div class="header-web_name">GuideForYou</div>
                    		</div>
                		</a>
                		<div class="header_column2">
                    		<a href="./myPage" class="headerWhenLogin headerWhenLogin_first">
                        		<c:choose>
                        			<c:when test="${memberSession.member_profile_photo == 'n' }">
                        				<img alt="member_profile_photo" class="header_memberProfilePhoto" src="MainImages/basicMemberProfile.jpg">
                        			</c:when>
                        			<c:otherwise>
                        				<img alt="member_profile_photo" class="header_memberProfilePhoto" src="${memberSession.member_profile_photo }">
                        			</c:otherwise>
                        		</c:choose> 
                        		<div class="header-row header_mypageText">마이페이지</div>
                    		</a>
                    		<a href="./logoutAction" class="headerWhenLogin headerWhenLogin_second">
                        		<div class="header-row">로그아웃</div>
                    		</a>
                    		<a href="./tourEnrollPage" class="headerWhenLogin headerWhenLogin_third">
                        		<div class="header-row">투어게시</div>
                    		</a>
                		</div>
            		</div>
        		</header>
        	</c:otherwise>
        </c:choose>

        <main class="tourReservationPage_main">
            <div class="tourReservationPage_main-top">
                투어예약신청
            </div>
            <form action="./reservationInsertAction" method="get" class="tourReservationPage_main-form">
                <!--신청투어 요약--> 
                <div class="tourReservationPage_form-tourSummary">
                     <div class="tourReservationPage_form-tourSummary_tourGuide">
                     	<c:choose>
                     		<c:when test="${mainTourDataForReservation.memberBasicVo.member_profile_photo == 'n' }">
                     			<img alt="#member_photo"class="tourReservationPage_tourSummary-guidePhoto" src="MainImages/basicMemberProfile.jpg">
                     		</c:when>
                     		<c:otherwise>
                        		<img alt="#member_photo"class="tourReservationPage_tourSummary-guidePhoto" src="${mainTourDataForReservation.memberBasicVo.member_profile_photo }">
                        	</c:otherwise>
                        </c:choose>
                        <div class="tourReservationPage_tourSummary-guideNick">${mainTourDataForReservation.memberBasicVo.member_nick }</div>    
                    </div>
                    <div class="tourReservationPage_form-tourSummary_tourTitle">
                        ${mainTourDataForReservation.tourBasicVo.tour_intro }
                    </div>
                    <div class="tourReservationPage_form-tourSummary_tourDate">
                        <div class="tourReservationPage_form-tourSummary_tourDate-text">투어날짜</div>
                        <div class="tourReservationPage_form-tourSummary_tourDate-insert">
                        	<fmt:parseDate var="tourDate" value="${mainTourDataForReservation.tourBasicVo.tour_tourdate }" pattern="yyyy-MM-dd"></fmt:parseDate> 
                        	<fmt:formatDate value="${tourDate}" pattern="yyyy-MM-dd"/>  
                        </div>
                    </div>
                 </div>
                 <!--신청투어 양식-->
                 <div class="tourReservationPage_main-form-customerInfo">
                     <!--tour_idx 넘겨주기-->
                     <input name="tour_idx" type="hidden" value="${mainTourDataForReservation.tourBasicVo.tour_idx }">
                     <div class="tourReservationPage_main-form-customerInfo_row">
                         <!--투어신청자 member_idx넘겨주기-->
                         <input name="member_idx" type="hidden" value="${mainMemberDataForReservation.member_idx }">
                        <div class="tourReservationPage_main-form-customerInfo_column1">
                             	신청자
                        </div>
                        <div class="tourReservationPage_main-form-customerInfo_column2">
                             ${mainMemberDataForReservation.member_name }
                        </div>
                     </div>
                     <div class="tourReservationPage_main-form-customerInfo_row">
                        <div class="tourReservationPage_main-form-customerInfo_column1">
                            	 나이
                        </div>
                        <div class="tourReservationPage_main-form-customerInfo_column2">
                             ${mainMemberDataForReservation.member_age }
                        </div>
                     </div>
                     <div class="tourReservationPage_main-form-customerInfo_row">
                        <div class="tourReservationPage_main-form-customerInfo_column1">
                             	성별
                        </div>
                        <div class="tourReservationPage_main-form-customerInfo_column2">
                             ${mainMemberDataForReservation.member_gender }
                        </div>
                     </div>
                     <div class="tourReservationPage_main-form-customerInfo_row">
                        <div class="tourReservationPage_main-form-customerInfo_column1">
                             	연락처
                        </div>
                        <!-- reservation_call 넘겨주기-->
                        <input name="reservation_call" type="text" class="tourReservationPage_input" placeholder="전화번호 or 카톡아이디" required="required">
                     </div>
                     <div class="tourReservationPage_main-form-customerInfo_row">
                        <div class="tourReservationPage_main-form-customerInfo_column1">
                            	 참여인원수
                        </div>
                        <!-- reservation_participate  넘겨주기-->
                        <input name="reservation_participate" type="number" class="tourReservationPage_input" placeholder="ex) 2" required="required"> 
                     </div>
                     <div class="tourReservationPage_main-form-customerInfo_wish">
                        <div class="tourReservationPage_main-form-customerInfo_column1">
                             	바라는 점
                        </div>
                        <!-- reservation_wish 넘겨주기-->
                        <textarea name="reservation_wish" class="tourReservationPage_textarea" maxlength="50"></textarea>    
                     </div>
                     <!--예약상태--보류(b)로(reservation_confirm), 투어신청취소여부--(n)으로(reservation_tour_cancel) 넘겨주기 -->
                     <input name="reservation_confirm" type="hidden" value="b">
                     <input name="reservation_tour_cancel" type="hidden" value="n">
                     <button type="submit" class="tourReservationPage_btn">예약신청</button>
                 </div>
            </form>
        </main>

        <div>--------footer--------</div>

</body>
</html>