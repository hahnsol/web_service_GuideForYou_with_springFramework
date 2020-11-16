<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	#wrapper{
		margin: auto;
		margin: 0;
	
		
	}
	
	.error404div{
		display: flex;
		flex-direction: column;
		align-items: center;
		margin-top: 250px;
	}

</style>
<title>404</title>
</head>
<body>

	<div id="wrapper">
		<div class="error404div">
			<h1>존재하지 않은 페이지 입니다</h1>
			<a href="${pageContext.request.contextPath}/">메인 화면으로 이동</a>
		</div>
		
	</div>
</body>
</html>