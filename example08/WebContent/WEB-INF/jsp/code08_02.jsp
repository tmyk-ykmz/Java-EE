<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.Human" %>

 <%
 	// セッションからインスタンスを取得
 	Human h = (Human) session.getAttribute("human");
 	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>セッションスコープに格納されたインスタンスを取得する</title>
</head>
<body>
	<h2>セッションスコープに格納されたインスタンスを取得する</h2>
	<%= h.getName() %>さんは<%= h.getAge() %>歳です

</body>
</html>