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
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>checkPasswordPage</title>

<script type="text/javascript">
    		
    	
    		
   		function comparePw() {
   			
   			console.log("비밀번호 중복 체크");
   			
   			var params = $('#form3').serialize();
   			
   			console.log(params);
   			
   			$.ajax({
   				dataType : "json",
   				type : "post",
   				url : "./rest_checkPasswordAction",
   				data : params,
   				success : function(result) {

   					if (result.pwExit == true) {
   						
   						location.href="./editProfilePage";
   						
   					} else {
   						
   						alert("비밀번호가 일치하지 않습니다-");
   						$('#checkPw').val('');
   					}

   				}
   			});
			


   		}
   		
   		$(document).ready(function() {
            $("#checkPw").keydown(function(key) {
                if (key.keyCode == 13) {
                	 event.preventDefault();
                	   document.getElementById("checkPassword-main-btn").click();
                }
            });
        });




   	
   			
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
        
        
        
         <main class="checkPassword-main">
             <div class="checkPassword_main_top">비밀번호 확인</div>
             <form id="form3" name="form3" class="checkPasswordPageForm"  method="post">
                    <div class="checkPasswordPage_text">개인정보 수정을 위해 비밀번호를 입력하세요</div>

                <div class="checkPasswordPage_password">
                        <input type="password" id="checkPw" class="checkPasswordPage_input" name="member_pw">
                    </div>        
                <button type="button" id="checkPassword-main-btn" class="checkPasswordPage_button" onclick="comparePw()">확인</button>               

             </form>    
         </main>   
        

</body>
</html>         