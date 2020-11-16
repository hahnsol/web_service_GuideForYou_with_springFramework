<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/login_css/loginGlobals.css">
<link
	href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<title>joinMemberPage</title>
<style>
body {
	top: 0;
	margin: 0;
	padding: 0;
	background: url("./login_css/images/loginPageBackground.jpg") no-repeat
		center center fixed;
	background-size: cover;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>

<script>


	var a = false;
	var b = false;
	
	function go_submit(){
		if(a==false){ 
			alert("아이디 중복확인을 해주세요") 
		} 
		else {
			if(b==false){
				alert("닉네임 중복확인을 해주세요")
			}else{
				var formData = $('#frm1').serialize();

				console.log(formData);
				
				$.ajax({
					dataType : "json",
					type : "post",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					url : "./joinMemberAction",
					data : formData,
					success : function(result) {

						console.log(result);
						if (result.valid == true) {
							
							alert("회원가입이 되었습니다");
							location.href="./loginPage";
							
						} else {
							alert(result.emptySpace+" 를 확인해주세요");
						}

					}
				});
			}
		}
	}
	
	
	function confirmId_JQuery() {
		console.log("아이디중복체크실행");

		//var id = document.getElementById("member_id").value;
		var id = document.getElementsByName("member_id")[0].value;

		if(id == ''){
			alert("아이디를 입력해주세요")
			$('#member_id_check').val('');
			$('#member_id_check').focus();
			console.log(id);
		}
		else{
			console.log(id);
			$.ajax({
				dataType : "json",
				type : "post",
				url : "./confirmId",
				data : "id=" + id,
				success : function(result) {

					if (result.existId == true) {
						
						alert("이미 존재하는 아이디 입니다");
						$('#member_id_check').val('');
						$('#member_id_check').focus();
						
					} else {
						
						alert("사용 가능한 아이디 입니다");
						a=true;
					}

				}
			});
		}
		

	}
	
	//아이디 inpu창  적고 엔터 쳤을경우  값이  날아가느 걸 방지
	$(document).ready(function() {
        $("#member_id_check").keydown(function(key) {
            if (key.keyCode == 13) {
            	 event.preventDefault();
            	   document.getElementById("idCheck").click();
            }
        });
    });
	
	

</script>

<script>
	function confirmNick_JQuery() {
		console.log("닉네임중복체크실행");

		var nick = document.getElementsByName("member_nick")[0].value;
	
		console.log(document.getElementsByName("member_nick")[0].value);
		console.log(document.getElementsByName("member_id")[0].value);
		
		if(nick == ''){
			
		}
		
		$.ajax({
			dataType : "json",
			type : "post",
			url : "./confirmNick",
			data : "nick=" + nick,
			success : function(result) {

				if (result.existNick == true) {
					
					alert("이미 존재하는 닉네임 입니다");
					$('#member_nick_check').val('');
					$('#member_nick_check').focus();
					
				} else {
					
					alert("사용 가능한 닉네임 입니다");
					b=true;
				}

			}
		});

	}

	
	//닉네임 inpu창  적고 엔터 쳤을경우  값이  날아가느 걸 방지
	$(document).ready(function() {
        $("#member_nick_check").keydown(function(key) {
            if (key.keyCode == 13) {
            	 event.preventDefault();
            	   document.getElementById("nickCheck").click();
            }
        });
    });
	

</script>


<script>
//비밀번호 확인
	$(function passwordCheck() {

		$('#pw2').blur(function() {
			if ($('#pw').val() != $('#pw2').val()) {
				if ($('#pw2').val() != '') {
					alert("비밀번호가 일치하지 않습니다");
					$('#pw2').val('');
					$('#pw2').focus();
				}
			}
		})
	});
	
	
	
	
	 $(function() {  
	        $( '#birthDate' ).datepicker({ 
	            dateFormat: "yy-mm-dd",    /* 날짜 포맷 */ 
	            prevText: '이전 달', 
	            nextText: '다음 달', 
	            changeMonth: true,        /* 월 선택박스 사용 */ 
	            changeYear: true,        /* 년 선택박스 사용 */ 
	            showOtherMonths: true,    /* 이전/다음 달 일수 보이기 */ 
	            selectOtherMonths: true,    /* 이전/다음 달 일 선택하기 */ 
	           
	            closeText: '닫기', 
	            showMonthAfterYear: true,        /* 년과 달의 위치 바꾸기 */ 
	            /* 한글화 */ 
	            monthNames : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], 
	            monthNamesShort : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], 
	            dayNames : ['일', '월', '화', '수', '목', '금', '토'],
	            dayNamesShort : ['일', '월', '화', '수', '목', '금', '토'],
	            dayNamesMin : ['일', '월', '화', '수', '목', '금', '토'],
	            showAnim: 'slideDown', 
	            maxDate: 'c',
	            yearRange : 'c-75:c'
	            
	            
	                  /* 날짜 유효성 체크 */ 
	           
	        }); 
	    });
