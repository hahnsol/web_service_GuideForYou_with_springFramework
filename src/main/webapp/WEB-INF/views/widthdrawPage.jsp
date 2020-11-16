<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login_css/loginGlobals.css">
    <link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <title>widthdrawPage</title>
    <style>
      
        body{ top:0;
            margin:0;
            padding:0;
            background: url("./login_css/images/backgroundimage3.jpg") no-repeat center center fixed;
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            }
    </style>
</head>
<body>
<div class="back-shadow">
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

    <main class="withdrawPage_main">
        <div class="withdrawPage-main-top">
            회원탈퇴
        </div>    
        
        <div class="withdrawForm">
            <div class="withdrawPage-main-top-text">
                유의사항을 확인하시고 탈퇴 신청을 해주세요 
             </div>
            <div class="withdrawtextbox">
                    회원탈퇴를 하시면 아이디로 가입된 모든 서비스를 사용하실 수 없습니다.<br>
                    또한 아이디로 서비스를 가입/사용 하시면서 축적된 정보 및 기록은
                    탈퇴일 기준으로 두달 후정상 삭제됩니다. 
            </div>
            <form class="withdrawbuttons" action="/withdrawAction" method="get">
                <a href="./indexPage"><div class="withdrawButton_cancel">취소하기</div></a>
                <!-- sessionIdx랑 member_quit, member_quitDate 파라미터로 넘어감-->
                <a href="./withdrawAction"><div class="withdrawButton_confirm">탈퇴하기</div></a>
            </form>



    </div>    
    



    </main>    
    <footer>
        푸터입니다.
    </footer>    
    
</div>
</body>
</html>         
<!--메인은 무조건 600px 안에 폼은 80%-->