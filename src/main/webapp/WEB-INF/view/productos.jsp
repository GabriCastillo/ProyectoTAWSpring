<%--
    Author     : casti
    Done: 100%
--%>

<%@page import="java.util.List"%>
<%@ page import="es.taw.proyecto.dto.ProductoDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado de productos</title>
</head>
<jsp:include page="/WEB-INF/view/cabecera.jsp" />

<h1>Listado de productos</h1>

<form method="get" action="administrador/productos">
    Titulo: <input type="text" name="filtroTitulo" value="" />
    <input type="submit" value="Filtrar" />
</form>
</br>


<%
    List<ProductoDTO> productos = (List) request.getAttribute("productos");
    if (productos == null || productos.isEmpty()) {
%>

<h2>No hay productos</h2>

<%
} else {
%>

<table border="1">
    <tr>
        <th>Titulo</th>
        <th>Descripcion</th>
        <th>Imagen</th>
        <th>Categoria</th>
        <th></th>
        <th></th>
    </tr>
    <%
        for (ProductoDTO producto : productos) {

    %>
    <tr>
        <td><%= producto.getTitulo()%></td>
        <td><%= producto.getDescripcion()%></td>
        <td>
            <div style="width:40%;text-align: center">
                <img src="<%= producto.getUrlImagen()%>"
                     style="border-radius:15px;border: 5px solid #04AA6D "
                     alt="<%= producto.getUrlImagen()%>" width="200" height="200">
            </div>
        </td>
        <!--<td><%= producto.getCategoriaIdcategoria()%></td>-->
        <td><%= producto.getUsuarioVendedor()%></td>
        <td><a href="/administrador/<%= producto.getIdproducto()%>/borrarProducto" style="color: #04AA6D;">Borrar</a></td>
        <td><a href="/administrador/producto/<%= producto.getIdproducto()%>" style="color: #04AA6D;">Editar</a></td>
    </tr>

    <%
        }
    %>
</table>
<%
    }
%>
</br>

<a href="/administrador/nuevoProducto">Crear nuevo producto ... </a>
</body>
</html>

