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
	            + "<td><span class='title'>" + item.title + "</span>"
	            + "<br /><span class='author'>저자 : " + item.author
	            + "</span><br /><span class='price''>가격 : " + item.discount + "원</span></td>";
	            resTable.appendChild(row);
	        });  
	    }
	}  
	</script>
<style>
body{
	height: 100vh;
	background-color: #5F7161; 
}
.container {
	max-width: 1200px;
	margin: 40px auto;
	padding: 20px;
	text-align: center;
	background-color: #EFEAD8;
	border-radius: 12px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h1 {
	margin-bottom: 25px;
}

form {
	margin-bottom: 30px;
}

input[name="search_txt"] {
	padding: 8px 12px;
	font-size: 16px;
	border: 2px solid #6D8B74;
	border-radius: 6px;
	width: 60%;
	max-width: 300px;
	margin-right: 10px;
	outline: none;
}

input[type="button"] {
	padding: 9px 20px;
	font-size: 16px;
	background-color: #6D8B74;
	border: none;
	color: white;
	border-radius: 6px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

input[type="button"]:hover {
	background-color: #2980b9;
}

table {
	width: 100%;
	border-collapse: separate;
	border-spacing: 0 15px;
}

tr {
	background-color: #D0C9C0;
	border-radius: 12px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

td {
	padding: 15px;
	vertical-align: top;
	border-radius: 12px;
}

td img {
	margin: 15px;
	border-radius: 8px;
}

.title {
	font-weight: 700;
	font-size: 20px;
}

.author, .price {
	display: block;
	margin-top: 8px;
	line-height: 1.6;
	
}

.author{
font-size: 17px;
color:
}

.price{
font-size: 15px;
color: #7f8c8d;
}
</style>
</head>
<body>

	<div class="container">
		<h1>도서 검색</h1>
		<form>
			<input name="search_txt" placeholder="검색어를 입력하세요" /> <input
				type="button" value="검색" onClick="m_send(this.form)" />
		</form>
		<table id="resTable">
		</table>
	</div>

</body>
</html>
