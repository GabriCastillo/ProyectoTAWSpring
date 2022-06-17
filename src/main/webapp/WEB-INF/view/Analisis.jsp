<%--
    Author     : pepe_
    Done       : 100%
--%>

<%@page import="es.taw.proyecto.dto.EstadisticaDTO"%>
<%@page import="java.util.List"%>
<%@ page import="es.taw.proyecto.dto.UsuarioDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%--
        List<CategoriaDTO> listaCategorias = (List) request.getAttribute("categorias");
        List<UsuarioDTO> listaUsuarios = (List) request.getAttribute("usuarios");--%> 
    <%    EstadisticaDTO estadistica = (EstadisticaDTO) request.getAttribute("estadistica");
        UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("usuario");
    %>



    <body>
        <section id="formulario2">        

            <h1 id="encabezado">Datos del Analisis</h1>
            <form:form method="POST" action="/analista/guardar" modelAttribute="estadistica">
                <div style="display:flex">
                    <div class="izqBox" style="width: 50%;margin-bottom: 15px">
                        <form:input type="hidden" name="id" path="idEstadistica" />
                        <form:input type="hidden" name="usuario" path="usuarioAnalista" value="<%=usuario.getIdusuario()%>" />

                        <div class="input-container ic1">
                            <form:input id="nombre" class="input" type="text" name="nombre" path="nombre" />
                            <div class="cut"></div>
                            <label for="nombre" class="placeholder">Nombre:</label>
                        </div>

                        <div class="input-container ic2" >
                                <form:textarea  id="descripcion" name="descripcion" class="input" type="text" style="width:70%; height:130px;" path="descripcion" required="on" oninvalid="this.setCustomValidity('Pon la descripcion')"
                                                oninput="this.setCustomValidity('')"/></textarea>
                            <div class="cut2"></div>
                            <label for="descripcion" class="placeholder">Descripcion</label>
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class="input-container ic1">
                            <form:select id="metodo" class="input" name="metodo" path="valorAnalisis" style="width:200px;">
                                <form:option value="">Seleccione un metodo</form:option>
                                <form:option value="1">Media productos vendidos</form:option>
                                <form:option value="2">Media productos en venta</form:option>
                                <form:option value="3">Productos en venta</form:option>
                            </form:select> <br>
                        </div>
                    </div>
                </div>
                <div style="text-align:center"><input id="btn" type="submit" value="Subir"/></div>
            </form:form>
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
    #encabezado{
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
        float:center;
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



