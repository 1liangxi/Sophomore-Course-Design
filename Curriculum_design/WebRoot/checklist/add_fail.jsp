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
        	alert("此病人或检查项目不存在，请重新输入。");
        </script>
    </head>
    <body>
        <div id="P_base">基本信息</div>
        <form action="../checklist/CheckList_add.action" method="post">
            <table>
                <tr>
                    <td class="row1">检&nbsp;查&nbsp;单&nbsp;号：<input type="text" name="did" required class="text" placeholder="编号自动生成" disabled="disabled"></td>
                    <td class="row1">检查项目号：<input type="text" name="dname" class="text"  required  maxlength="20"></td>
                </tr>
                
            	
                <tr>
                    <td class="row2">病&nbsp;人&nbsp;编&nbsp;号：<input type="text" name="didcard" class="text"  placeholder="请输入数字" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="18"></td>
                    <td class="row2">检&nbsp;查&nbsp;费&nbsp;用：<input type="text" name="djod" class="text"  maxlength="8"></td>
                </tr>
                
            </table>
            <div style="margin:0 auto; width:100px;">
             <input id="submit" type="submit" value="提交">
            </div>
        </form>
    </body>
</html>