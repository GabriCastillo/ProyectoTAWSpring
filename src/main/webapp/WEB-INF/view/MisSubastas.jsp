<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.proyecto.dto.UsuarioDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyecto.dto.CompradorProductoDTO" %>
<%@ page import="es.taw.proyecto.dto.CategoriaDTO" %>
<%@ page import="es.taw.proyecto.dto.ProductoSubastaDTO" %>
<%--
  User: Raul Doblas
  Date: 10/06/2022
  Time: 22:48
  Done:100%
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mis Subastas</title>
</head>
<body>
<%
    UsuarioDTO usuarioDTO = (UsuarioDTO) request.getAttribute("usuario");
    List<CompradorProductoDTO> listaSubastas = (List<CompradorProductoDTO>) request.getAttribute("subastas");
    List<CategoriaDTO> categorias = (List<CategoriaDTO>) request.getAttribute("categorias");
%>

<header>
    <ul>
        <li><a  href='/Iniciado/'>Home</a></li>
        <li><a class="active" href="/subastas/">Mis Subastas</a></li>
        <li><a  href='/Misproductos/'>Mis Productos</a></li>
        <li><a href='/Misfavoritos/'>Mis Productos Favoritos</a></li>
        <li style="float:right"><a href="/salir">Cerrar Sesion</a></li>
        <li style="float:right"><a ><%= usuarioDTO.getNombre() %></a></li>
    </ul>
</header>
<section>
    <section id="subastas" style="box-sizing:content-box">
        <h1 class="titulo">Tus subastas</h1>
        <%
            if(listaSubastas!=null){
                for(CompradorProductoDTO subasta: listaSubastas){
        %>

        <div style="display:flex;margin-top: 20px;margin-bottom: 20px">
            <div style="width:40%;text-align: center">
                <img src="<%= subasta.getProductoByProductoIdproducto().getUrlImagen() %>"
                     style="border-radius:15px;border: 5px solid #04AA6D "
                     alt="Foto del producto" width="200" height="200">
            </div>
            <div style="width:30%">
                <h2 style="color:cyan"><%=subasta.getProductoByProductoIdproducto().getTitulo()%></h2><br/>
                <a style="color:white">Descripcion: <%= subasta.getProductoByProductoIdproducto().getDescripcion() %></a><br/>

                <%
                    if(subasta.getPrecioCompra()==0){
                %>
                <a style="color:white">Precio vendido: <%= subasta.getPrecioSalida() %> €</a>
                <%
                }else{
                %>
                <a style="color:white">Precio actual: <%= subasta.getPrecioSalida() %> €</a><br/>
                <a style="color:white">Precio limite: <%= subasta.getPrecioCompra() %> €</a><br/>
                <%
                    }
                %>
            </div>
            <div style="text-align: center;width:20%;margin-top: 50px">
                <%
                    if(subasta.getPrecioCompra()==0){
                %>
                <a id="btnCancel" >Cerrada</a>
                <%
                }else{
                %>
                <a href="/subastas/cerrar/<%= subasta.getIdcompra() %>" id="btn" type="button" value="Cerrar Puja" >Cerrar Puja</a>
                <%
                    }
                %>

            </div>
        </div>
        <%
                }
            }
        %>
    </section>
    <section id="formulario">
        <h1 class="titulo">Añade un producto</h1>
        <form:form method="POST" action="/subastas/crear" modelAttribute="productoSubasta">
            <div style="display:flex">
                <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                    <div class="input-container ic1">
                        <form:input path="titulo"  class="input titulo" type="text" name="titulo" placeholder=" " />
                        <div class="cut"></div>
                        <label for="titulo" class="placeholder">Titulo</label>
                    </div>
                    <div class="input-container ic2" >
                        <form:input path="precioSalida" class="input titulo" type="number" name="precioInicial" placeholder=" " />
                        <div class="cut2"></div>
                        <label for="precioInicial" class="placeholder">Precio Inicial</label>
                    </div>
                    <div class="input-container ic2">
                        <form:input path="precioCompra" id="precioLimite" class="input" type="number" name="precioLimite" placeholder=" " />
                        <div class="cut2"></div>
                        <label for="precioInicial" class="placeholder">Precio limite</label>
                    </div>
                    <div class="input-container ic2">
                        <form:select path="nombreCategoria" id="categoria" class="input" name="categoria" placeholder=" ">
                            <form:options items="${categorias}"></form:options>
                        </form:select>
                        <div class="cut2"></div>
                        <label for="categoria" class="placeholder">Categoria</label>
                    </div>

                </div>
                <div class="dBox">
                    <div class="input-container ic1" >
                        <form:input path="descripcion" id="descripcion" class="input2" type="text" name="descripcion" placeholder=" " />
                        <div class="cut2"></div>
                        <label for="descripcion" class="placeholder">Descripcion</label>
                    </div>
                    <div class="input-container ic3" >
                        <form:input path="urlImagen" id="imagen" class="input" type="text" name="imagen" />
                        <div class="cut3"></div>
                        <label for="imagen" class="placeholder">Selecciona la imagen:</label>
                    </div>

                </div>
                <form:input path="usuarioVendedor" type="hidden" name="id" id="id" value="<%= usuarioDTO.getIdusuario()%>" />

            </div>
            <div style="text-align:center"><form:button id="btn" type="submit"  >Subir Producto</form:button></div>
        </form:form>
    </section>

