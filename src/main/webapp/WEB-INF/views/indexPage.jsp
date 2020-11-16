<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>index</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"> 
    <link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
    <style>
        body{
            top:0;
            margin:0;
            padding:0;
            /* background: url("https://cdn.pixabay.com/photo/2018/03/06/03/56/cyclist-3202481_960_720.jpg") no-repeat center center fixed; */
            background: url("https://cdn.pixabay.com/photo/2014/06/18/13/24/people-371230_960_720.jpg") no-repeat center center fixed;
            -webkit-background-size: cover; 
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;  
        }
    </style>
    <link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script&display=swap" rel="stylesheet">
</head>
<body class="indexPage_body">

    <!--메인페이지indexPage-->
        
        <c:choose>
      		<c:when test="${empty memberSession }">
      			<header>
            		<div class="header_wrapper indexPage_headerWrapper">
                		<a href="./indexPage">
                    		<div class="header_column1">
                       			<img src="MainImages/logo3.gif" alt="로고">
                       			<div class="header-web_name">GuideForYou</div>
                    		</div>
                		</a>
                		<div class="header_column2">
                    		<a href="./loginPage" class="headerWhenNotLogin headerWhenNotLogin_first login-blackLine_first">
                        		<div class="header-login blackText">로그인</div>
                    		</a>
                    		<a href="./joinMemberPage" class="headerWhenNotLogin login-blackLine_second">
                        		<div class="header-join blackText">회원가입</div>
                    		</a>
                		</div>
            		</div>
        		</header>
      		</c:when>
      		<c:otherwise>
      			<header>
                	<div class="header_wrapper indexPage_headerWrapper">
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
                        				<img alt="member_profile_photo" class="header_memberProfilePhoto" src="${memberSession.member_profile_photo }">
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
    	

        <main class="indexPage_main">
            <!--메인문구-->
            <section class="indexPage_main-text">
                " 익숙한 삶에서 벗어나 현지인들을 만나는 여행은, 생각의 근육을 단련하는 비법이다. "
            </section>
            <!--카테고리 영역-->
            <section class="indexPage_main-categoryBox">
                <div class="indexPage_main-categoryText">Category</div>
                <div class="indexPage_main-categoryBox_localBox">
                    <a href="./kindOfLocalPage?location_idx=1"><!--location_idx넘겨줄것!-->
                        <div class="indexPage-local_text">
                            #서울  
                        </div>
                    </a>
                    <a href="./kindOfLocalPage?location_idx=2"><!--local_idx넘겨줄것!-->
                        <div class="indexPage-local_text">
                            #경기  
                        </div>
                    </a>
                    <a href="./kindOfLocalPage?location_idx=3"><!--local_idx넘겨줄것!-->
                        <div class="indexPage-local_text">
                            #강원  
                        </div>
                    </a>
                    <a href="./kindOfLocalPage?location_idx=4"><!--local_idx넘겨줄것!-->
                        <div class="indexPage-local_text">
                            #충청  
                        </div>
                    </a>
                    <a href="kindOfLocalPage?location_idx=5"><!--local_idx넘겨줄것!-->
                        <div class="indexPage-local_text">
                            #전라  
                        </div>
                    </a>
                    <a href="./kindOfLocalPage?location_idx=6"><!--local_idx넘겨줄것!-->
                        <div class="indexPage-local_text">
                            #경상  
                        </div>
                    </a>
                    <a href="./kindOfLocalPage?location_idx=7"><!--local_idx넘겨줄것!-->
                        <div class="indexPage-local_text">
                            #제주  
                        </div>
                    </a>
                </div>
            </section>
        </main>

         <footer>
            <div class="footer_column1"></div>
            <div class="footer_column2">
                <div class="footer-customerCenter">고객센터</div>
                <div class="footer-community">커뮤니티</div>
            </div>
        </footer> 

</body>
</html>