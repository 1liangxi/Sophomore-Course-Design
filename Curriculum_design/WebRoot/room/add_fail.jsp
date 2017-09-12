<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/addstyle.css">
        <script type="text/javascript">
        	alert("该医生不存在，请重新输入。");
        </script>
    </head>
    <body>
        <div id="P_base">基本信息</div>
        <form action="../room/Room_add.action" method="post">
            <table>
                <tr>
                    <td class="row1">科&nbsp;室&nbsp;编&nbsp;号：<input type="text" name="rno" required class="text" placeholder="编号自动生成" disabled="disabled" ></td>
                    <td class="row1">科&nbsp;室&nbsp;名&nbsp;称：<input type="text" name="rname" class="text"  maxlength="20"></td>
                </tr>
                
            	
                <tr>
                    <td class="row2">联&nbsp;系&nbsp;电&nbsp;话：<input type="text" name="rphone" class="text"  placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="18"></td>
                    <td class="row2">医&nbsp;生&nbsp;编&nbsp;号：<input type="text" name="did" class="text"   maxlength="8"></td>
                </tr>
                <tr>
                    <td class="row1">值&nbsp;班&nbsp;时&nbsp;间：<input class="text" type="text" name="rtime" >
                    </td>
                </tr>
            </table>
            <div style="margin:0 auto; width:100px;">
             <input id="submit" type="submit" value="提交">
            </div>
        </form>
    </body>
</html>