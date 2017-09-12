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
        <form action="../gualist/GuaList_modify.action" method="post">
            <table>
                <tr>
                    <td class="row1">挂&nbsp;号&nbsp;单&nbsp;号：<input type="text" name="gno" required class="text" value="<s:property value="#session.queryByDid.gno"/>" readonly></td>
                    <td class="row1">病&nbsp;人&nbsp;姓&nbsp;名：<input type="text" name="pname" class="text" value="<s:property value="#session.queryByDid.pname"/>" required readonly maxlength="20"></td>
                </tr>
                
            	
                <tr>
                    <td class="row2">医&nbsp;生&nbsp;编&nbsp;号：<input type="text" name="did" class="text" value="<s:property value="#session.queryByDid.did"/>" readonly placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="18"></td>
                    <td class="row2">科&nbsp;室&nbsp;编&nbsp;号：<input type="text" name="rno" class="text" value="<s:property value="#session.queryByDid.rno"/>" readonly maxlength="8"></td>
                </tr>
                <tr>
                    <td class="row1">是&nbsp;否&nbsp;急&nbsp;诊：<input class="text" type="text"  name="jz" value="<s:property value="#session.queryByDid.jz"/>" readonly>
                       
                    </td>
                    <td class="row1">是&nbsp;否&nbsp;复&nbsp;诊：<input type="text" name="fz" class="text" value='<s:property value="#session.queryByDid.fz"/>' readonly placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="11"></td>
                </tr>
                <tr>
                	<td class="row2">挂&nbsp;号&nbsp;费&nbsp;用：<input type="text" name="price" class="text" value="<s:property value="#session.queryByDid.price"/>" required readonly maxlength="20"></td>
                </tr>
            </table>
            <input class="button" id="submit" type="submit" value="提交">
        </form>
        <button id="button2" onclick="modifly()">修改</button>
    </body>
</html>