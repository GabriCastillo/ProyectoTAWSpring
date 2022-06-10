<%--
    Author     : casti
    Done       : 100%
--%>

<%@page import="java.util.List"%>
<%@page import="es.taw.proyecto.dto.CategoriaDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado de Categorias</title>
</head>
<jsp:include page="/WEB-INF/view/cabecera.jsp" />

<h1>Listado de Categorias</h1>

<form method="get" action="administrador/categorias">
    Titulo: <input type="text" name="filtroTipo" value="" />
    <input type="submit" value="Filtrar" />
</form>
</br>


<%
    List<CategoriaDTO> categorias = (List) request.getAttribute("categorias");
    if (categorias == null || categorias.isEmpty()) {
%>

<h2>No hay categorias</h2>

<%
} else {
%>

<table border="1">
    <tr>
        <th>Tipo</th>
        <th></th>
        <th></th>
    </tr>
    <%
        for (CategoriaDTO categoria : categorias) {

    %>
    <tr>
        <td><%= categoria.getTipo()%></td>

        <td><a href="/administrador/<%= categoria.getIdCategoria()%>/borrarCategoria" style="color: #04AA6D;">Borrar</a></td>
        <td><a href="/administrador/categoria/<%= categoria.getIdCategoria()%>" style="color: #04AA6D;">Editar</a></td>
    </tr>

    <%
        }
    %>
</table>
<%
    }
%>
</br>

<a href="/administrador/nuevaCategoria">Crear nueva categoria ... </a>

</body>
</html>
