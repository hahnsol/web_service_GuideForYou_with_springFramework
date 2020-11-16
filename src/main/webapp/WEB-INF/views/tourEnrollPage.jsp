<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>tourEnrollPage</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo&display=swap" rel="stylesheet">

    
    
    <script>
        $(document).ready (function () {                
            $('.btnAdd').click (function () {                                        
                $('.buttons').append (                        
                    '<input type="file" name="files"> <input type="button" class="btnRemove" value="Remove"><br>'                    
                ); // end append                            
                $('.btnRemove').on('click', function () { 
                    $(this).prev().remove (); // remove the textbox
                    $(this).next ().remove (); // remove the <br>
                    $(this).remove (); // remove the button
                });
            }); // end click                                            
        }); // end ready 
        
        	
    </script>
    
    <script >
    
    
    $(function() {  
        $( "#toDate" ).datepicker({ 
            dateFormat: "yy-mm-dd",    /* 날짜 포맷 */ 
            prevText: 'prev', 
            nextText: 'next', 
            showButtonPanel: true,    /* 버튼 패널 사용 */ 
            changeMonth: true,        /* 월 선택박스 사용 */ 
            changeYear: true,        /* 년 선택박스 사용 */ 
            showOtherMonths: true,    /* 이전/다음 달 일수 보이기 */ 
            selectOtherMonths: true,    /* 이전/다음 달 일 선택하기 */ 
           
            minDate: '0', 
            closeText: '닫기', 
            showMonthAfterYear: true,        /* 년과 달의 위치 바꾸기 */ 
            /* 한글화 */ 
            monthNames : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], 
            monthNamesShort : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], 
            dayNames : ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesShort : ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesMin : ['일', '월', '화', '수', '목', '금', '토'],
            showAnim: 'slideDown', 
                  /* 날짜 유효성 체크 */ 
           
        }); 
    });
    
    	
    </script>
    <style>
        body{
            top:0;
            margin:0;
            padding:0;
            background: url("https://cdn.pixabay.com/photo/2015/07/13/14/40/paris-843229_960_720.jpg") no-repeat center center fixed; 
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;  
        }
        
        .tourEnrollPage_body{
    		font-size: 16px;
		}

.tourEnrollPage_main{
    width:600px;
    margin:0 auto;
    display: flex;
    flex-direction: column;
    margin-bottom: 230px;
}

.tourEnrollPage_main-top{
    display: flex; 
    justify-content: start;
    align-items: center;
    margin-bottom: 20px;
    font-size:2em;
    color:white;
    font-family: 'East Sea Dokdo', cursive;
}

.tourEnrollPage_main-form{
    width:80%;
    margin:0 auto;
    background-color: rgba(185, 173, 173, 0.3);
    display: flex;
    flex-direction: column;
    align-items: center;
    padding:40px 60px;
    border-radius: 5px;
}

.tourEnrollPage_main-form_inputBox{
    width:100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 40px;
}

.tourEnrollPage_main-text{
    font-size: 0.9em;
    color:white;
}

.tourEnrollPage_main-input{
    color:white;
    font-size: 0.95em;
}

.tourEnrollPage_main-form_inputBox input{
    padding:5px 10px;
    border-radius: 5px;
    text-decoration: none;
    border:none;
    width:45%;
    font-weight: bolder;
    color:black;
}

.tourEnrollPage_main-form_inputBox select{
    width:50%;
    padding:5px 10px;
    border-radius: 5px;
    text-decoration: none;
    border:none;
    font-weight: bolder;
    color:black;
}

.tourEnroll_content_text{
    margin-bottom: 20px;
    font-size: 0.9em;
    color:white;
}

.tourEnroll_content{
    align-items: flex-start;
}

.tourEnroll_content-tourTile{
    resize: none;
    width:250px;
    height:70px;
    justify-content: end;
    padding: 10px 10px;
    border-radius: 5px;
    text-decoration: none;
    border:none;
    font-weight: bolder;
    color:black;
}

.tourEnroll_content-tourContent{
    resize:none;
    width:245px;
    height: 200px;
    padding: 10px 10px;
    border-radius: 5px;
    text-decoration: none;
    border:none;
    font-weight: bolder;
    color:black;
}

.tourEnrollPage_main-form_Photo {
    width:100%;
    display: flex;
    flex-direction: column;
}

.tourEnrollPage_main_photo-text{
    margin-bottom: 50px;
    color:white;
}

.tourEnrollPage_main-photoBox{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-bottom:100px;
}

.tourPhoto_input{
    margin-bottom: 10px;
    color:white;
    
}

.tourPhoto_input>label{
    background-color: rgb(54, 53, 53);
    color:#fff;
    position: relative;
    cursor: pointer;
    display: inline-block;
    vertical-align: middle;
    overflow: hidden;
    width:70px;
    height:15px;
    text-align: center;
    font-size: 0.7em;
    border-radius: 3px;
    padding:3px 0;
    align-items: center;
    border: 1px solid #fff;
}

.tourPhoto_input>input{
    vertical-align: middle;
    display: inline-block;
    width: 270px;
    height:15px;
    font-size:0.5em;
    border-radius: 3px;
    border:1px solid rgb(54, 53, 53);
    text-decoration: none;
    padding:3px 0;
    margin-right: 3px;
}

