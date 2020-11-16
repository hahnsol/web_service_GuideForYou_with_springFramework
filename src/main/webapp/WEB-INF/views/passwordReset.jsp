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
    <title>passwordReset</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style>
      
        body{ top:0;
            margin:0;
            padding:0;
            background: url("./login_css/images/loginPageBackground.jpg") no-repeat center center fixed;
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            }
    </style>
    
    <script type="text/javascript">
    		
   		function findPw() {
   			
   			console.log("비밀번호 체크실행");

   			var params = $('#form2').serialize();
   			
   			console.log(params);
   			
   			$.ajax({
   				dataType : "json",
   				type : "post",
   				url : "./rest_pwReset",
   				data : params,
   				success : function(result) {

   					if (result.pwExit == true) {
   						
   						alert(result.emailResult+" 로 임시 비밀번호를 전송하였습니다");
   						location.href="./loginPage";
   						
   					} else {
   						
   						alert("입력하신 정보가 없습니다. 다시 입력해주세요!");
   						$('#member_id').val('');
   						$('#member_id').focus();
   						$('#member_name').val('');
   						$('#member_email').val('');
   					}

   				}
   			});
			
   		}

   </script>
   
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

<main class="PasswordReset-main">
    <div class="idPasswordReset-top-text">비밀번호 찾기</div>
            
    <form id="form2" method="post" name="form2" class="passwordReset-Form">

        <div  class="passwordResetbox_colum">
            <div class="PasswordReset-text">아이디</div>
            <input type="text" id="member_id" name="member_id" class="PasswordReset-input">
         </div> 
                    
        <div  class="passwordResetbox_colum">
            <div class="PasswordReset-text">이름</div>
            <input type="text" id="member_name" name="member_name" class="PasswordReset-input">
        </div> 
                    
        <div  class="passwordResetbox_colum">
            <div class="PasswordReset-text">이메일</div>
            <input type="email"  id="member_email" name="member_email" placeholder="example@gmail.com" class="PasswordReset-input">
        </div>

        <button type="button" class="passwordreset_button" onclick="findPw()">비밀번호찾기</button>
    </form>
 </main>

    <footer>
        푸터입니다.
    </footer>
</div>
</body>
</html>