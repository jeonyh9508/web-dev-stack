<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>일정 관리</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
    <section class="project">
      <h1>일정 목록</h1>
      <div class="function">
        <p class="tab">검색</p>
        <form action="/search" method="get">
          <input type="text" id="keyword" />
          <select>
            <option value="projectName">프로젝트명</option>
            <option value="userName">사원명</option>
          </select>
          <input type="submit" id="searchSche" value="검색" />
        </form>
      </div>

  </body>
</html>