</script>

</head>
<body>
	
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


		<main class="joinMember_main">
		<div class="joinMember_main_top">회원가입</div>

		<form id="frm1" class="joinMemberForm" action="" method="POST">
			<!-- 클래스 공통으로 이름맞추기 띄어쓰고 하나 더 클래스 이름을 쓰면 클래스 이름이 2개가 됨
                     그래서 공통이름 클래스로 공통css 틀잡고 클래스 다른이름으로 세부 css로 사용한다.-->
			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">아이디</div>
				<input type="text" class="joinMemberForm-input" name="member_id" id="member_id_check"
					required>
				<div class="joinMemberForm_doubleCheck" id="idCheck" onclick="confirmId_JQuery()">
					중복확인</div>
			</div>

			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">비밀번호</div>
				<input type="password" id="pw" class="joinMemberForm-input" name="member_pw"
					required>
				<div class="joinMemberForm-empty"></div>
			</div>

			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">비밀번호확인</div>
				<input type="password" id="pw2" class="joinMemberForm-input" name="#"
					required>
				<div class="joinMemberForm-empty"></div>
			</div>

			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">이름</div>
				<input type="text" class="joinMemberForm-input" name="member_name"
					required>
				<div class="joinMemberForm-empty"></div>
			</div>

			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">닉네임</div>
				<input type="text" class="joinMemberForm-input"
					placeholder="특수기호 입력불가" name="member_nick" id="member_nick_check" required>
				<div class="joinMemberForm_doubleCheck"  id="nickCheck"
					onclick="confirmNick_JQuery()">중복확인</div>
			</div>

			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">휴대전화</div>
				<input type="text" placeholder="공백없이 번호입력"
					class="joinMemberForm-input" name="member_phone" required>
				<div class="joinMemberForm-empty"></div>
			</div>

			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">연락수단</div>
				<input type="text" placeholder="카카오톡/휴대폰"
					class="joinMemberForm-input" name="member_kakao" required>
				<div class="joinMemberForm-empty"></div>
			</div>

			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">생년월일</div>
				<input type="text" placeholder="생년월일6자리" id="birthDate"
					class="joinMemberForm-input" name="member_age" required>
				<div class="joinMemberForm-empty"></div>
			</div>

			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">성별</div>
				<select name="member_gender" class="joinMemberForm_select">
					<option value="여성">여성</option>
					<option value="남성">남성</option>
				</select>
				<div class="joinMemberForm-empty"></div>
			</div>

			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">거주지역</div>
				<select name="member_address" class="joinMemberForm_select">거주지역
					<option value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="강원">강원</option>
					<option value="충청">충청</option>
					<option value="전라">전라</option>
					<option value="경상">경상</option>
					<option value="제주">제주</option>
				</select>
				<div class="joinMemberForm-empty"></div>
			</div>

			<div class="joinMemberForm_column">
				<div class="joinMemberForm-text">이메일</div>
				<input name="member_email" type="email"
					placeholder="example@gmail.com" class="joinMemberForm-input"
					required>
				<div class="joinMemberForm-empty"></div>
			</div>



			<button type="button" class="joinMemberFrom_button" onclick="go_submit()">회원가입하기</button>
			<!--버튼 안먹으면 input submit으로 수정-->
		</form>


		</main>


		<footer> 푸터입니다 </footer>

</body>

</html>