<%@ page import="es.taw.proyecto.entity.Usuario" %>
<%@page import="java.util.List"%>
<%@ page import="es.taw.proyecto.dto.CorreoDTO" %>
<%@ page import="es.taw.proyecto.dto.ProductoDTO" %>
<%@ page import="es.taw.proyecto.dto.UsuarioDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Correo del cliente</title>
    </head>
    <%
        UsuarioDTO user = (UsuarioDTO) session.getAttribute("usuario");
    %>
    <body>
    <header>
        <ul>
            <li><a class="active" href="/marketing/">Home</a></li>

            <li style="float:right"><a href="/salir">Cerrar Sesion</a></li>
            <li style="float:right"><a><%= user.getNombre()%></a></li>
        </ul>
    </header>
            
        <h1>Correo de <%= request.getAttribute("nombreUsuario") %></h1>
        
        <%
            List<CorreoDTO> correos = (List)request.getAttribute("correosUsuario");
            if (correos == null || correos.isEmpty() ) {
        %>    
        <h2>Este usuario no ha recibido nada todavía.</h2>
        <%
            } else { 
        %>    
        <table border="1">
        <%    
                for (CorreoDTO correo : correos) {
        %>    
            <tr>
                <td>PROMOCION <%= correo.getIdpromo() %></td>
        <%    
                    if(correo.getIdProducto() == null) {
        %>   
                <td><%= correo.getMensaje() %></td> 
        <%    
                    } else {
        %>
                <td><%= "Recomendación del producto " + correo.getProductoByIdProducto().getIdproducto() + ": "+ correo.getProductoByIdProducto().getTitulo() %> <br/> <%= correo.getMensaje() %></td>
        <%    
                    }
        %>
                <td><a href="/correo/<%= correo.getIdpromo() %>/borrarCorreo">BORRAR</a></td>
            </tr>
        <%
                }
        %>
        </table>
        <%
            }
        %>
        <br>
        <form id="promocionForm" method="post" action="/correo/<%= request.getAttribute("usuarioID") %>/crearCorreo">
            <textarea required name="mensajePromo" rows="4" cols="50" form="promocionForm"></textarea><br/>
            <select name="productoSeleccionado">
                <option selected value="0">Incluir un producto...</option>
        <%    
                List<ProductoDTO> productosLista = (List)request.getAttribute("productosLista");
                if(!productosLista.isEmpty()) {
                    for (ProductoDTO producto : productosLista) {
        %>    
                <option value="<%= producto.getIdproducto() %>"><%= producto.getTitulo() %></option>
        <%
                    }
                }
        %>
            </select>
            <input type="submit" value="Enviar promoción" />
        </form>
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


    .select {
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
    #titulo{
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
        height: 600px;
        float: left;
    }

    #formulario2{
        border-radius: 25px;
        margin-top: 10px;
        background-color:#404040 ;
        height: 600px;
    }

    #usuarios{

        border-radius: 25px;
        margin-top: 10px;
        background-color:#404040 ;
        width: 60%;
        height: 600px;
        float: left;
    }
    #formulario{
        border-radius: 25px;
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


    table{border-collapse:collapse;}
    th,tr,td{
        border:1px solid #000;
        width:150px;
        height:45px;
        vertical-align:middle;
        text-align:center;
    }
    th{
        color:#fff;
        background-color: #252525;
    }

    tr:nth-child(odd) td{
        background-color:#eee;
    }
</style>


