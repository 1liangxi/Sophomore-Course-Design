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
        <form action="../checkproject/CheckProject_add.action" method="post">
            <table>
                <tr>
                    <td class="row1">项&nbsp;目&nbsp;编&nbsp;号：<input type="text" name="cno" required class="text" placeholder="编号自动生成" disabled="disabled" ></td>
                    <td class="row1">项&nbsp;目&nbsp;名&nbsp;称：<input type="text" name="cname" class="text"  maxlength="20"></td>
                </tr>
                
            	
                <tr>
                    <td class="row2">项&nbsp;目&nbsp;价&nbsp;格：<input type="text" name="money" class="text"  placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="18"></td>
                    <td class="row2">项&nbsp;目&nbsp;说&nbsp;明：<input type="text" name="notes" class="text"   maxlength="80"></td>
                </tr>
            </table>
            <div style="margin:0 auto; width:100px;">
             <input id="submit" type="submit" value="提交">
            </div>
        </form>
    </body>
</html>