<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.proyecto.dto.CategoriaDTO" %><%--
     NAME: Gabriel Castillo
     Done: 100%
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Producto</title>
</head>



<body>
<jsp:include page="/WEB-INF/view/cabecera.jsp" />
<section id="formulario2">

    <h1 id="titulo">Datos de la Categoria</h1>
    <form:form method="POST" action="/administrador/categoria/save" modelAttribute="categoria">
        <div style="display:flex">
            <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                <form:input type="hidden" name="id" path="idCategoria"/>

                <div class="input-container ic1">
                    <form:input id="tipo" class="input" type="text" path="tipo" name="tipo" placeholder=" "
                            required="on"
                           oninvalid="this.setCustomValidity('Pon el tipo')"
                           oninput="this.setCustomValidity('')"/>
                    <div class="cut"></div>
                    <label for="tipo" class="placeholder">Tipo</label>
                </div>

            </div>

        </div>
        </br>
        <div style="text-align:center"><input id="btn" type="submit" value="Subir"/></div>
    </form:form>
    </br>
    <form:form method="post" action="/administrador/cancelarCategoria">
    <div style="text-align:center"><input type="submit" value="Cancelar" style="color: #04AA6D;"/>
        </form:form>
</section>
</body>
</html>
