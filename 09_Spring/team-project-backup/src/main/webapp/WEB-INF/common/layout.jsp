<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ERP</title>
    <link rel="stylesheet" href="../resources/css/reset.css" />
    <link rel="stylesheet" href="../resources/css/layout.css" />
    <link rel="stylesheet" href="../resources/css/project.css" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/chart.js@4.5.0/dist/chart.umd.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.13/main.min.css">
  <meta charset="UTF-8">
  </head>
  <body>
	<jsp:include page="side.jsp"/>
    <div class="main">
		<jsp:include page="header.jsp" />
		<jsp:include page="${component}" />
    </div>
	<script src="../resources/js/layout.js"></script>
  </body>
</html>
