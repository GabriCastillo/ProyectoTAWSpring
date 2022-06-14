<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
    Author     : casti
    Done       : 100%
--%>


<%@page import="java.util.List" %>
<%@ page import="es.taw.proyecto.dto.RolDTO" %>
<%@ page import="es.taw.proyecto.dto.UsuarioDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Usuario</title>
</head>
<%
    String strError = (String) request.getAttribute("error");
    if (strError == null) {
        strError = "";
    }
%>
<body>

<jsp:include page="/WEB-INF/view/cabecera.jsp"/>
<section id="formulario2">
    <h1 id="titulo">Datos del Usuario</h1>
    <form:form method="POST" action="/administrador/usuario/save" modelAttribute="usuario">
        <div style="display:flex">
            <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                <form:input type="hidden" name="id" path="idusuario"/>

                <div class="input-container ic1">
                    <form:input id="nombre" class="input" type="text" name="nombre" path="nombre" required="on"
                                oninvalid="this.setCustomValidity('Pon el nombre')"
                                oninput="this.setCustomValidity('')"/>
                    <div class="cut"></div>
                    <label for="nombre" class="placeholder">Nombre</label>
                </div>
                <div class="input-container ic2">
                    <form:input id="apellido" class="input" type="text" name="apellido" path="apellido" required="on"
                                oninvalid="this.setCustomValidity('Pon el apellido')"
                                oninput="this.setCustomValidity('')"/>
                    <div class="cut2"></div>
                    <label for="apellido" class="placeholder">Apellido</label>
                </div>
                <div class="input-container ic2">
                    <form:input id="domicilio" class="input" type="text" name="domicilio" placeholder=" "
                                path="domicilio" required="on" oninvalid="this.setCustomValidity('Pon el domicilio')"
                                oninput="this.setCustomValidity('')"/>
                    <div class="cut2"></div>
                    <label for="domicilio" class="placeholder">Domicilio</label>
                </div>

                <div class="input-container ic2">
                    <form:input id="ciudad" class="input" type="text" name="ciudad" placeholder=" "
                                path="ciudadResidencia" required="on"
                                oninvalid="this.setCustomValidity('Pon la ciudad de residencia')"
                                oninput="this.setCustomValidity('')"/>
                    <div class="cut2"></div>
                    <label for="ciudad" class="placeholder">Ciudad</label>
                </div>


            </div>

            <div class="dBox">
                <div class="input-container ic1">
                    <form:input id="edad" class="input" type="number" name="edad" min="18" placeholder=" " path="edad"
                                required="on"
                                oninvalid="this.setCustomValidity('Pon una edad que sea mayor que 18 años')"
                                oninput="this.setCustomValidity('')"/>
                    <div class="cut2"></div>
                    <label for="edad" class="placeholder">Edad</label>
                </div>
                <div class="input-container ic2">
                    <form:select path="sexo" id="sexo" class="input" name="sexo">
                        <form:option value="Hombre" label="Hombre"></form:option>
                        <form:option value="Mujer" label="Mujer"></form:option>
                    </form:select>
                    <div class="cut3"></div>
                    <label for="sexo" class="placeholder">Sexo</label>
                </div>
                <div class="input-container ic2">
                    <form:input id="password" class="input" type="text" name="password" placeholder=" " path="password"
                                required="on" oninvalid="this.setCustomValidity('Pon la contraseña')"
                                oninput="this.setCustomValidity('')"/>
                    <div class="cut2"></div>
                    <label for="password" class="placeholder">Contraseña</label>
                </div>

                <div class="input-container ic2">

                    <form:select path="rolIdrol" id="rol" class="input" name="rol">
                        <form:options items="${roles}" itemLabel="nombre" itemValue="idRol"/>
                    </form:select>

                    <div class="cut2"></div>
                    <label for="rol" class="placeholder">Rol</label>
                </div>
            </div>
        </div>
        </br>
        <div style="text-align:center"><input id="btn" type="submit" value="Subir"/></div>

    </form:form>
    </br>

    <form:form method="post" action="/administrador/cancelarUsuario">
    <div style="text-align:center"><input type="submit" value="Cancelar" style="color: #04AA6D;"/>
        </form:form>
</section>
<%
    if (strError != "") {
%>
<script>
    function myFunction() {
        alert("<%= strError%>");
    }

    myFunction();
</script>
<%
    }
%>
</body>
</html>