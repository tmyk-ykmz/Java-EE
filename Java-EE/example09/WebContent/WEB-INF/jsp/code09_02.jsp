<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Human" %>
<%
// アプリケーションスコープからインスタンスを取得
Human h = (Human) application.getAttribute("human");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アプリケーションスコープに格納されたインスタンスを取得するJSPファイル</title>
</head>
<body>
	<h2>アプリケーションスコープに格納されたインスタンスを取得するJSPファイル</h2>
	<%= h.getName() %>さんは<%= h.getAge() %>歳です
</body>
</html>