</section>
</body>
</html>
<style>
    *{
        box-sizing: border-box;
    }
    .input-container {
        height: 50px;
        position:relative ;
        width: 100%;
    }
    .ic1 {
        margin-top: 40px;
    }
    .input {
        background-color: #828282;
        border-radius: 12px;
        border: 0;
        box-sizing: border-box;
        color: #eee;
        font-size: 15px;
        height: 100%;
        outline: 0;
        padding: 4px 20px 0 ;
        margin-left: 20px;
        width: 70%;
    }
    .input2 {
        background-color: #828282;
        border-radius: 12px;
        border: 0;
        box-sizing: border-box;
        color: #eee;
        font-size: 15px;
        height: 130px;
        outline: 0;
        padding: 4px 20px 0 ;
        margin-left: 20px;
        width: 70%;
    }
    .cut {
        background-color: #404040;
        border-radius: 10px;
        height: 20px;
        left: 20px;
        position: absolute;
        top: -20px;
        transform: translateY(0);
        transition: transform 200ms;
        width: 76px;
    }
    .cut2 {
        background-color: #404040;
        border-radius: 10px;
        height: 20px;
        left: 20px;
        position: absolute;
        top: -20px;
        transform: translateY(0);
        transition: transform 200ms;
        width: 96px;
    }
    .cut3 {
        background-color: #404040;
        border-radius: 10px;
        height: 20px;
        left: 20px;
        position: absolute;
        top: -20px;
        transform: translateY(0);
        transition: transform 200ms;
        width: 96px;
    }
    .cut2-short {
        width: 50px;
    }
    .cut-short {
        width: 50px;
    }
    .cut3-short {
        width: 50px;
    }
    .input:focus ~ .cut,
    .input:not(:placeholder-shown) ~ .cut,
    .input:focus ~ .cut2,
    .input:not(:placeholder-shown) ~ .cut2,
    .input2:focus ~ .cut2,
    .input2:not(:placeholder-shown) ~ .cut2
    {
        transform: translateY(8px);
    }
    .placeholder {
        color: white;
        font-family: sans-serif;
        left: 20px;
        line-height: 14px;
        pointer-events: none;
        position: absolute;
        transform-origin: 0 50%;
        transition: transform 200ms, color 200ms;
        top: 20px;
        margin-left: 10px;
    }
    .input:focus ~ .placeholder,
    .input:not(:placeholder-shown) ~ .placeholder,
    .input2:focus ~ .placeholder,
    .input2:not(:placeholder-shown) ~ .placeholder{
        transform: translateY(-30px) translateX(10px) scale(0.75);
    }
    .input:not(:placeholder-shown) ~ .placeholder,
    .input2:not(:placeholder-shown) ~ .placeholder{
        color: #828282;
    }
    .input:focus ~ .placeholder,
    .input2:focus ~ .placeholder{
        color: #04AA6D;
    }
    .ic2 {
        margin-top: 30px;
    }
    .ic3 {
        margin-top: 108px;
    }
    #btn{
        background-color:#04AA6D;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }
    #btnCancel{
        background-color:#828282;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }
    #formText{
        position: relative;
    }
    #relleno{
        background-color: #DBCFBB;
        border-radius: 25px;
        margin-left: 25px;
        height: auto;
        text-align: center;
        width: 200px;
    }
    body{
        background-color:  #DBCFBB;
    }
    .titulo{

        display: block;
        text-align: center;
        font-size:26px;
        color: white;
    }
    #subastas{

        border-radius: 25px;
        margin-top: 10px;
        background-color:#404040 ;
        width: 60%;
        float: left;
    }
    #formulario{
        position:fixed;
        border-radius: 25px;
        margin-left: 62%;
        margin-top: 10px;
        background-color:#404040 ;
        width: 37%;
        height: 600px;
        float:right;
    }
    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: #333;
    }
    li {
        float: left;
        border-right:1px solid #bbb;
    }
    li:last-child {
        border-right: none;
    }
    li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }
    li a:hover:not(.active) {
        background-color: #111;
    }
    .active {
        background-color: #04AA6D;
    }
</style>