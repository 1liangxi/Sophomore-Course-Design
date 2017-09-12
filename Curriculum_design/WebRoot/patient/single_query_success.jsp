<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/single_query_style.css">
        <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
        <script>
            function modifly()
            {
                var txtN = document.getElementsByTagName("input"); 
                    for(i=1;i<txtN.length;i++)
                    { 
                        if(txtN[i].type=="text")
                        { 
                            txtN[i].readOnly=false; 
                        } 
                        
                    }
                $("#sex").hide();
                $("#checksex").show();
            }
        </script>
    </head>
    <body onload="javascript:$('#checksex').hide();">
        <div id="P_base">基本信息</div>
        <form action="../patient/Patient_modify.action" method="post">
            <table>
            	
                <tr>
                    <td class="row1">病&nbsp;人&nbsp;编&nbsp;号：<input type="text" name="pid" required class="text" value="<s:property value="#session.queryByPid.pid"/>" readonly></td>
                    <td class="row1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="pname" class="text" value="<s:property value="#session.queryByPid.pname"/>" required readonly maxlength="20"></td>
                </tr>
                <tr>
                    <td class="row2">病&nbsp;人&nbsp;地&nbsp;址：<input type="text" name="paddress" class="text" value='<s:property value="#session.queryByPid.paddress"/>' readonly maxlength="50"></td>
                    <td class="row2">联&nbsp;系&nbsp;方&nbsp;式：<input type="text" name="pphone" value='<s:property value="#session.queryByPid.pphone"/>' class="text" readonly placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="11"></td>
                </tr>
                <tr>
                    <td class="row1">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：<input type="text" name="page" value='<s:property value="#session.queryByPid.page"/>' class="text" readonly placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="3"></td>
                    <td class="row1">出生年月日：<input type="text" name="birthday" class="text" value="<s:property value="#session.queryByPid.birthday"/>" readonly maxlength="15"></td>
                </tr>
                <tr>
                    <td class="row2">身&nbsp;&nbsp;&nbsp;份&nbsp;&nbsp;&nbsp;证&nbsp;：<input type="text" name="pidcard" class="text" value="<s:property value="#session.queryByPid.pidcard"/>" readonly placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="18"></td>
                    <td class="row2">籍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贯：<input type="text" name="homeplace" class="text" value="<s:property value="#session.queryByPid.homeplace"/>" readonly maxlength="8"></td>
                </tr>
                <tr>
                    <td class="row1">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input class="text" type="text" id="sex" name="sex" value="<s:property value="#session.queryByPid.psex"/>" readonly>
                        <span id="checksex">
                        		<input type="radio" value="1" name="psex" checked="checked">男
                                <input type="radio" value="2" name="psex">女
                        </span>
                    </td>
                    <td class="row1">有无过敏史：<input type="text" name="allergy" class="text" value='<s:property value="#session.queryByPid.allergy"/>' readonly maxlength="50"></td>
                </tr>
                <tr>
                	<td class="row2">联系人方式：<input type="text" name="cphone" class="text" value='<s:property value="#session.queryByPid.cphone"/>' readonly placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="11"></td>
                	<td class="row2">联系人地址：<input type="text" name="caddress" class="text" value='<s:property value="#session.queryByPid.caddress"/>' readonly maxlength="100"></td>
                </tr>
            </table>
            <input class="button" id="submit" type="submit" value="提交">
        </form>
        <button id="button2" onclick="modifly()">修改</button>
    </body>
</html>