<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 검색</title>
<script src="js/httpRequest.js"></script>
<script>
	function m_send(f) {
		let url = "list.do"; 
		let param = "search_txt=" + f.search_txt.value; 
		// 네이버 API 전송방식 "get" 
		sendRequest(url, param, resultFn, "get"); 
		} 
	
	function resultFn() {
	    if( xhr.readyState == 4 && xhr.status == 200 ){
	        let data = xhr.responseText; 
	        let json = eval(data); 
	        let resTable = document.getElementById("resTable"); 
	        resTable.innerHTML =""; 
	        json[0].items.forEach( item => {
	            let row = document.createElement("tr");
	            row.innerHTML = "<td><img src='" + item.image + "' width='100' /></td>"
	            + "<td class='content'><span class='title'>" + item.title + "</span>"
	            + "<br /><span class='author'>저자 : " + item.author
	            + "</span><br /><span class='price''>가격 : " + item.discount + "원</span></td>";
	            resTable.appendChild(row);
	        });  
	    }
	}  
	</script>
<style>
body {
	height: 100vh;
	background-color: #5F7161;
}

.container {
	max-width: 1200px;
	margin: 40px auto;
	padding: 20px;
	text-align: center;
	background-color: #EFEAD8;
	border-radius: 10px;
}

h1 {
	margin-bottom: 25px;
	color: #333;
}

form {
	margin-bottom: 30px;
}

input[type="text"] {
	padding: 10px;
	font-size: 16px;
	border: 2px solid #6D8B74;
	border-radius: 5px;
	width: 60%;
	max-width: 300px;
	margin-right: 10px;
	outline: none;
}

input[type="button"] {
	padding: 10px 20px;
	font-size: 16px;
	background-color: #6D8B74;
	border: none;
	color: white;
	border-radius: 5px;
	cursor: pointer;
}

input[type="button"]:hover {
	background-color: #46594a;
}

table {
	width: 100%;
	border-collapse: separate;
	border-spacing: 0 15px;
}

tr {
	background-color: #D0C9C0;
}

td {
	padding: 15px;
	vertical-align: top;
	border-radius: 10px;
}

td img {
	margin: 15px;
}

.title {
	font-weight: 700;
	font-size: 20px;
	color: #333;
}

.author, .price {
	display: block;
	margin-top: 8px;
	line-height: 1.6;
}

.author {
	font-size: 17px;
	color: #333;
}

.price {
	font-size: 15px;
	color: #454c4d;
}

.content {
	vertical-align: middle;
}
</style>
</head>
<body>

	<div class="container">
		<h1>도서 검색</h1>
		<form>
			<input type="text" name="search_txt" placeholder="검색어를 입력하세요" /> 
			<input type="button" value="검색" onClick="m_send(this.form)" />
		</form>
		<table id="resTable">
		</table>
	</div>

</body>
</html>
