<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先登録画面ここに追加、更新、削除</title>
<style>
/* CSSを追加 */
.button-group {
    display: flex; /* Flexboxを有効にする */
    justify-content: center; /* ボタンを中央に寄せる */
    gap: 10px; /* ボタン同士の間隔を10px空ける */
    margin-top: 20px; /* テーブルとの間に隙間を作る */
}
</style>
</head>
<body>
	<div style="text-align:center">
		<h2>管理者画面</h2>
	</div>

	<form action="./jsysFC" method="post">
		<table style="margin: 0 auto">
			<tr>
				<td nowrap align="left">得意先コード</td>
				<td nowrap align="left"><input type="text" name="custCode"
					value="${param.custCode}"maxLength="6" size="10"></td>
			</tr>
			<tr>
				<td nowrap align="left">会社名</td>
				<td nowrap align="left"><input type="text" name="custName"
					value="${param.custName}"maxLength="15" size="10"></td>
			</tr>
			<tr>
				<td nowrap align="left">電話番号</td>
				<td nowrap align="left"><input type="text" name="telNo"
					value="${param.telNo}"maxLength="13" size="10"></td>
			</tr>
			<tr>
				<td nowrap align="left">郵便番号</td>
				<td nowrap align="left"><input type="text" name="postalCode"
					value="${param.postalCode}"maxLength="8" size="10"></td>
			</tr>
			<tr>
				<td nowrap align="left">住所</td>
				<td nowrap align="left"><input type="text" name="address"
					value="${param.address}"maxLength="30" size="10"></td>
			</tr>
			<tr>
				<td nowrap align="left">割引率</td>
				<td nowrap align="left"><input type="text" name="discountRate"
					value="${param.discountRate}"maxLength="6" size="10"></td>
			</tr>
			
		</table>	
			<div class="button-group">
		        <button type="submit" name="buttonId" value="検索">検索</button>
		        <button type="submit" name="buttonId" value="新規登録">新規登録</button>
		        <button type="submit" name="buttonId" value="修正">修正</button>
		        <button type="submit" name="buttonId" value="削除">削除</button>
		        <button type="submit" name="buttonId" value="完全削除">完全削除(注意!!)</button>
  		    </div>
		
			
			<div style="text-align:right">
				<button type="submit" name="buttonId" value="M02">戻る</button>
			</div>
		
	</form>
</body>
</html>