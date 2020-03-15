<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");
  String name = request.getParameter("name");
  String gender = request.getParameter("gender");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォーム</title>
</head>
<body>
	<p><%=name %>さん<%=(gender) %>を登録しました</p>



</body>
</html>