<%--
  Created by IntelliJ IDEA.
  User: casti
  Date: 11/06/2022
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
</html>
<style>
    body{margin: 0;padding: 0;background: url(https://i.ibb.co/1GQFwtt/Screen-Shot1575.webp) no-repeat;height: 100vh;font-family: sans-serif;background-size: cover;background-repeat: no-repeat;background-position: center;overflow: hidden}
    .loginBox{position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%);width: 350px;min-height: 200px;background: #000000;border-radius: 10px;padding: 40px;box-sizing: border-box}
    .user{margin: 0 auto;display: block;margin-bottom: 20px}
    h3{margin: 0;padding: 0 0 20px;color: #04AA6D;text-align: center}
    .loginBox input{width: 100%;margin-bottom: 20px}
    .loginBox input[type="text"],
    .loginBox input[type="password"]{border: none;border-bottom: 2px solid #262626;outline: none;height: 40px;color: #fff;background: transparent;font-size: 16px;padding-left: 20px;box-sizing: border-box}
    .loginBox input[type="text"]:hover,
    .loginBox input[type="password"]:hover{color: #42F3FA;border: 1px solid #42F3FA;box-shadow: 0 0 5px rgba(0,255,0,.3), 0 0 10px rgba(0,255,0,.2), 0 0 15px rgba(0,255,0,.1), 0 2px 0 black}
    .loginBox input[type="text"]:focus,
    .loginBox input[type="password"]:focus{border-bottom: 2px solid #42F3FA}
    .inputBox{position: relative}
    .inputBox span{position: absolute;top: 10px;color: #262626}
    .loginBox input[type="submit"]{border: none;outline: none;height: 40px;font-size: 16px;background: #04AA6D;color: #fff;border-radius: 20px;cursor: pointer}
    .loginBox a{color: #262626;font-size: 14px;font-weight: bold;text-decoration: none;text-align: center;display: block}a:hover{color: #00ffff}p{color: #0000ff}
</style>
