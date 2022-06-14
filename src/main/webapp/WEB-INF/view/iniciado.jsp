<%@ page import="es.taw.proyecto.dto.UsuarioDTO" %><%--
  Created by IntelliJ IDEA.
  User: Raul Doblas
  Date: 10/06/2022
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Listado de productos</title>
</head>
<body>
<%
  UsuarioDTO usuarioDTO = (UsuarioDTO) request.getAttribute("usuario");
%>
<header>
  <ul>
    <li><a class="active" href="/usuario/">Home</a></li>
    <li><a href="/subastas/">Mis Subastas</a></li>
    <li style="float:right"><a href="/salir">Cerrar Sesion</a></li>
    <li style="float:right"><a ><%= usuarioDTO.getNombre() %></a></li>
  </ul>
</header>



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
  .box{
    box-sizing: border-box;

  }
  .caja{
    box-sizing: border-box;

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
    cursor: pointer;
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
    height: 100%;
  }
  html{
    height:100%;
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
    align-items: stretch;
    left: -50%;
    box-sizing: content-box;
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
  section {
    height: 100%;

  }
</style>
