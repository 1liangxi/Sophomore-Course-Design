<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
        <style>
            #search
            {
                padding: 10px 4px;
                width: 600;
                border: 1px solid #bababa;
                border-radius: 2px;
            }
            #search1
            {
                color: snow;
                width: 70;
                height: 34;
                background-color: #6ea1fc;
                border: 1px;
                border-radius:3px;
                margin: 0 10;
                cursor: pointer;
            }
            form
            {
                margin: 200 200;
            }
        </style>
    </head>
    
    <body>
    
        <div width="100%">
            <form action="../checkproject/CheckProject_searchDoctor.action" method="post">
                <input id="search" type="text" placeholder="输入检查项目编号/检查项目名" name="search">
                <input type="submit" id="search1" value="查找">
            </form>
        </div>
    </body>
</html>