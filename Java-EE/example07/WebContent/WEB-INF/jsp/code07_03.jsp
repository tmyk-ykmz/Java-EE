<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Human"%>
<%
	// リクエストスコープからインスタンスを取得
	Human h = (Human) request.getAttribute("human");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPファイルでリクエストスコープを利用する</title>
</head>
<body>
	<h2>JSPファイルでリクエストスコープを利用する</h2>
	<p>
		<%=h.getName()%>さんは、<%=h.getAge()%>歳です
	</p>

</body>
</html>