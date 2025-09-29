<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先管理メニュー画面</title>
</head>
<body>
	<div style="text-align:center">
		<h2>得意先管理メニュー</h2>
	</div>


	
	<form action="./jsysFC" method="post">
		<table style="margin: 0 auto">
			<tr>
				<td>
					<button type="submit" name="buttonId" value="M02_02"
						style="width:200px">検索登録変更削除</button>
				</td>
			</tr>
					<tr>
				<td>
					<button type="submit" name="buttonId" value="M02_05"
						style="width:200px">得意先一覧</button>
				</td>
			</tr>	
		</table>
	</form>
	
	<form action="./jsysFC" method="post">
		<div style="text-align:right">
			<button type="submit" name="buttonId" value="M01">戻る</button>
		</div>
	</form>
</body>
</html>