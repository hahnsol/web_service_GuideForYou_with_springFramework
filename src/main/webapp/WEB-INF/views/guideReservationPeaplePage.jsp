<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>가이드 투어예약 신청자 내역 페이지 </title>
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
            
        
            <main class="guideReservationPeaple_main">
                    <div class="guideReservationList_main_title">투어신청자 확인</div>
    
    				  <div class="discribe_title">
                    		<div class="guideReservationList_main_tab">
                        		<button class="guideReservationList_main_tablinks" onclick="openBoard(event, 'guide_party_b')">신청자</button>
                        		<div class="guideReservationList_main_div"></div>
                        		<button class="guideReservationList_main_tablinks" onclick="openBoard(event, 'guide_party_y')">확정자</button>
                        		<div class="guideReservationList_main_div"></div>
                        		<button class="guideReservationList_main_tablinks" onclick="openBoard(event, 'guide_party_n')">거절자</button>
                    		</div>
                    		<div class="task container-fluid guide_navigation ">
                    			<div class="guide_nav title guidelList_content col-2"></div>
                            	<div class="guide_nav title guidelList_content col-3">참여자</div>
                            	<div class="task_div"></div>
                            	<div class="guide_nav region guidelList_content col-3"> 평점</div>
                            	<div class="task_div"></div>
                            	<div class="guide_nav date guidelList_content col-3">신청 인원수</div>
                            	<div class="guide_nav title guidelList_content col-1"></div>
                  			</div>
                    
    				</div>
                  
                	
                
              
                    
                   	 <!--신청 보류자 리스트-->
                    	
                    <section id="guide_party_b" class=" guideReservationList_notcomp board_tabcontent">
                      <c:forEach items="${guideRCE}" var="rce">
                    	 <c:if test="${rce.reservationBasicVo.reservation_confirm == 'b'}">
                            <div class="task container-fluid">
                                <div class="col-1">
                                	
                                	<c:choose>
                                		<c:when test="${rce.memberBasicVo.member_profile_photo == 'n' }">
                                			<a href="./credit_infoPage?member_idx=${rce.memberBasicVo.member_idx}" class="guideReservation_photo_column ">
                                        		<img src="myPageImg/basic_img.jpg" class="guideReservation_photo">
                                    		</a>  
                                		</c:when>
                                		
                                		<c:otherwise>
                                			<a href="./credit_infoPage?member_idx=${rce.memberBasicVo.member_idx}" class="guideReservation_photo_column ">
                                        		<img src="${rce.memberBasicVo.member_profile_photo}" class="guideReservation_photo">
                                    		</a>  
                                		</c:otherwise>
                                	</c:choose>
                                </div> 
                                <div class="title guidelList_content col-4">${rce.memberBasicVo.member_nick}</div>
                                <div class="guidelList_task_div "></div>
                                <div class="region guidelList_content col-3"> <img src="myPageImg/star-on-small.png" class="review_bottom_column_star_img">${rce.sumCustomerScore}</div>
                                <div class="guidelList_task_div "></div>
                                <c:choose>
                                	<c:when test="${rce.reservationBasicVo.reservation_participate == null }">
                                		<div class="date guidelList_content col-2">null</div>
                                	</c:when>
                                	<c:otherwise>
                                		<div class="date guidelList_content col-2">${rce.reservationBasicVo.reservation_participate }</div>
                                	</c:otherwise>
                                </c:choose>
                                <div class="guidelList_task_div "></div>
                                <a href="./guideTourReservationCheckPage?reservation_idx=${rce.reservationBasicVo.reservation_idx}" class="n_guide_arrow col-2 watch_reservationList"><div>예약신청서 보기</div><i class="fas fa-chevron-right "></i></a>
                            </div>
                         </c:if>
                       </c:forEach>
                   </section>
                   
                    
                     <!--신청 확정 리스트-->
                    
                   <section id="guide_party_y" class="guideReservationList_comp board_tabcontent">
                      <c:forEach items="${guideRCE}" var="rce">
                    	  <c:if test="${rce.reservationBasicVo.reservation_confirm == 'y'}">
                            <div class="task container-fluid">
                                <div class="col-1">
                                    <c:choose>
                                		<c:when test="${rce.memberBasicVo.member_profile_photo == 'n' }">
                                			<a href="./credit_infoPage?member_idx=${rce.memberBasicVo.member_idx}" class="guideReservation_photo_column ">
                                        		<img src="myPageImg/basic_img.jpg" class="guideReservation_photo">
                                    		</a>  
                                		</c:when>
                                		
                                		<c:otherwise>
                                			<a href="./credit_infoPage?member_idx=${rce.memberBasicVo.member_idx}" class="guideReservation_photo_column ">
                                        		<img src="${rce.memberBasicVo.member_profile_photo}" class="guideReservation_photo">
                                    		</a>  
                                		</c:otherwise>
                                	</c:choose> 
                                </div> 
                                <div class="title guidelList_content col-4">${rce.memberBasicVo.member_nick}</div>
                                <div class="guidelList_task_div "></div>
                                <div class="region guidelList_content col-3"><img src="myPageImg/star-on-small.png" class="review_bottom_column_star_img">${rce.sumCustomerScore}</div>
                                <div class="guidelList_task_div "></div>
                               <c:choose>
                                	<c:when test="${rce.reservationBasicVo.reservation_participate == null }">
                                		<div class="date guidelList_content col-2">null</div>
                                	</c:when>
                                	<c:otherwise>
                                		<div class="date guidelList_content col-2">${rce.reservationBasicVo.reservation_participate }</div>
                                	</c:otherwise>
                                </c:choose>
                                <div class="guidelList_task_div "></div>
                                <a href="./guideTourReservationCheckPage?reservation_idx=${rce.reservationBasicVo.reservation_idx}" class="n_guide_arrow col-2 y_watch_reservationList"><div>예약신청서 보기</div><i class="fas fa-chevron-right "></i></a>
                            </div>
                        
    
                          </c:if>
                       </c:forEach>
                    </section>
                    
                    
                      <!--신청 거절 리스트-->
                    
                    <section id="guide_party_n" class="guideReservationList_comp board_tabcontent">
                      <c:forEach items="${guideRCE}" var="rce">
                        <c:if test="${rce.reservationBasicVo.reservation_confirm == 'n'}">
                        <div class="task container-fluid">
                            <div class="col-1">
                                <c:choose>
                                		<c:when test="${rce.memberBasicVo.member_profile_photo == 'n' }">
                                			<a href="./credit_infoPage?member_idx=${rce.memberBasicVo.member_idx}" class="guideReservation_photo_column ">
                                        		<img src="myPageImg/basic_img.jpg" class="guideReservation_photo">
                                    		</a>  
                                		</c:when>
                                		
                                		<c:otherwise>
                                			<a href="./credit_infoPage?member_idx=${rce.memberBasicVo.member_idx}" class="guideReservation_photo_column ">
                                        		<img src="${rce.memberBasicVo.member_profile_photo}" class="guideReservation_photo">
                                    		</a>  
                                		</c:otherwise>
                                	</c:choose> 
                            </div> 
                            <div class="title guidelList_content col-4">${rce.memberBasicVo.member_nick}</div>
                            <div class="guidelList_task_div "></div>
                            <div class="region guidelList_content col-3"><img src="myPageImg/star-on-small.png" class="review_bottom_column_star_img">${rce.sumCustomerScore}</div>
                            <div class="guidelList_task_div "></div>
                            <c:choose>
                                	<c:when test="${rce.reservationBasicVo.reservation_participate == null }">
                                		<div class="date guidelList_content col-2">null</div>
                                	</c:when>
                                	<c:otherwise>
                                		<div class="date guidelList_content col-2">${rce.reservationBasicVo.reservation_participate }</div>
                                	</c:otherwise>
                                </c:choose>
                            <div class="guidelList_task_div "></div>
                            <a href="./guideTourReservationCheckPage?reservation_idx=${rce.reservationBasicVo.reservation_idx}" class="n_guide_arrow col-2 watch_reservationList"><div>예약신청서 보기</div><i class="fas fa-chevron-right "></i></a>
                        </div>
                        </c:if>
                      </c:forEach>
                   </section>
                    
                    
                    
                </main>
    
        
               
        
        
                <footer class="common_footer">공통 footer ui를 넣을 겁니다</footer>

                <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
            </div>
        </div>
</body>
</html>