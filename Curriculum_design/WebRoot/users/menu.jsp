<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
        <Meta http-equiv=” Content-Type” Content=” text/html; Charset=utf-8″/>
        <link rel="stylesheet" href="../css/menustyle.css" type="text/css">
    </head>
    <body>
        <details open>
            <summary>病人档案</summary>
            <ul>
                <a href="../patient/Patient_query.action" target="main"><li>查看所有档案</li></a>
                <a href="../patient/Br_query_single.jsp" target="main"><li>查找档案</li></a>
                <a href="../patient/add_Patient.jsp" target="main"><li>新增档案</li></a>
            </ul>
        </details>

        <details open>
            <summary>医生信息</summary>
            <ul>
                <a href="../doctor/Doctor_query.action" target="main"><li>查询所有医生</li></a>
                <a href="../doctor/Doctor_query_single.jsp" target="main"><li>查找医生</li></a>
                <a href="../doctor/add_Doctor.jsp" target="main"><li>新增医生信息</li></a>
            </ul>
        </details>
        <details open>
            <summary>科室信息</summary>
            <ul>
                <a href="../room/Room_query.action" target="main"><li>查询所有科室</li></a>
                <a href="../room/Room_query_single.jsp" target="main"><li>查找科室</li></a>
                <a href="../room/add_Room.jsp" target="main"><li>新增科室</li></a>
            </ul>
        </details>
        <details open>
            <summary>挂号单</summary>
            <ul>
                <a href="../gualist/GuaList_query.action" target="main"><li>所有挂号单</li></a>
                <a href="../gualist/GuaList_query_single.jsp" target="main"><li>查找挂号单</li></a>
                <a href="../gualist/add_GuaList.jsp" target="main"><li>新增挂号单</li></a>
            </ul>
        </details>
        <details open>
            <summary>检查单</summary>
            <ul>
                <a href="../checklist/CheckList_query.action" target="main"><li>所有检查单</li></a>
                <a href="../checklist/CheckList_query_single.jsp" target="main"><li>查找检查单</li></a>
                <a href="../checklist/add_CheckList.jsp" target="main"><li>录入检查单</li></a>
            </ul>
        </details>
        <details open>
            <summary>处方单</summary>
            <ul>
                <a href="../prescription/Prescription_query.action" target="main"><li>所有处方单</li></a>
                <a href="../prescription/Prescription_query_single.jsp" target="main"><li>查找处方单</li></a>
                <a href="../prescription/add_Prescription.jsp" target="main"><li>录入处方单</li></a>
            </ul>
        </details>
        <details open>
            <summary>医疗项目</summary>
            <ul>
                <a href="../checkproject/CheckProject_query.action" target="main"><li>所有医疗项目</li></a>
                <a href="../checkproject/CheckProject_query_single.jsp" target="main"><li>查找医疗项目</li></a>
                <a href="../checkproject/add_CheckProject.jsp" target="main"><li>新增医疗项目</li></a>
            </ul>
        </details>
        <details open>
            <summary>药品</summary>
            <ul>
                <a href="../medicine/Medicine_query.action" target="main"><li>所有药品</li></a>
                <a href="../medicine/Medicine_query_single.jsp" target="main"><li>查询药品</li></a>
                <a href="../medicine/add_Medicine.jsp" target="main"><li>新增药品</li></a>
            </ul>
        </details>
        
    </body>
</html>