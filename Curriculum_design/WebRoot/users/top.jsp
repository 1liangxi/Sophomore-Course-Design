<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
        <link rel="stylesheet" href="../css/topstyle.css" type="text/css">
        <style>
            [div1]
            {
                background-color:#145e8d;
                height: 70px;
                margin: -10;
            }
        </style>
    </head>
    <body>
        <div div1>
            <table>
                <tr>
                <td style="width:100px;">
                    <img id="img1" src="../image/logo.png" height="40">
                </td>
                    <td>
                       <h2>医院管理系统</h2>
                    </td> 
                    <td width="500px">
                    </td>
                    <td>
                        <form action="http://www.sogou.com/web?query=" target="_blank">  
                            <input type="text" name="query" placeholder="搜索">    
                        </form>
                    </td>
                    <td>
                        <p>欢迎您,${sessionScope.loginUserName}</p>
                    </td>
                    <td>
                        <a href="<%=path%>/users/Users_logout.action" target="_parent">安全退出</a>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>