.tourPhoto_input>input:focus{
    vertical-align: middle;
    display: inline-block;
    width: 270px;
    height:15px;
    font-size:0.5em;
    border-radius: 3px;
    border:1px solid rgb(54, 53, 53);
    text-decoration: none;
    padding:3px 0;
    margin-right: 3px;
    outline: none;
}

.tourPhoto_input>label>input{
    position: absolute;
    width: 0;
    height: 0;
    overflow: hidden;
}

.tourPhoto_alert{
    font-size:0.7em;
    color: rgba(250, 250, 250, 0.7);
}

.tourEnrollBtn{
    width:100%;
    border-radius: 30px;
    padding: 13px 0;
    background-color: #F5A9E1;
    color:black;
    border: none;
    margin-bottom: 20px;
    cursor: pointer;
}

.tourEnrollBtn:focus{
    width:100%;
    border-radius: 30px;
    padding: 13px 0;
    background-color: #F5A9E1;
    color:black;
    border: none;
    margin-bottom: 20px;
    cursor: pointer;
    outline: none;
}
    </style>
</head>
<body class="tourEnrollPage_body">
    <!-- 투어등록 페이지 -->

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

    <main class="tourEnrollPage_main">
        <div class="tourEnrollPage_main-top">
            	투어등록
        </div>
        <form action="./tourInsert" method="post" enctype="multipart/form-data">
            <div class="tourEnrollPage_main-form">
                <div class="tourEnrollPage_main-form_inputBox">
                    <!-- 가이드의 member_idx 넘겨주기-->
                    <input name="member_idx" value="${mainTourEnrollMemberInfo.member_idx }" type="hidden">
                    <div class="tourEnrollPage_main-text">가이드</div>
                    <div class="tourEnrollPage_main-input">${mainTourEnrollMemberInfo.member_name }</div>
                </div>
                <div class="tourEnrollPage_main-form_inputBox">
                    <div class="tourEnrollPage_main-text">연락처</div>
                    <div class="tourEnrollPage_main-input">${mainTourEnrollMemberInfo.member_kakao }</div>
                </div>
                <div class="tourEnrollPage_main-form_inputBox">
                    <!-- 지역카테고리 location_idx 넘겨주기-->
                    <div class="tourEnrollPage_main-text">투어지역</div>
                    <select name="location_idx">
                        <option value="1">서울</option>
                        <option value="2">경기</option>
                        <option value="3">강원</option>
                        <option value="4">충청</option>
                        <option value="5">전라</option>
                        <option value="6">경상</option>
                        <option value="7">제주</option>
                    </select>
                </div>
                <div class="tourEnrollPage_main-form_inputBox">
                    <!-- 투어장소세부지역 tour_tourspot 넘겨주기-->
                    <div class="tourEnrollPage_main-text">투어장소</div>
                    <input name="tour_tourspot" type="text" placeholder="ex) 여수" >
                </div>
                <div class="tourEnrollPage_main-form_inputBox">
                    <!-- tour_max_number 넘겨주기-->
                    <div class="tourEnrollPage_main-text">최대모집인원수</div>
                    <input name="tour_max_number" type="number" placeholder="ex) 3" max="10" min="2">
                </div>
                <div class="tourEnrollPage_main-form_inputBox">
                    <!-- tour_vehicle 넘겨주기-->
                    <div class="tourEnrollPage_main-text">이동수단</div>
                    <input name="tour_vehicle" type="text"  placeholder="ex) 자가용, 버스 등">
                </div>
                <div class="tourEnrollPage_main-form_inputBox">
                    <!--tour_tourdate넘겨주기-->
                    <div  class="tourEnrollPage_main-text">투어날짜</div>
                    <input type="text" id="toDate" name="tour_tourdate" >
                </div>
                <div class="tourEnrollPage_main-form_inputBox tourEnroll_content">
                    <!--tour_intro넘겨주기-->
                    <div class="tourEnroll_content_text">투어제목</div>
                    <textarea name="tour_intro" placeholder="ex) 투어컨셉, 투어 한줄 소개 등 20자 내외" class="tourEnroll_content-tourTile"></textarea>
                </div>
                <div class="tourEnrollPage_main-form_inputBox tourEnroll_content">
                    <!--tour_content넘겨주기-->
                    <div class="tourEnroll_content_text">투어소개</div>
                    <textarea name="tour_content" placeholder="50자 내외" class="tourEnroll_content-tourContent"></textarea>
                </div>
                <!--투어 완료 여부 (n) 넘겨주기-->
                <input name="tour_complete" value="n" type="hidden">
                <div class="tourEnrollPage_main-form_Photo">
                    <!--투어 사진 넘겨주기-->
                    <div class="tourEnrollPage_main_photo-text">사진등록</div>
                    
                     <div id="firstTourPhotoInsert" class="tourEnrollPage_main-photoBox">
                    		<div class="tourPhoto_input">
                                <input type="file" name="files">       
							</div>
                        <div class="tourPhoto_alert">※  첫번째 사진입니다. 대표사진으로 지정됩니다.</div>
                    </div>
                    <div class="tourEnrollPage_main-photoBox">
                    		<div class="tourPhoto_input">
                                <input type="file" name="files" multiple="multiple">      
							</div>
                        <div class="tourPhoto_alert">※ 추가 사진은 최대 4장 업로드 가능하고, 업로드 안할경우 기본 이미지로 제공됩니다</div>
                    </div>
                </div>
                <button type="submit" class="tourEnrollBtn">게시하기</button>
        </form>
    </main>

    <div>--------footer--------</div>

    
</body>
</html>