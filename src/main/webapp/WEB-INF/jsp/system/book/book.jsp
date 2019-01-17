<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍管理</title>
     <!-- Google Fonts-->
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
		  <div class="header"> 
              <h1 class="page-header">
                  <a href="${pageContext.request.contextPath }/book/bookDetail/0.do" class="btn btn-info">添加书籍</a>
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
                                            <th>书名</th>
                                            <th>作者</th>
                                            <th>书籍类别</th>
                                            <th>出版社</th>
                                            <th>价格</th>
                                            <th>出版日期</th>
                                            <th>热门等级</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${list}" var="Book">
                                            <tr class="odd gradeX">
                                            <td>${Book.bookName }</td>
                                            <td>${Book.author }</td>
                                            <td>${Book.bookType }</td>
                                            <td class="center">${Book.publics }</td>
                                            <td class="center">${Book.price }</td>
                                            <td class="center">${Book.publicDate }</td>
                                            <td class="center">${Book.grade }</td>
                                            <td align="center">
                                            <button class="btn btn-primary" title='详情' onclick="bookDetail('${Book.id}')" data-toggle="modal" data-target="#myModal"><i class="fa fa-book "></i></button>
                                            <button class="btn btn-danger" title='删除' onclick="_deleteBook('${Book.id}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
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
                                            <button type="button" class="btn btn-primary" id="deleteBook2">确认</button>
                                        </div>
                                    </div>
                                </div>
              </div>       
    <script src="${pageContext.request.contextPath}/static/assets/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/book.js"></script>
    

