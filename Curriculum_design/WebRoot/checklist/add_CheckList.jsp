<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/addstyle.css">
    </head>
    <body>
        <div id="P_base">基本信息</div>
        <form action="../checklist/CheckList_add.action" method="post">
            <table>
                <tr>
                    <td class="row1">检&nbsp;查&nbsp;单&nbsp;号：<input type="text" name="lno" required class="text" placeholder="编号自动生成" disabled="disabled"></td>
                    <td class="row1">检查项目号：<input type="text" name="cno" class="text"  required  maxlength="20"></td>
                </tr>
                
            	
                <tr>
                    <td class="row2">病&nbsp;人&nbsp;编&nbsp;号：<input type="text" name="pid" class="text"  maxlength="18"></td>
                    <td class="row2">检&nbsp;查&nbsp;费&nbsp;用：<input type="text" name="cmoney" class="text"  maxlength="8"></td>
                </tr>
                
            </table>
            <div style="margin:0 auto; width:100px;">
             <input id="submit" type="submit" value="提交">
            </div>
        </form>
    </body>
</html>