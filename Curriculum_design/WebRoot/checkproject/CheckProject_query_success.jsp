<%@page import="entity.CheckProject"%>
<%@page import="service.impl.PatientDAOimpl"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
        <style>
            *
            {
                padding: 5px;
            }
            th
            {
                text-align: center;
                background-color: #1ea0d9;
                color: snow;
            }
            table
            {
                text-align: center;
                font-size: 14px;
                
            }
        </style>
        <%
        	int pagenum=1;
        	String page1=null;
        %>
        <%
        	page1 = request.getParameter("pagenum");
	        if(page1==null)
	  		{
	  			page1 = "1";
	  		}
	  		pagenum = Integer.parseInt(page1);
        %>
        <script type="text/javascript">
        		window.onload = function checkAll()
            	{
            		
            		var checkInput = document.getElementsByClassName('check');
            		var checkAllInput = document.getElementsByClassName('check-all');
            		var checkOnlyInput = document.getElementsByClassName('check-only');
            		var select = document.getElementById("ts");
            		select.innerHTML = 0;
            		function js()
            		{
            			var a=0;
            			for(var i =0,len = checkOnlyInput.length;i<len;i++)
            				{
            					if(checkOnlyInput[i].checked)
            						{
            							a++;		
            						}
            				}
            			select.innerHTML = a;
            		}
            		for(var i = 0,len = checkInput.length;i<len;i++)
            			{
            				checkInput[i].onclick = function ()
            				{
            					if(this.className == 'check-all check')
            						{
            							for(var j = 0;j<checkInput.length;j++)
            								{
            									checkInput[j].checked = this.checked;
            								}
            						}
            					if(this.checked == false)
                                {
                                    checkAllInput[0].checked = false;
                                    checkAllInput[1].checked = false;
                                }
            					js();
            				}
            				
            			}
            	}
        </script>
    </head>
    <body>
    <div id="table">
    <form id="myform" action="<%=path %>/checkproject/CheckProject_delectAll.action">
        <table class="table table-bordered table-hover" width="100%">
            <tr>
            	<th><input class="check-all check" type="checkbox">全选</th>
                <th>检查项目编号</th>
                <th>检查项目名称</th>
                <th>检查费用</th>
                <th>检查说明</th>
                <th>操作</th>
            </tr>
            <%
            	int i,j,k=0,size,max = 14;
            	List<CheckProject> list = (List)session.getAttribute("CheckProject_List");
            	size = list.size();
            	if(pagenum==1)
            	{
            		j = 0;
            	}
            	else
            	{
            		j = (pagenum-1)*max;
            	}
            	if(j>size-max)
            	{
            		j = size-max;
            		pagenum = size/max+1;
            	}
            	if(j<0)
            	{
            		j = 0;
            		pagenum = 1;
            	}
            	if(list.size()>0)
            	{
            		for(i=j;i<list.size();i++)
            		{
            			k++;
            			if(k>max)
            				break;
            			CheckProject p = list.get(i);
            	
            %>
           	
            <tr class="list">
            	<td><input name="checkbox" value="<%=p.getCno() %>" class="check-only check" type="checkbox"></td>
                <td><%=p.getCno() %></td>
                <td><%=p.getCname() %></td>
                <td><%=p.getMoney() %></td>
                <td><%=p.getNotes() %></td>
                
                
                <td><a href="<%=path %>/checkproject/CheckProject_delete.action?did=<%=p.getCno() %>">删除</a></td>
                
            </tr>
            <% 
            		}
            	}
            %>
            
        </table>
        </form>
        <nav class="navbar navbar-default">
        	<script type="text/javascript">
        		function delect()
        		{
        			var com = window.confirm("是否要删除");
        			if(com==true)
        				{
        					document.getElementById("myform").submit();
        				}
        		}
        	</script>
            <input name="checkbox" style="vertical-align:middle; margin:14px 14px;"class="check-all check" type="checkbox">
            <span style="vertical-align:middle;margin:-18" >全选</span>
            <span style="margin:360">已选择<strong id="ts"></strong>条数据</span>
            <button style="float:right;margin:5px 14;" class="btn btn-danger" onclick="delect()">删除</button>
        </nav>
        </div>
        <div style="margin:0px auto;width:420px;">
            <form action="../checkproject/CheckProject_query.action">
            <span><a href = "../checkproject/CheckProject_query.action" >首页</a></span>
            <span><a href = "../checkproject/CheckProject_query_success.jsp?pagenum=<%=pagenum-1 %>" >上一页</a></span>
            <span>
		          <input id="pageselect" type="text" name="pagenum" value="<%=pagenum %>" style="width:30px;height:20px;text-align:center;">
		      </span>
            <span><a  href = "../checkproject/CheckProject_query_success.jsp?&pagenum=<%=1+pagenum %>">下一页</a></span>
            <span><a href = "../checkproject/CheckProject_query_success.jsp?&pagenum=<%=size/max+1 %>" >尾页</a></span>
            <span>第<strong><%=pagenum %></strong>页&nbsp;&nbsp;共<strong><%=size/max+1 %></strong>页</span>
            </form>
        </div>
        
    </body>
</html>
