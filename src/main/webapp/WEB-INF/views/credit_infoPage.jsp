<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/myPage_js/getStarJquery.raty.js"></script>
    <title>신용정보 페이지</title>

    <script>
            function openCity(evt, cityName) {
              var i, tabcontent, tablinks;
              tabcontent = document.getElementsByClassName("tabcontent");
              
              for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
              }
              
              tablinks = document.getElementsByClassName("tablinks");
              for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
              }
              
              document.getElementById(cityName).style.display = "block";
              evt.currentTarget.className += " active";
            }

            
            $(function() {
                $('div#star').raty({
                    score: 5
                    ,path : ""
                    ,width : 200
                    ,click: function(score, evt) {
                        $("#starRating").val(score);
                        $("#displayStarRating").html(score);
                    }
                });
            });
    </script>
</head>
<body>
    
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
                        				<img alt="member_profile_photo" class="header_memberProfilePhoto" src="${pageContext.request.contextPath}/MainImages/basicMemberProfile.jpg">
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


        <main class="credit_main">
            <section class="credit_main_profile">
                <div class="main_header_container container">
                    <div class="credit_main_profile_top">
                        <div class="credit_main_profile_top_title">신용정보페이지</div> 
                    </div>   
                
                    <div class="credit_main_profile_bottom">
                        <div class="credit_main_profile_bottom_info ">
                        	<c:choose>
                        		<c:when test="${guideCreditMemberInfo.member_profile_photo == 'n' }">
                        			<div href="#" class="credit_main_profile_bottom_photo">
                        				<img src="${pageContext.request.contextPath}/myPageImg/basic_img.jpg" class="img-thumbnail">
                        			</div> 
                        		</c:when>
                        		<c:otherwise>
                        			<div href="#" class="credit_main_profile_bottom_photo">
                        				<img src="${guideCreditMemberInfo.member_profile_photo}" class="img-thumbnail">
                        			</div> 
                        		</c:otherwise>
                        	</c:choose>
                             
                            <div class="credit_main_profile_bottom_nick">
                            	${guideCreditMemberInfo.member_nick}
                            </div>  
                        </div> 
                    </div>
                </div>
                
            </section>

        <div class="container myPage_wrapper">
            <section class="credit_main_guide_tourlist">
                <div class="credit_main_guide_tourlist_name">${guideCreditMemberInfo.member_nick}의 투어</div>
                <div class="guide_tourlist_moving-column">
                
                	<c:forEach items="${guideCreditTourInfo}" var="tourListData">
                		<a href="./tourGuideContentPage?tour_idx=${tourListData.tour_idx}" class="card guide_tourlist_moving-column_card" style="width: 23.4em;">
                       	 	<img src="${tourListData.tour_photo1}" class=" " >
                       	 <div class="card-body">
                       	     <p class="card-text">${tourListData.tour_intro}</p>
                       	 </div>
                    	</a>
                	</c:forEach>
                   
                   
                </div>         
            </section>

            <section class="credit_main_evaluation_sector">
                <div class="credit_main_evaluation_sector_name">
                    <h4 class="credit_main_evaluation_sector_name_title">${guideCreditMemberInfo.member_nick}님의 후기</h4>
                </div>

                <div class="tab">
                    <button class="tablinks " onclick="openCity(event, 'evaluation_guide')">받은 가이드리뷰</button>
                    <div class="tablinks_divide"></div>
                    <button class="tablinks " onclick="openCity(event, 'evaluation_customer')">받은 게스트 리뷰</button>
                </div>
                
                
                <!-- 가이드 총평점 -->
                <div id="evaluation_guide" class="evaluation_guide tabcontent">
                    <div class="credit_main_sector_score">
                        <i class="far fa-star"></i>
                             <div class="credit_info_total_score">가이드 총평점 :</div><div id="star">${guideGuideAvgScore}</div>
                    </div>
                   
                    
                 <c:forEach items="${guideGetGuideReview}" var="getGuideReview">
                 
                 		<div class="guide_sector_columns_review_member">
                        		<div class="review_member">
                            		<div class="review_member_top"> 
                                		<a href="#" class=""><img src="${pageContext.request.contextPath}/myPageImg/basic_img.jpg" class="review_member_info_img" ></a>
                                		<div class="review_member_info_nick">${getGuideReview.memberBasicVo.member_nick}</div>
                            		</div>
                            		<div class="review_member_middle">
                                		<div class="review_member_review">${getGuideReview.guide_EvaluationBasicVo.guide_review}</div>
                            		</div>
                            		<div class="review_member_bottom container">
                                		<div class="review_member_score">
                                			<img src="${pageContext.request.contextPath}/myPageImg/star-on-small.png" class="review_bottom_column_star_img">${getGuideReview.guide_EvaluationBasicVo.guide_score}
                                		</div>
                            		</div>
                        		</div> 
                    		</div>  
                    		
                 </c:forEach>
                </div>
                



                <!-- 고객 총 평점 입니다 -->
                <div id="evaluation_customer" class="evaluation_customer tabcontent">
                    <div class="credit_main_sector_score">
                        <i class="far fa-star"></i>
                        <div class="credit_info_total_score">고객 총평점 :</div>
                        <div id="star">${guideCustomerAvgScore}</div>
                    </div>



					 <c:forEach items="${guideGetCustomerReview}" var="getCustomerReview">
                 
                 		<div class="guide_sector_columns_review_member">
                        		<div class="review_member">
                            		<div class="review_member_top"> 
                                		<a href="#" class=""><img src="myPageImg/basic_img.jpg" class="review_member_info_img" ></a>
                                		<div class="review_member_info_nick">${getCustomerReview.memberBasicVo.member_nick}</div>
                            		</div>
                            		<div class="review_member_middle">
                                		<div class="review_member_review">${getCustomerReview.customer_EvaluationBasicVo.customer_review}</div>
                            		</div>
                            		<div class="review_member_bottom container">
                                		<div class="review_member_score">
                                			<img src="myPageImg/star-on-small.png" class="review_bottom_column_star_img">${getCustomerReview.customer_EvaluationBasicVo.customer_score}
                                		</div>
                            		</div>
                        		</div> 
                    		</div>  
                    		
                 </c:forEach>
					 
                </div> 
            </section>
        </main>

        <footer class="common_footer">공통 footer ui를 넣을 겁니다</footer>
   

    
    
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>