<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
        <title>医院管理系统</title>
        <link rel="stylesheet" href="../css/loginstyle.css" type="text/css">
    </head>
    <div id="top">
        <table>
            <tr>
                <td>
                    <a href="index.html"><img src="../image/login_logo.jpg" id="logo" height="70" ></a>
                </td>
                <td>
                    <h4>医院管理系统</h4>
                </td>
            </tr>
        </table>
    </div>
    <div id="main">
        <div id="login">
            
            <form action="Users_login.action" method="post">
                <input class="sr" type="text" name="username" placeholder="用户名" required><br>
                <input class="sr" type="password" name="password" placeholder="密码"><br>
                <input id="buttom" type="submit" value="登录">
            </form>
            <div id="error" style="margin:-50 50;color:#f52413">
                <s:fielderror/>
            </div>
        </div>
    </div>
    
</html>