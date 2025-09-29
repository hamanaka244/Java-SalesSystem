<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- HTMLの作成 -->>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<div style="text-align:center">
		<h2>不動産検索システム</h2>
		<h2>ログイン画面</h2>
	</div>
	
	<form action="./jsysFC" method="post">
		<table style="margin:0 auto">
			<tr>
				<td>従業員番号</td>
				<td><input type="text" name="employeeNo" maxLength="6"
					size="14" value="${param.employeeNo}"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="password" maxLength="6"
					size="10"></td>
			</tr>
		</table>
		<div style="text-align:center">
			<button type="submit" name="buttonId" value="V101_01_01"
				style="width:100px">ログイン</button>
		</div>
	</form>
	
	<div style="text-align:center; color:red; font-weight:bold;">
		<c:out value="${requestScope.errorMessage}"/>
		<c:forEach var="message" items="${requestScope.errorMessageList}">
			<c:out value="${message}"/>
			<br>
		</c:forEach>
	</div>
</body>
</html>