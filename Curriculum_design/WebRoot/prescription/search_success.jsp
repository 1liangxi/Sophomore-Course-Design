<%@page import="entity.Medicine"%>
<%@page import="service.impl.MedicineDAOimpl"%>
<%@page import="service.MedicineDAO"%>
<%@page import="entity.Patient"%>
<%@page import="service.impl.PrescriptionDAOimpl"%>
<%@page import="entity.Prescription"%>
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
         #search
            {
                padding: 10px 4px;
                width: 600;
                border: 1px solid #bababa;
                border-radius: 2px;
            }
            #search1
            {
                color: snow;
                width: 70;
                height: 34;
                background-color: #6ea1fc;
                border: 1px;
                border-radius:3px;
                margin: 0 10;
                cursor: pointer;
            }
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
    	<div width="100%">
            <form action="../prescription/Prescription_searchDoctor.action" method="post">
                <input id="search" type="text" placeholder="输入医生编号/医生姓名" name="search">
                <input type="submit" id="search1" value="查找">
            </form>
        </div>
    <form id="myform" action="<%=path %>/prescription/Prescription_delectAll.action">
        <table class="table table-bordered table-hover" width="100%">
            <tr>
            	<th><input class="check-all check" type="checkbox">全选</th>
                <th>处方单号</th>
                <th>病人编号</th>
                <th>病人姓名</th>
                <th>药品编号</th>
                <th>药品名称</th>
                <th>价格</th>
                <th>操作</th>
            </tr>
            <%
            	int i,j,k=0,size,max = 14;
            	List<Prescription> list = (List)session.getAttribute("Prescription_List");
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
            			Prescription p = list.get(i);
            	
            %>
           	
            <tr class="list">
            	<td><input name="checkbox" value="<%=p.getPno() %>" class="check-only check" type="checkbox"></td>
                <td><a href="<%=path %>/prescription/Prescription_queryByPno.action?pno=<%=p.getPno() %>"><%=p.getPno() %></td>
                <td><%=p.getPid() %></td>
                <%
                	PatientDAOimpl pdao = new PatientDAOimpl();
                	Patient pa = pdao.queryPatientByPid(p.getPid());
                %>
                <td><%=pa.getPname() %></td>
                <td><%=p.getMno() %></td>
                <%
                	MedicineDAOimpl mdao = new MedicineDAOimpl();
                	Medicine m = mdao.queryMedicineByMno(p.getMno());
                %>
                <td><%=m.getMname() %></td>
                <td><%=p.getPrice() %></td>
                <td><a href="<%=path %>/prescription/Prescription_delete.action?pno=<%=p.getPno() %>">删除</a></td>
                
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
            <form action="../prescription/Prescription_query.action">
            <span><a href = "../prescription/Prescription_query.action" >首页</a></span>
            <span><a href = "../prescription/Prescription_query_success.jsp?pagenum=<%=pagenum-1 %>" >上一页</a></span>
            <span>
		          <input id="pageselect" type="text" name="pagenum" value="<%=pagenum %>" style="width:30px;height:20px;text-align:center;">
		      </span>
            <span><a  href = "../prescription/Prescription_query_success.jsp?&pagenum=<%=1+pagenum %>">下一页</a></span>
            <span><a href = "../prescription/Prescription_query_success.jsp?&pagenum=<%=size/max+1 %>" >尾页</a></span>
            <span>第<strong><%=pagenum %></strong>页&nbsp;&nbsp;共<strong><%=size/max+1 %></strong>页</span>
            </form>
        </div>
        
    </body>
</html>
