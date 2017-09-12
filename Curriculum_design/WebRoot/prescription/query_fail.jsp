<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
        <style>
            #div1
            {
                margin: 200 auto;
                width: 600px;
                text-align: center;
            }
            a:link,a:visited
            {
                color: #6134f7;
                text-decoration: none;
            }
            a:hover
            {
                color: #fd0027;
                text-decoration: underline;
            }
        </style>
    </head>
    
    <body>
        <div id="div1">
            <h3>很抱歉，没有找到相关的信息。</h3>
            <a href="../prescription/Prescription_query_single.jsp">返回查询</a>
            <a href="../prescription/Prescription_Patient.jsp" target="main">新增档案</a>
        </div>
    </body>
</html>