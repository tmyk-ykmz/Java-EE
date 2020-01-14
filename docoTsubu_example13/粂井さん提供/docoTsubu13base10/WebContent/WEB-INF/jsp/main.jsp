<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ page import="model.User" %>
<%-- 追記（p.299）--%>
<%@ page import="model.Mutter" %>
<%@ page import="java.util.List" %>
<%-- END --%>
<%
// セッションスコープに保存されたユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<%-- 追記（p.299）--%>
<%--
// アプリケーションスコープに保存されたつぶやきリストを取得
@SuppressWarnings("unchecked") // 参照（p.472）
List<Mutter> mutterList =
	(List<Mutter>) application.getAttribute("mutterList");
--%>
<%
// リクエストスコープに保存されたつぶやきリストを取得
@SuppressWarnings("unchecked") // 参照（p.406）
List<Mutter> mutterList =
	(List<Mutter>) request.getAttribute("mutterList");
%>
<%-- END --%>
<%-- 追記（p.304）--%>
<%
// リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<%-- END --%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>どこつぶ</title>
</head>
<body>
  <h1>どこつぶメイン</h1>
  <p>
  <%= loginUser.getName() %>さん、ログイン中
  <%-- 追記（p.292）--%>
  <a href="/docoTsubu13base10/Logout">ログアウト</a>
   <%-- END --%>
  </p>
  <%-- 追記（p.299）--%>
  <p>
  <a href="/docoTsubu13base10/Main">更新</a>
  </p>
  <form action="/docoTsubu13base10/Main" method="post">
    <input type="text" name="text" />
    <input type="submit" value="つぶやく" />
  </form>
  <%-- 挿入（p.305）--%>
  <% if(errorMsg != null) { %>
  <p><%= errorMsg %></p>
  <% } %>
  <%-- 挿入 END --%>
  <% for(Mutter mutter : mutterList) { %>
	<p><%= mutter.getUserName() %> : <%= mutter.getText() %></p>
  <% } %>
  <%-- END --%>
</body>
</html>