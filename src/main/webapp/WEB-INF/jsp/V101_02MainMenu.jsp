<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインメニュー画面</title>
</head>
<body>
	<div style="text-align:center">
		<h2>販売支援システム</h2>
		<h2>メインメニュー</h2>
	</div>
	
	<form action="./jsysFC" method="post">
		<table style="margin: 0 auto">
			<tr>
				<td>
					<button type="submit" name="buttonId" value="M02_01"
						style="width:200px">得意先検索</button>
				</td>
			</tr>
		
			<tr>
				<td>
					<button type="submit" name="buttonId" value="M01_01"
						style="width:200px">管理者専用</button>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" name="buttonId" value="M01_02"
						style="width:200px">得意先別集計(未作成)</button>
				</td>
			</tr>
		</table>
		<br>
		<div style="text-align:center">
			<button type="submit" name="buttonId" value="M01_03"
				style="width:100px">ログアウト</button>
		</div>
	</form>
</body>
</html>