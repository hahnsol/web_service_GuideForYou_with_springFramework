<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>400</title>
</head>
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
<body>

		<div id="wrapper">
		<div class="error404div">
			<h1>요청 작업중 에러가 발생했습니다  잠시후 다시 시도해주세요</h1>
			<h3>지속적인 에러가 발생 할경우 메일을 보내주세요</h3>
			<a href="${pageContext.request.contextPath}/">메인 화면으로 이동</a>
		</div>
		
	</div>
	
</body>
</html>