<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
	<form action="/example08/RegisterUser" method="post">
	ログインＩＤ：<input type="text" name="id"><br>
	パスワード：<input type="password" name="pass"><br>
	名前：<input type="text" name="name"><br>
	<input type="submit" value="確認">
	</form>
</body>
</html>