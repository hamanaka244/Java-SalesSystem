<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先検索画面</title>
</head>
<body>
	<div style="text-align:center">
		<h2>得意先検索</h2>
	</div>
	<form action="./jsysFC" method="post">
		<table style="margin: 0 auto">
			<tr>
				<td nowrap align="left">得意先コード</td>
				<td nowrap align="left"><input type="text" name="custCode"
					value="${param.custCode}" maxLength="6" size="10"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="submit"
						name="buttonId" value="V201_01_01">検索</button></td>
			</tr>
		</table>
	</form>
	<form action="./jsysFC" method="post">
		<div style="text-align:right">
			<button type="submit" name="buttonId" value="M01">戻る</button>
		</div>
	</form>	
	
	<div style="text-align:center; color:red; font-weight:bold;">
		<c:out value="${requestScope.errorMessage}" />
		<c:forEach var="message" items="${requestScope.errorMessageList}">
			<c:out value="${message}" />
			<br>
		</c:forEach>
	</div>
</body>
</html>