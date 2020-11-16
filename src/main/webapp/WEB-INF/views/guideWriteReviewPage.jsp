<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/myPage_css/myPageTotalCss.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    
    <title>가이드 리뷰작성</title>
    <style>
		.mypage_header{
 		   	background-color: #2E2E2E;
   		   	width:100%;
    		margin-bottom: 130px;
		}
	</style>
</head>
<body>
		<c:choose>
        	<c:when test="${empty memberSession }">
        		<header class="mypage_header ">
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
        
        <div class="container myPage_wrapper">
            
            <main class="guideReservationList_main">
                <div class="guideReservationList_main_title">고객에게 리뷰주기</div>
                <div class="guideWritereview_main_title "> 참가한 사람</div>
                
                
                <section id="guidelList_notcomp" class=" guideReservationList_notcomp board_tabcontent">
                   <c:forEach items="${guideRMTJoinData}" var="RMTJoinData">
                   		<div class="writeReview_column task ">
                        <div class="title guidelList_content_title">${RMTJoinData.tourBasicVo.tour_intro}</div>
                        <div class="writeReview_column_div"></div>
                        <div class="guidelList_content_nick">
                        
                        <c:choose>
                        	<c:when test="${RMTJoinData.memberBasicVo.member_profile_photo == 'n'}">
                        		<a href="./credit_infoPage?member_idx=${RMTJoinData.memberBasicVo.member_idx}" class="guideReservation_photo_column ">
                                	<img src="myPageImg/basic_img.jpg" class="guideReservation_photo">
                            	</a>
                        	</c:when>
                        	<c:otherwise>
                        		<a href="credit_infoPage?member_idx=${RMTJoinData.memberBasicVo.member_idx}" class="guideReservation_photo_column ">
                                	<img src="${RMTJoinData.memberBasicVo.member_profile_photo}" class="guideReservation_photo">
                            	</a>
                        	</c:otherwise>
                        </c:choose>
                            
                            <div class="writeReview_column_name guidelList_content ">${RMTJoinData.memberBasicVo.member_nick}</div> 
                        </div> 
                        <div class="writeReview_column_div"></div>
                        <a href="./guideEvaluationWritePage?tour_idx=${RMTJoinData.tourBasicVo.tour_idx}&member_idx=${RMTJoinData.memberBasicVo.member_idx}" class="n_guide_arrow ">고객리뷰작성<i class="fas fa-chevron-right "></i></a>
                    </div>
                   
                   
                   </c:forEach>
                 
                </section>
            </main>
            <footer class="common_footer">공통 footer ui를 넣을 겁니다</footer>
        </div>


        <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
</body>
</html>