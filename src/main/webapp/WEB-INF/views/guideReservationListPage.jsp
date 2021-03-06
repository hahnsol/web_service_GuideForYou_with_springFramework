<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>가이드 예약 신청 내역</title>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/myPage_css/myPageTotalCss.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <style type="text/css">
        
        		
			.discribe_title{
    			display: flex;
    			flex-direction: column;
    			justify-content: center;
    			align-items: center;
    			border-bottom: 1px solid rgba(66, 65, 65, 0.5);
			}

			.guide_navigation{
    			color: rgb(86, 88, 223);
			}
        </style>
        <script>
            function openBoard(evt, cityName) {
              var i, tabcontent, tablinks;
              tabcontent = document.getElementsByClassName("board_tabcontent");
              for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
              }
              tablinks = document.getElementsByClassName("guideReservationList_main_tablinks");
              for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
              }
              document.getElementById(cityName).style.display = "block";
              evt.currentTarget.className += " active";
            }
    </script>
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
                <div class="guideReservationList_main_title">내 투어 예약 관리</div>


                
                <div class="discribe_title">
                	<div class="guideReservationList_main_tablinks doingTour">진행중인 투어</div>
                	<div class="task container-fluid guide_navigation ">
                            <div class="guide_nav title guidelList_content col-4">제목</div>
                            <div class="task_div"></div>
                            <div class="guide_nav region guidelList_content col-2">투어지역</div>
                            <div class="task_div"></div>
                            <div class="guide_nav date guidelList_content col-2">투어날짜</div>
                            <div class="task_div"></div>
                            <div class="guide_nav max_participate guidelList_content col-3">(신청인원/참여가능 인원)</div>
                            
                   </div>
                </div>
                
                 

                <!--미완료 투어-->
                	   
                           
                           
                    <section id="guidelList_notcomp" class=" guideReservationList_notcomp board_tabcontent">
                        
                        <c:forEach items="${guideGuideRservationListInfo}" var="gudieTourInfo">
                        	<c:if test="${gudieTourInfo.tourBasicVo.tour_complete == 'n'}">
                        	
                        		 <div class="task container-fluid">
                                	<div class="title guidelList_content col-4">${gudieTourInfo.tourBasicVo.tour_intro}</div>
                                	<div class="task_div"></div>
                                	<div class="region guidelList_content col-2">${gudieTourInfo.tourBasicVo.tour_tourspot}</div>
                                	<div class="task_div"></div>
                                	<div class="date guidelList_content col-2">
                                		<fmt:parseDate var="tourdate" value="${gudieTourInfo.tourBasicVo.tour_tourdate}" pattern="yyyy-MM-dd"/>
                                		<fmt:formatDate value="${tourdate}" pattern="yyyy-MM-dd" /> 
                                	</div>
                                	<div class="task_div"></div>
                                	<div class="max_participate guidelList_content col-2">(${gudieTourInfo.sumParticipate}/${gudieTourInfo.tourBasicVo.tour_max_number})</div>
                                	<a href="./guideReservationPeaplePage?tour_idx=${gudieTourInfo.tourBasicVo.tour_idx}" class="n_guide_arrow col-2 watch_reservationList"><div>신청자 보기</div><i class="fas fa-chevron-right "></i></a>
                            	</div>
                        	</c:if>
                        	
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