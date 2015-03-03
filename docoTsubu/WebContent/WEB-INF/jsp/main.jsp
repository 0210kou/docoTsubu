<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="docoTsubu.User,docoTsubu.Mutter,java.util.List" %>
    <%
    //セッションスコープに保存されたユーザー情報を取得
    User loginUser = (User)session.getAttribute("loginUser");

    //アプリケーションスコープに保存されたつぶやきリストを取得
    List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");

    //リクエストスコープに保存されたエラーメッセージを取得
    String errorMsg = (String) request.getAttribute("errorMsg");

    %>
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
<a href="/docoTsubu/Logout">ログアウト</a>
<p><a href="/docoTsubu/Main">更新</a>
</p>
<form action="/docoTsubu/Main" method="Post">
<input type="text" name="text" size="40">
<input type="submit" value="つぶやく"size="50">
<input type="reset" value="リセット">
</form>
<%if(errorMsg != null) { %>
<p><%=errorMsg %></p>
<% } %>
<%for(Mutter mutter : mutterList){ %>
<p>ユーザー名<%= mutter.getUserName() %><br>
つぶやき<%= mutter.getText() %></p>
<%} %>

</body>
</html>