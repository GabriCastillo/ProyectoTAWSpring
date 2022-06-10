<%--
    Author     : casti
    Done       : 100%
--%>


<%@page import="java.util.List"%>
<%@ page import="es.taw.proyecto.dto.RolDTO" %>
<%@ page import="es.taw.proyecto.dto.UsuarioDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Usuario</title>
</head>
<%
    List<RolDTO> listaRoles = (List) request.getAttribute("roles");
    UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("usuario");
    String strError = (String) request.getAttribute("error");
    if (strError == null) {
        strError = "";
    }
%>
<body>

<jsp:include page="/WEB-INF/view/cabecera.jsp" />
<section id="formulario2">
    <h1 id="titulo">Datos del Usuario</h1>
    <form method="POST" action="/administrador/usuario/save">
        <div style="display:flex">
            <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                <input type="hidden" name="id" value="<%= usuario == null ? "" : usuario.getIdusuario()%>" />

                <div class="input-container ic1">
                    <input id="nombre" class="input" type="text" name="nombre" placeholder=" " value="<%= usuario == null ? "" : usuario.getNombre()%>" required oninvalid="this.setCustomValidity('Pon el nombre')"
                           oninput="this.setCustomValidity('')"/>
                    <div class="cut"></div>
                    <label for="nombre" class="placeholder">Nombre</label>
                </div>
                <div class="input-container ic2" >
                    <input id="apellido" class="input" type="text" name="apellido" placeholder=" " value="<%= usuario == null ? "" : usuario.getApellido()%>" required oninvalid="this.setCustomValidity('Pon el apellido')"
                           oninput="this.setCustomValidity('')"/>
                    <div class="cut2"></div>
                    <label for="apellido" class="placeholder">Apellido</label>
                </div>
                <div class="input-container ic2">
                    <input id="domicilio" class="input" type="text" name="domicilio" placeholder=" " value="<%= usuario == null ? "" : usuario.getDomicilio()%>" required oninvalid="this.setCustomValidity('Pon el domicilio')"
                           oninput="this.setCustomValidity('')"/>
                    <div class="cut2"></div>
                    <label for="domicilio" class="placeholder">Domicilio</label>
                </div>

                <div class="input-container ic2" >
                    <input id="ciudad" class="input" type="text" name="ciudad" placeholder=" " value="<%= usuario == null ? "" : usuario.getCiudadResidencia()%>" required oninvalid="this.setCustomValidity('Pon la ciudad de residencia')"
                           oninput="this.setCustomValidity('')"/>
                    <div class="cut2"></div>
                    <label for="ciudad" class="placeholder">Ciudad</label>
                </div>


            </div>

            <div class="dBox">
                <div class="input-container ic1" >
                    <input id="edad" class="input" type="number" name="edad" placeholder=" " value="<%= usuario == null ? "" : usuario.getEdad()%>" required oninvalid="this.setCustomValidity('Pon una edad')"
                           oninput="this.setCustomValidity('')"/>
                    <div class="cut2"></div>
                    <label for="edad" class="placeholder">Edad</label>
                </div>
                <div class="input-container ic2" >
                    <input id="sexo" class="input"  type="text" name="sexo" placeholder=" " value="<%= usuario == null ? "" : usuario.getSexo()%>" required oninvalid="this.setCustomValidity('Pon el sexo')"
                           oninput="this.setCustomValidity('')"/>
                    <div class="cut3"></div>
                    <label for="sexo" class="placeholder">Sexo</label>
                </div>
                <div class="input-container ic2" >
                    <input id="password" class="input" type="text" name="password" placeholder=" " value="<%= usuario == null ? "" : usuario.getPassword()%>" required oninvalid="this.setCustomValidity('Pon la contraseña')"
                           oninput="this.setCustomValidity('')"/>
                    <div class="cut2"></div>
                    <label for="password" class="placeholder">Contraseña</label>
                </div>

                <div class="input-container ic2">

                    <select id="rol" class="input" name="rol" placeholder=" ">
                        <%
                            for (RolDTO r : listaRoles) {
                                String selected = "";
                                if (usuario != null && usuario.getRolIdrol().equals(r)) {
                                    selected = "selected";
                                }
                        %>
                        <option <%= selected%> value="<%= String.valueOf(r.getIdRol())%>"><%= r.getNombre()%></option>
                        <%
                            }
                        %>
                    </select>
                    <div class="cut2"></div>
                    <label for="rol" class="placeholder">Rol</label>

                </div>

            </div>


        </div>
        </br>
        <div style="text-align:center"><input id="btn" type="submit" value="Subir" /></div>

    </form>
    </br>

    <div style="text-align:center"><a href="administrador/usuarios" style="color: #04AA6D;">Cancelar</a></div>
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