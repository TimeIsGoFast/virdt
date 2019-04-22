<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会话管理</title>
     <!-- Google Fonts-->
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
     <link href="${pageContext.request.contextPath}/static/css/input_date.css" rel="stylesheet" />
</head>

<p></p>
	<div class="row">
	<label for="selectDate">选择日期：</label><input style="border-radius:5%;height:25px;" id="selectDate" type="date" />&nbsp;&nbsp;&nbsp;<button type="button" style="height:25px;line-height:25px;padding:0px 5px;" class="btn btn-primary" id="searchBySelectDate">查询</button>
		 <div id="main" style="width: 80%;height:500px;margin-top:10px;"></div>
	</div>
    <script src="${pageContext.request.contextPath}/static/assets/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/echarts/echarts.min.js"></script>
<%--     <script src="${pageContext.request.contextPath}/static/js/dataTable-util.js"></script> --%>
    <script src="${pageContext.request.contextPath}/static/js/sessionTable.js"></script>
   
	


