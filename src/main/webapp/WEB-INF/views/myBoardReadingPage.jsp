<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>내 게시글</title>
	
    <script>
            function openBoard(evt, cityName) {
              var i, tabcontent, tablinks;
              tabcontent = document.getElementsByClassName("board_tabcontent");
              for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
              }
              tablinks = document.getElementsByClassName("myBoardReading_main_tablinks");
              for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
              }
              document.getElementById(cityName).style.display = "block";
              evt.currentTarget.className += " active";
            }
    </script>
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
        
        <main class="myBoardReading_main">
            <section class="myBoardReading_main_section">
                <div class="myBoardReading_main_header">내 게시글</div>
                <div class="myBoardReading_main_tab">
                    <button class="myBoardReading_main_tablinks" onclick="openBoard(event, 'current_board')">현재 게시물</button>
                    <div class="tablinks_divide"></div>
                    <button class="myBoardReading_main_tablinks" onclick="openBoard(event, 'past_board')">과거 게시물</button>
                </div>
                
                
                
                
                <!-- 현재게시물 -->
                <div id="current_board" class="myBoardReading_main_current board_tabcontent">
                    <div class="myBoardReading_main_current_column">
                        <!--현재투어 정보 입니다 4개가 1묶음 입니다-->
                        
                        
                        <c:forEach items="${guideMypageTourList}" var="currentList">
                      
                        	<c:if test="${currentList.tour_complete == 'n'}">
                        		<div class="main_current_column card" style="width: 23.4em;">
                        		
                        			<c:choose>
                        				<c:when test="${currentList.tour_photo1 == null}">
                        					<a href="./tourGuideContentPage?tour_idx=${currentList.tour_idx}">
                            					<img src="myPageImg/kijoimg1.jpg" class="main_current_column_img">
                            				</a>
                        				</c:when>
                        				<c:otherwise>
                        					<a href="./tourGuideContentPage?tour_idx=${currentList.tour_idx}">
                            					<img src="#" class="main_current_column_img"><!-- 데이터 베이스 에서 링크 가져오기 -->
                            				</a>
                        				</c:otherwise>
                        			</c:choose>
                        			
                            		<div class="main_current_column_title card-body">
                                		<h4 class="card-text">${currentList.tour_intro}</h4>
                            		</div>
                        		</div>
                        	
                        	</c:if>
                        	
                        </c:forEach>
                   
                    </div>
                    
                </div>
            

	<!-- 과거 -->
                <div id="past_board" class="myBoardReading_main_past board_tabcontent">
                        <div class="myBoardReading_main_current_column">
                                <!--과거투어 정보 입니다 4개가 1묶음 입니다-->
                                
                                <c:forEach items="${guideMypageTourList}" var="currentList">
                                	<c:if test="${currentList.tour_complete == 'y'}">
                                		<div class="main_current_column card past" style="width: 23.4em;">
                                	<c:choose>
                        				<c:when test="${currentList.tour_photo1 == null}">
                        					<a href="./tourGuideContentPage?tour_idx=${currentList.tour_idx}">
                                    			<img src="myPageImg/basic_img.jpg" class="main_current_column_img">
                                    		</a>
                        				</c:when>
                        				<c:otherwise>
                        					<a href="./tourGuideContentPage?tour_idx=${currentList.tour_idx}">
                            					<img src="#" class="main_current_column_img"><!-- 데이터 베이스 에서 링크 가져오기 -->
                            				</a>
                        				</c:otherwise>
                        			</c:choose>
                                		
                                    		<div class="main_current_column_title card-body">
                                        		<h4 class="card-text">${currentList.tour_intro}</h4>
                                    		</div>
                               			 </div>
                                	
                                	</c:if>
                                </c:forEach>
                         	</div>
                </div>
                
                

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