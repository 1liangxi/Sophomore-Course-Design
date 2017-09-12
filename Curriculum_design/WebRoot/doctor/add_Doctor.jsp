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
        <form action="../doctor/Doctor_add.action" method="post">
            <table>
                <tr>
                    <td class="row1">医&nbsp;生&nbsp;编&nbsp;号：<input type="text" name="did" required class="text" placeholder="编号自动生成" disabled="disabled"></td>
                    <td class="row1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="dname" class="text"  required  maxlength="20"></td>
                </tr>
                
            	
                <tr>
                    <td class="row2">身&nbsp;&nbsp;&nbsp;份&nbsp;&nbsp;&nbsp;证&nbsp;：<input type="text" name="didcard" class="text"  placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="18"></td>
                    <td class="row2">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：<input type="text" name="djod" class="text"  maxlength="8"></td>
                </tr>
                <tr>
                    <td class="row1">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
                        		<input type="radio" value="1" name="dsex" checked="checked">男
                                <input type="radio" value="2" name="dsex">女
                        
                    </td>
                    <td class="row1">联&nbsp;系&nbsp;方&nbsp;式：<input type="text" name="phone" class="text"  placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="11"></td>
                </tr>
                <tr>
                	<td class="row2">科&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;室：<input type="text" name="droom" class="text"  required  maxlength="20"></td>
                </tr>
            </table>
            <div style="margin:0 auto; width:100px;">
             <input id="submit" type="submit" value="提交">
            </div>
        </form>
    </body>
</html>