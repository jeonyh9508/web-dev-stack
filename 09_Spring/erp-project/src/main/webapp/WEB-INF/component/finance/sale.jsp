<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section>>
	<form action="/insert" method="post">
	<p>매출 일자 : <input type="date" name="saleDate"></p>
	<p>품목명 : <input type="text" name="productName"></p>
	<p>카테고리 : <input type="text" name="category"></p>
	<p>성별 : <input type="text" name="gender"></p>
	<p>수량 : <input type="text" name="quanatity"></p>
	<p>부가세 : <input type="text" name="varAmount"></p>
	<p>총액 : <input type="text" name="totalAmount"></p>
	<input type="submit" value="등록">
	</form>
</section>