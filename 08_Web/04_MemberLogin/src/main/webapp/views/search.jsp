<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원 검색 페이지
	<%-- 회원 검색 : 검색할 아이디 입력받아서
					호출 : /search, 방식 : get
					SearchServlet
					views/result.jsp 에서
						성공하면 해당 정보 출력
						실패하면 "검색에 실패했습니다. 
		--%>
	<form action="/search" method="get">
	 아이디 입력 : <input type="text" name="id"> <br>
	 <input type="submit" value="검색">
	</form>
</body>
</html>