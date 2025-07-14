<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/erp.css" />
  </head>
  <body>
    <header class="head">
      <jsp:include page="header.jsp" />
    </header>
    <sidebar class="side">
      <jsp:include page="sidebar.jsp" />
    </sidebar>
  </body>
</html>
