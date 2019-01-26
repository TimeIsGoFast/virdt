<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会话管理</title>
     <!-- Google Fonts-->
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>

			  <div class="header"> 
              <h1 class="page-header">
                  <a href="${pageContext.request.contextPath }/session/current.do" class="btn btn-info">实时运行数据</a>
              </h1>
     
		 </div>
  
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>用户</th>
                                            <th>用户全称</th>
                                            <th>计算机名称</th>
                                            <th>交付组</th>
                                            <th>会话开始时间</th>
                                            <th>会话结束时间</th>
                                            <th>会话时长</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${list}" var="Session">
                                            <tr class="odd gradeX">
                                            <td>${Session.userName}</td>
                                            <td>${Session.fullName}</td>
                                            <td>${Session.machineName}</td>
                                            <td>${Session.computerName}</td>
             								<td><fmt:formatDate value="${Session.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
             								<c:choose>
             									<c:when test="${empty Session.endDate}">
             										<td>正在运行</td>
             									</c:when>
             									<c:otherwise>
             										 <td><fmt:formatDate value="${Session.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>                             					
             									</c:otherwise>
             								</c:choose>
                                           
                                            <td class="center">${Session.timeDiff }</td>
                                          
                                            <td align="center">
                                            <button class="btn btn-primary" title='编辑' data-toggle="modal" data-target="#myModal"><i class="fa fa-edit "></i></button>
                                            <button class="btn btn-danger" title='删除' onclick="deleteUser('${User.id}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                                  
                                            </td>
                                        </tr>
                                         </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div> 
            <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">删除记录</h4>
                                        </div>
                                        <div class="modal-body">
                                           <input type="hidden" value="" id="deleteUserId">
                                                                                                           确认删除这条记录？
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                            <button type="button" class="btn btn-primary" id="deleteUser2">确认</button>
                                        </div>
                                    </div>
                                </div>
              </div>       
    <script src="${pageContext.request.contextPath}/static/assets/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/session.js"></script>
    

