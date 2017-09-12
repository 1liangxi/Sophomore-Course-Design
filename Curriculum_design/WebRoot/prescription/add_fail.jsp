<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <head>
    	<script type="text/javascript">
    		alert("该病人或药品不存在，请重新输入");
    	</script>
        <link rel="stylesheet" type="text/css" href="../css/addstyle.css">
    </head>
    <body>
        <div id="P_base">基本信息</div>
        <form action="../prescription/Prescription_add.action" method="post">
            <table>
                <tr>
                    <td class="row1">处&nbsp;方&nbsp;单&nbsp;号：<input type="text" name="pno" required class="text" placeholder="编号自动生成" disabled="disabled" maxlength="18"></td>
                    <td class="row1">病&nbsp;人&nbsp;编&nbsp;号：<input type="text" name="pid" class="text" maxlength="20"></td>
                </tr>
                
            	
                <tr>
                    <td class="row2">药&nbsp;品&nbsp;编&nbsp;号：<input type="text" name="mno" class="text"  class="text" ></td>
                    <td class="row2">收&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费：<input type="text" name="price" class="text" maxlength="8"></td>
                </tr>
            </table>
            <div style="margin:0 auto; width:100px;">
             <input id="submit" type="submit" value="提交">
            </div>
        </form>
    </body>
</html>