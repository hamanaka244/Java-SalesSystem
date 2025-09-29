<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用画面</title>
</head>

<body>
	<div style="text-align:center">
		<h2>管理者用確認画面</h2>
	</div>

	<form action="./jsysFC" method="post">
		<input type="hidden" name="custCode" value="${requestScope.customer.custCode}">
		<div style="text-align:center">
			得意先コード【
			<c:out value="${requestScope.customer.custCode}" />
			】は完全に削除されました。		
		</div>
		<div style="text-align:right">
			<button type="submit" name="buttonId" value="M02_02">続けて編集</button>
		</div>
		<div style="text-align:right">
			<button type="submit" name="buttonId" value="M01">メインメニュー</button>
		</div>
	</form>
	
</body>
</html>