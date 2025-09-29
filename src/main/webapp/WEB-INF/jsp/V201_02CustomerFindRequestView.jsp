<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先検索結果画面</title>
</head>

<body>
	<div style="text-align:center">
		<h2>得意先検索結果</h2>
	</div>

	<form action="./jsysFC" method="post">
		<input type="hidden" name="custCode" value="${requestScope.customer.custCode}">
		<table border="1" style="margin: 0 auto">
			<tr>
				<td nowrap width="100">得意先コード</td>
				<td nowrap width="300">
				<c:out value="${requestScope.customer.custCode}" /></td>
			</tr>
			<tr>
				<td nowrap width="100">得意先名</td>
				<td nowrap width="300">
				<c:out value="${requestScope.customer.custName}" /></td>
			</tr>
			<tr>
				<td nowrap width="100">電話番号</td>
				<td nowrap width="300">
				<c:out value="${requestScope.customer.telNo}" /></td>
			</tr>
			<tr>
				<td nowrap width="100">郵便番号</td>
				<td nowrap width="300">
				<c:out value="${requestScope.customer.postalCode}" /></td>
			</tr>
			<tr>
				<td nowrap width="100">住所</td>
				<td nowrap width="300">
				<c:out value="${requestScope.customer.address}" /></td>
			</tr>
			<tr>
				<td nowrap width="100">割引率</td>
				<td nowrap width="300">
				<c:out value="${requestScope.customer.discountRate}" /> %</td>
			</tr>
		</table>
		<br>	
		<div style="text-align:right">
			<button type="submit" name="buttonId" value="M02_01">戻る</button>
		</div>
		<div style="text-align:right">
			<button type="submit" name="buttonId" value="M01">メインメニュー</button>
		</div>
	</form>
	
</body>
</html>