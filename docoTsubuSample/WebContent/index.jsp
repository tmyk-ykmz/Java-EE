<%-- リスト10-6の状態 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- 改修、追記 --%>
<style type="text/css">
	<!--
		.emphasis {
			color: #ff0000;
			}
	-->
</style>
<script>
<!--
function clickBtn() {
	var pass = document.getElementById("pass");

	// 属性値を取得
	var str = pass.getAttribute("type");

	// 属性値を設定
	if (str == "password") {
		pass.setAttribute("type", "text");
	} else {
		pass.setAttribute("type", "password");
	}
}
//-->
</script>

<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>
<form action="/docoTsubuSample/Login" method="post">
ユーザー名：<input type="text" name="name" required />
<span class="emphasis">※　入力必須</span><br />
<!-- 入力チェック：pattern属性の追加 -->
パスワード：<input type="password" name="pass" pattern="[0-9]{4}$" id="pass" />
<span class="emphasis">※　指定パスワード</span>
<button type="button" onclick="clickBtn()">表示/非表示</button><br />
<input type="submit" value="ログイン" />
<%-- ここまで改修、追記分 --%>
</form>
</body>
</html>