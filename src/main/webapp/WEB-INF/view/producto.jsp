<%--
    Author     : casti
    Done       : 100
--%>


<%@page import="java.util.List"%>
<%@ page import="es.taw.proyecto.dto.CategoriaDTO" %>
<%@ page import="es.taw.proyecto.dto.UsuarioDTO" %>
<%@ page import="es.taw.proyecto.dto.ProductoDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Producto</title>
</head>
<%
    List<CategoriaDTO> listaCategorias = (List) request.getAttribute("categorias");
    List<UsuarioDTO> listaUsuarios = (List) request.getAttribute("usuarios");
    ProductoDTO producto = (ProductoDTO) request.getAttribute("producto");

%>


<body>
<jsp:include page="/WEB-INF/view/cabecera.jsp" />
<section id="formulario2">

    <h1>Datos del Producto</h1>
    <form:form method="POST" action="/administrador/producto/save" modelAttribute="producto">
        <div style="display:flex">
            <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                <form:input type="hidden" path="idproducto" name="id"/>

                <div class="input-container ic1">
                    <form:input id="titulo" class="input" type="text" path="titulo" required oninvalid="this.setCustomValidity('Pon el titulo')"
                           oninput="this.setCustomValidity('')"/>
                    <div class="cut"></div>
                    <label for="titulo" class="placeholder">Titulo</label>
                </div>

                <div class="input-container ic2" >
                            <form:textarea  id="descripcion"  class="input" type="text" style="width:70%; height:130px;" path="descripcion" required oninvalid="this.setCustomValidity('Pon la descripcion')"
                                       oninput="this.setCustomValidity('')"/><%=producto.getDescripcion()%></textarea>
                    <div class="cut2"></div>
                    <label for="descripcion" class="placeholder">Descripcion</label>
                </div>
            </div>
            <div class="dBox">
                <div class="input-container ic1" >
                    <form:input id="url" class="input" type="text" name="url" value="<%= producto == null ? "" : producto.getUrlImagen() %>" required oninvalid="this.setCustomValidity('Pon la url de la imagen')"
                           oninput="this.setCustomValidity('')"/>
                    <div class="cut3"></div>
                    <label for="url" class="placeholder">Selecciona la imagen:</label>
                </div>


                <div class="input-container ic2">
                    <select id="categoria" class="input" name="categoria" placeholder=" ">
                        <%
                            for (CategoriaDTO c : listaCategorias) {
                                String selected = "";
                                if (producto != null && producto.getCategoriaIdcategoria().equals(c)) {
                                    selected = "selected";
                                }
                        %>
                        <option <%= selected%> value="<%= String.valueOf(c.getIdCategoria())%>"><%= c.getTipo()%></option>
                        <%
                            }
                        %>

                    </select>
                    <div class="cut2"></div>
                    <label for="categoria" class="placeholder">Categoria</label>
                </div>

                <div class="input-container ic2">
                    <select id="idUsuario" class="input" name="idUsuario" placeholder=" ">
                        <%
                            for (UsuarioDTO u : listaUsuarios) {
                                String selected = "";
                                if (producto != null && producto.getUsuarioVendedor().equals(u)) {
                                    selected = "selected";
                                }
                        %>
                        <option <%= selected%> value="<%= String.valueOf(u.getIdusuario())%>"><%= u.getNombre()%></option>
                        <%
                            }
                        %>

                    </select>
                    <div class="cut2"></div>
                    <label for="idUsuario" class="placeholder">Dueño</label>
                </div>
            </div>
        </div>
        </br>
        <div style="text-align:center"><input id="btn" type="submit" value="Subir" /></div>

    </form:form>
    </br>
    <div style="text-align:center"><a href="administrador/productos" style="color: #04AA6D;">Cancelar</a></div>
</section>
</body>
</html>


