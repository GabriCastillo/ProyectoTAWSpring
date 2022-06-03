<%--
  Created by IntelliJ IDEA.
  User: casti
  Date: 03/06/2022
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bienvenidos al sistema</title>
</head>
<%
    String strError = (String)request.getAttribute("error");
    if (strError == null) strError = "";
%>
<body>
<h1>Login</h1>
<%= strError %>
<form method="POST" action="/autentica">
    Usuario: <input type="text" name="usuario" value="" /><br/>
    Clave: <input type="password" name="clave" value="" /><br/> <br/>
    <input type="submit" value="Enviar" />
</form>
</body>
</html>
