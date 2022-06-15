<%--
 NAME: Gabriel Castillo
 Done: 100%
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bienvenidos al sistema</title>
</head>
<%
    String strError = (String)request.getAttribute("error");
    if (strError == null) {
        strError = "";
    }
%>
<body>
<jsp:include page="/WEB-INF/view/logincss.jsp" />
<div class="loginBox"> <img class="user" src="https://i.ibb.co/yVGxFPR/2.png" height="100px" width="100px" alt="icono de perfil">
    <h3>Inicia Sesion</h3>
    <form method="POST" action="/autentica">
        <div class="inputBox">
            <input id="usuario" type="text" name="usuario" placeholder="Usuario">
            <input id="password" type="password" name="clave" placeholder="Contraseña">
            <p style="color:red; margin-top:-5px">
                <%= strError %>
            </p>
        </div>
        <input type="submit" value="Entrar" style="color: #000000;">
    </form>
    <div class="text-center">
        <a href="/registro" style="color: #04AA6D;">Registrate</a>
    </div>
</div>
</body>
</html>

