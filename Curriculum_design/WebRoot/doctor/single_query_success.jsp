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
        <form action="../doctor/Doctor_modify.action" method="post">
            <table>
                <tr>
                    <td class="row1">医&nbsp;生&nbsp;编&nbsp;号：<input type="text" name="did" required class="text" value="<s:property value="#session.queryByDid.did"/>" readonly></td>
                    <td class="row1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="dname" class="text" value="<s:property value="#session.queryByDid.dname"/>" required readonly maxlength="20"></td>
                </tr>
                
            	
                <tr>
                    <td class="row2">身&nbsp;&nbsp;&nbsp;份&nbsp;&nbsp;&nbsp;证&nbsp;：<input type="text" name="didcard" class="text" value="<s:property value="#session.queryByDid.didcard"/>" readonly placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="18"></td>
                    <td class="row2">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：<input type="text" name="djod" class="text" value="<s:property value="#session.queryByDid.djod"/>" readonly maxlength="8"></td>
                </tr>
                <tr>
                    <td class="row1">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input class="text" type="text" id="sex" name="sex" value="<s:property value="#session.queryByDid.dsex"/>" readonly>
                        <span id="checksex">
                        		<input type="radio" value="1" name="dsex" checked="checked">男
                                <input type="radio" value="2" name="dsex">女
                        </span>
                    </td>
                    <td class="row1">联&nbsp;系&nbsp;方&nbsp;式：<input type="text" name="phone" class="text" value='<s:property value="#session.queryByDid.phone"/>' readonly placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="11"></td>
                </tr>
                <tr>
                	<td class="row2">科&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;室：<input type="text" name="droom" class="text" value="<s:property value="#session.queryByDid.droom"/>" required readonly maxlength="20"></td>
                </tr>
            </table>
            <input class="button" id="submit" type="submit" value="提交">
        </form>
        <button id="button2" onclick="modifly()">修改</button>
    </body>
</html>