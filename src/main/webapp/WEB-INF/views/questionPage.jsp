<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<고객센터 글작성 페이지>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>tourEnrollPage</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
        <style>
            .questionBoardPage_body {
                font-size: 16px;
            }

            .questionBoardPage_main {
                width: 600px;
                margin: 0 auto;
                display: flex;
                flex-direction: column;
                margin-bottom: 230px;
            }

            .questionBoardPage_main-top {
                display: flex;
                justify-content: start;
                align-items: center;
                margin-bottom: 20px;
                font-size: 5em;
                color: white;
                font-family: 'East Sea Dokdo', cursive;
            }

            .questionBoardPage_main-form {
                width: 80%;
                margin: 0 auto;
                background-color: rgba(165, 151, 151, 0.438);
                display: flex;
                flex-direction: column;
                align-items: center;
                padding: 40px 60px;
                border-radius: 5px;
            }

            .questionBoardPage_main-text {
                font-size: 0.9em;
                color: white;
            }

            .questionBoardPage_main-input {
                color: white;
                font-size: 0.95em;
            }

            .questionBoardPage_main-form_inputBox input {
                padding: 5px 10px;
                border-radius: 5px;
                text-decoration: none;
                border: none;
                width: 45%;
                font-weight: bolder;
                color: black;
            }

            .questionBoardPage_main-form_inputBox select {
                width: 50%;
                padding: 5px 10px;
                border-radius: 5px;
                text-decoration: none;
                border: none;
                font-weight: bolder;
                color: black;
            }

            .questionBoard_content_text {
                margin-bottom: 20px;
                font-size: 0.9em;
                color: white;
            }

            .questionBoard_content {
                align-items: flex-start;
            }

            .questionBoard_content-questionTitle {
                resize: none;
                width: 500px;
                height: 50px;
                justify-content: end;
                padding: 10px 10px;
                border-radius: 5px;
                text-decoration: none;
                border: none;
                font-weight: bolder;
                color: black;
            }

            .questionBoard_content-questionContent {
                resize: none;
                width: 500px;
                height: 400px;
                padding: 10px 10px;
                border-radius: 5px;
                text-decoration: none;
                border: none;
                font-weight: bolder;
                color: black;
            }

            .questionBoardPage_main_photo-text {
                margin-bottom: 15px;
                color: white;
            }

            .questionBoardPage_main-photoBox {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                margin-bottom: 100px;
            }

            .questionPhoto_input {
                margin-bottom: 10px;
                color: white;
            }

            .questionPhoto_alert {
                font-size: 0.7em;
                color: rgba(250, 250, 250, 0.7);
            }

            .questionBtn {
                width: 100%;
                border-radius: 30px;
                padding: 13px 0;
                background-color: rgb(160, 223, 186);
                color: black;
                border: none;
                margin-bottom: 20px;
                cursor: pointer;
            }


            body {
                top: 0;
                margin: 0;
                padding: 0;
                background: url("https://cdn.pixabay.com/photo/2019/10/26/11/15/night-photograph-4579193_960_720.jpg") no-repeat center center fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }
        </style>
    </head>

    <body class="questionBoardPage_body">
        <!-- 고객센터 질문 작성 페이지 -->

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

        <main class="questionBoardPage_main">
            <div class="questionBoardPage_main-top">
                Q&A
            </div>

            <form action="#" method="post">
                <div class="questionBoardPage_main-form">
                    <div class="questionBoardPage_main-form_inputBox">
                        <!-- 가이드의 member_idx 넘겨주기-->
                        <input name="#" value="#" type="hidden">
                        <div class="questionBoardPage_main-form_inputBox">

                            <div class="questionBoardPage_main-text">닉네임</div>
                            <div class="questionBoardPage_main-input">
                                <div id="member_nick"></div>
                                <div id="member_nick"></div>
                            </div>
                        </div>

                        <div class="questionBoardPage_main-form_inputBox questionBoard_content">
                            <!--question_title-->
                            <div class="questionBoard_content_text">제목</div>
                            <textarea name="#" placeholder="제목" class="questionBoard_content-questionTitle"></textarea>
                        </div>
                        <div class="questionBoardPage_main-form_inputBox questionBoard_content">
                            <!--question_Content-->
                            <div class="questionBoard_content_text">질문 내용</div>
                            <textarea name="#" placeholder="50자 내외" class="questionBoard_content-questionContent"></textarea>
                        </div>

                        <!--투어 사진 넘겨주기-->
                        <div class="questionBoardPage_main_photo-text">사진등록</div>
                        <div class="questionBoardPage_main-photoBox">
                            <div class="questionPhoto_input">---사진 등록하는것 집어넣기---</div>
                            <div class="questionPhoto_alert">※ 사진은 최대 5장 업로드 가능합니다.</div>
                        </div>
                    </div>
                    <button type="submit" class="questionBtn">질문하기</button>
                </div>
            </form>
        </main>

        <div>--------footer--------</div>


    </body>

    </html>