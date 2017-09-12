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
        <form action="../prescription/Prescription_modify.action" method="post">
            <table>
                <tr>
                    <td class="row1">处&nbsp;方&nbsp;单&nbsp;号：<input type="text" name="pno" required class="text" value="<s:property value="#session.queryByDid.pno"/>" readonly></td>
                    <td class="row1">病&nbsp;人&nbsp;编&nbsp;号：<input type="text" name="pid" class="text" value="<s:property value="#session.queryByDid.pid"/>" required readonly maxlength="20"></td>
                </tr>
                
            	
                <tr>
                    <td class="row2">药&nbsp;品&nbsp;编&nbsp;号：<input type="text" name="mno" class="text" value="<s:property value="#session.queryByDid.mno"/>" class="text" readonly maxlength="18"></td>
                    <td class="row2">收&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费：<input type="text" name="price" class="text" value="<s:property value="#session.queryByDid.price"/>" readonly maxlength="8"></td>
                </tr>
                
            </table>
            <input class="button" id="submit" type="submit" value="提交">
        </form>
        <button id="button2" onclick="modifly()">修改</button>
    </body>
</html>