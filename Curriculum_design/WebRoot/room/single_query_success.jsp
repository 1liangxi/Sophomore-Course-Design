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
        <form action="../room/Room_modify.action" method="post">
            <table>
                <tr>
                    <td class="row1">科&nbsp;室&nbsp;编&nbsp;号：<input type="text" name="rno" required class="text" value="<s:property value="#session.queryByRno.rno"/>" readonly></td>
                    <td class="row1">科&nbsp;室&nbsp;名&nbsp;称：<input type="text" name="rname" class="text" value="<s:property value="#session.queryByRno.rname"/>" required readonly maxlength="20"></td>
                </tr>
                
            	
                <tr>
                    <td class="row2">联&nbsp;系&nbsp;电&nbsp;话：<input type="text" name="rphone" class="text" value="<s:property value="#session.queryByRno.rphone"/>" readonly placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="18"></td>
              
                </tr>
                <tr>
                	<td class="row1">值&nbsp;班&nbsp;医&nbsp;生：<input class="text" type="text" name="dname" value="<s:property value="#session.queryByRno.dname"/>" readonly>
                    <td class="row1">值&nbsp;班&nbsp;时&nbsp;间：<input class="text" type="text" name="rtime" value="<s:property value="#session.queryByRno.rtime"/>" readonly>
                    </td>
                </tr>
            </table>
            <input class="button" id="submit" type="submit" value="提交">
        </form>
        <button id="button2" onclick="modifly()">修改</button>
    </body>
</html>