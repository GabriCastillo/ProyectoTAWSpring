<%-- 
    Document   : MisFavoritos
    Created on : 14-may-2022, 14:26:36
    Author     : frees
    Done       : 100%
--%>


<%@page import="java.util.List"%>
<%@ page import="es.taw.proyecto.dto.UsuarioDTO" %>
<%@ page import="es.taw.proyecto.dto.CategoriaDTO" %>
<%@ page import="es.taw.proyecto.dto.ProductoDTO" %>
<%@ page import="es.taw.proyecto.dto.CompradorProductoDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis subastas</title>
    </head>
    <%
        UsuarioDTO user = (UsuarioDTO) request.getAttribute("usuario");
        List<CategoriaDTO> listaCategorias = (List) request.getAttribute("categorias");
        ProductoDTO producto1 = (ProductoDTO) request.getAttribute("producto");
        List<CompradorProductoDTO> listaSubastas = (List) request.getAttribute("subastas");
    %> 
    <body>
        <header>       
                <ul>
                <li><a href='/Iniciado/'>Home</a></li>
                <li><a href="/subastas/">Mis Subastas</a></li>
                <li><a href='/Misproductos/'>Mis Productos</a></li>
                <li><a class="active" href='/Misfavoritos/'>Mis Productos Favoritos</a></li>
                <li style="float:right"><a href="/">Cerrar Sesion</a></li>
                <li style="float:right"><a href="PerfilServlet"><%= user.getNombre() %></a></li>
              </ul>
        </header>
    </br>
    <form method="post" action='/Misfavoritos/filtrar/'>
    Titulo: <input type="text" name="filtroTitulo" value="" />
     
    Categoria:<select id="categoria" class="input" name="categoria" placeholder=" " style="width:200px;">
        <option value="">Todas la categoria</option>
                            <%
                                for (CategoriaDTO c : listaCategorias) {
                                    String selected = "";
                                    if (producto1 != null && producto1.getCategoriaIdcategoria().equals(c)) {
                                        selected = "selected";
                                    }
                            %>
                           
                            <option <%= selected%> value="<%= String.valueOf(c.getIdCategoria())%>"><%= c.getTipo()%></option>    
                            <%
                                }
                            %> 

                        </select>
                              
    <input type="submit" value="Filtrar" />
</form>
    <center>
        <section>
            <%
                if(!listaSubastas.isEmpty()){
            %>
            <section id="subastas" style="box-sizing:content-box">
                <h1 id="titulo">Tus Favoritos</h1>
            <%
               
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
                    <a style="color:white">Descripcion:<%= subasta.getProductoByProductoIdproducto().getDescripcion() %></a><br/>
                   
                    <%
                        if(subasta.getPrecioCompra()==0){
                    %>
                    <a style="color:white">Precio vendido: <%= subasta.getPrecioSalida() %> €</a><br/>
                    <a style="color:white">Vendedor : <%= subasta.getUsuarioByUsuarioVendedor().getNombre()%></a><br/>
                    <%
                        }else{
                    %>
                    <a style="color:white">Precio actual: <%= subasta.getPrecioSalida()%> €</a><br/>
                    <a style="color:white">Precio limite: <%= subasta.getPrecioCompra() %> €</a><br/>
                    <%
                        }
                    %>
                </div>
                <div style="text-align: center;width:20%;margin-top: 50px">
                    <% 
                    if(subasta.getPrecioCompra()==0){
                    %>
                    <form action='/Misfavoritos/QuitarFavorito/<%=subasta.getIdcompra()%>/' method="post">
                        <button type="submit" id="btnCancelf"  value="Quitar favorito" >Ya en favoritos</button>
                    </form>                    </br></br>
                    <a id="btnCancel" >Cerrada</a>
                    </br>
                    <a style="color:white">Comprador : <%= subasta.getUsuarioByUsuarioComprador().getNombre() %></a>
                    
                    <% 
                    }else{
                       
                    %>
                   <form action='/Misfavoritos/pujar/' method="post"  >
                    <output style="color:white"><%= subasta.getPrecioSalida()+1 %></output>
                    <a id="valor"  style="color:white" >€</a></br>
                    <input id="slider" style="cursor: pointer;" name="slider"  type="range" oninput="this.previousElementSibling.previousElementSibling.previousElementSibling.value = this.value"  onchange="this.previousSibling.innerText = this.value"min=<%= subasta.getPrecioSalida()+1 %> max=<%= subasta.getPrecioCompra() %>  value=<%= subasta.getPrecioSalida()+1 %> data-rangeslider>
                    <input type="id" name="id" hidden="true" value="<%= subasta.getIdcompra() %>"/>
                    <button type="submit" id="btn2"  value="Pujar" >Pujar</button>
                    </form>
                    </br>
                    <form action='/Misfavoritos/QuitarFavorito/<%=subasta.getIdcompra()%>/' method="post">
                        <button type="submit" id="btnCancelf2"  value="Quitar favorito" >Ya en favoritos</button>
                    </form>
                    <% }
                    %>
                </div>
            </div>
            <%        
                    }
                }else{
                  
            %>
            <h1>No tienes ningun producto en Favoritos</h1> 
                
            <% 
                }
            %>    
           </section>
            
        </section>
      </center>      
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
    #btnCancelf2{
        background-color:#828282;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        cursor: pointer;
    }
    #btnCancelf{
        background-color:#828282;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        cursor: pointer;
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