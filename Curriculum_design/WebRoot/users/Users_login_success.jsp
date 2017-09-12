<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <head>
        <Meta http-equiv=” Content-Type” Content=” text/html; Charset=utf-8″/>
        <title>
            医院管理系统
        </title>
    </head>
    
    <frameset rows="70,*" frameborder="no">
        <frame src="top.jsp" scrolling="no" noresize="noresize"/>
        <frameset cols="250,*">
            <frame id="menu" src="menu.jsp" scrolling="yes"/>
            <frame  src="" name="main"/>
        </frameset>
    </frameset>
</html>