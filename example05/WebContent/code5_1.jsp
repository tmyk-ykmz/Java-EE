<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3つのパーツを持つフォームの例</title>
</head>
<body>
	<form action="#" method="post">
		名前：<input type="text" name="name"><br>
		性別：
		男<input type="radio" name="gender" value="0">
		女<input type="radio" name="gender" value="1"><br>
		<input type="submit" value="送信">
	</form>

</body>
</html>