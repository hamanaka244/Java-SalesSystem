<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先変更画面</title>
</head>
<body>
<body>
	<div style="text-align:center">
		<h2>得意先変更</h2>
	</div>

	<form action="./jsysFC" method="post">
		<div style="text-align:right">
			<button type="submit" name="buttonId" value="M02">戻る</button>
		</div>
	</form>

	<form action="./jsysFC" method="post">
		<table style="margin: 0 auto">
			<tr>
				<td nowrap align="left">得意先コード</td>
				<td nowrap align="left"><input type="text" name="custCode"
					value="${param.custCode}"maxLength="6" size="10"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="submit"
						name="buttonId" value="V201_01_01">変更</button></td>
			</tr>
		</table>

</body>

</body>
</html>