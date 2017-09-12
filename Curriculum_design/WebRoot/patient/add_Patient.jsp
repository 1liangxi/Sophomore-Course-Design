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
        <form action="../patient/Patient_add.action" method="post">
            <table>
            	<tr>
            		<td class="row2">挂&nbsp;号&nbsp;单&nbsp;号：<input type="text" name="gno" class="text"></td>
            	</tr>
                <tr>
                    <td class="row1">病&nbsp;人&nbsp;编&nbsp;号：<input type="text" name="pid" class="text" placeholder="编号自动生成" disabled="disabled" ></td>
                    <td class="row1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="pname" class="text" maxlength="10" required></td>
                </tr>
                <tr>
                    <td class="row2">病&nbsp;人&nbsp;地&nbsp;址：<input type="text" name="paddress" class="text" maxlength="100"/></td>
                    <td class="row2">联&nbsp;系&nbsp;方&nbsp;式：<input type="text" name="pphone" class="text" maxlength="11" placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" ></td>
                </tr>
                <tr>
                    <td class="row1">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：<input type="text" name="page" class="text" placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="3"></td>
                    <td class="row1">出生年月日：<input type="text" name="birthday" class="text" maxlength="20"></td>
                </tr>
                <tr>
                    <td class="row2">身&nbsp;&nbsp;&nbsp;份&nbsp;&nbsp;&nbsp;证&nbsp;：<input type="text" name="pidcard" class="text" placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="18"></td>
                    <td class="row2">籍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贯：<input type="text" name="homeplace" class="text" maxlength="8"></td>
                </tr>
                <tr>
                    <td class="row1">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="radio" name="psex" value="1" checked="checked">男
                        <input type="radio" name="psex" value="2" >女
                    </td>
                    <td class="row1">有无过敏史：<input type="text" name="allergy" class="text" maxlength="50"></td>
                </tr>
                <tr>
                <tr>
                	<td class="row2">联系人方式：<input type="text" name="cphone" class="text"  maxlength="11"placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" ></td>
                	<td class="row2">联系人地址：<input type="text" name="caddress" class="text"  maxlength="100"></td>
                </tr>
                </tr>
            </table>
            <div style="margin:0 auto; width:100px;">
             <input id="submit" type="submit" value="提交">
            </div>
        </form>
    </body>
</html>