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
        <form action="../gualist/GuaList_add.action" method="post">
            <table>
                <tr>
                    <td class="row1">挂&nbsp;号&nbsp;单&nbsp;号：<input type="text" name="gno" class="text" placeholder="编号自动生成" disabled="disabled" ></td>
                    <td class="row1">病&nbsp;人&nbsp;姓&nbsp;名：<input type="text" name="pname" class="text" maxlength="10" required></td>
                </tr>
                <tr>
                    <td class="row2">医&nbsp;生&nbsp;编&nbsp;号：<input type="text" name="did" class="text" maxlength="100"/></td>
                    <td class="row2">科&nbsp;室&nbsp;编&nbsp;号：<input type="text" name="rno" class="text" maxlength="11"></td>
                </tr>
                <tr>
                    <td class="row1">是&nbsp;否&nbsp;急&nbsp;诊：<input type="text" name="jz" class="text"  maxlength="3"></td>
                    <td class="row1">是&nbsp;否&nbsp;复&nbsp;诊：<input type="text" name="fz" class="text" maxlength="20"></td>
                </tr>
                <tr>
                    <td class="row2">挂&nbsp;号&nbsp;收&nbsp;费：<input type="text" name="price" class="text" placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="18"></td>
                   
                </tr>
            </table>
            <div style="margin:0 auto; width:100px;">
             <input id="submit" type="submit" value="提交">
            </div>
        </form>
    </body>
</html>