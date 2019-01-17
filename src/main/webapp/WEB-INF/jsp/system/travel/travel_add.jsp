<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<link href="${pageContext.request.contextPath}/static/assets/css/select2.min.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/static/assets/css/checkbox3.min.css" rel="stylesheet" >
<title>图书详情</title>
</head>
  <div class="header"> 
         <h1 class="page-header">
         <a href="${pageContext.request.contextPath}/travel/render.do" class="btn btn-default btn-sm"><i class="fa fa-mail-reply"></i>&nbsp;返回</a>
         </h1>
    
  </div>
   <div class="row">
           <div class="col-xs-12">
               <div class="panel panel-default">
                   <div class="panel-heading">
                       <div class="card-title">
                           <div class="title">添加旅行地点</div>
                       </div>
                   </div>
                   <div class="panel-body">
                       <form  action="${pageContext.request.contextPath}/travel/travelAddOrUpdate.do" method="post" enctype="multipart/form-data">
                       <div >
                              <input type="hidden" name="id" id="bookId" value="">
                              <div class="form-group">
                                  <label for="exampleInputName2">景点名称&nbsp;&nbsp;</label>
                                  <input type="text" class="form-control" id="exampleInputName2" placeholder=""  name="touristName"  value="">
                              </div>
                              <div class="form-group">
                                  <label for="exampleInputEmail2">所在城市&nbsp;&nbsp;</label>
                                  <input type="text" class="form-control" id="exampleInputEmail2" placeholder="" name="city" value="">
                              </div>
                              <div class="form-group">
                                  <label for="exampleInputEmail2">具体地点&nbsp;&nbsp;</label>
                                  <input type="text" class="form-control" id="exampleInputEmail2" placeholder="" name="address" value="">
                              </div>
                              <div class="form-group">
                                  <label for="exampleInputEmail2">附近机场&nbsp;&nbsp;</label>
                                  <input type="text" class="form-control" id="exampleInputEmail2" placeholder="" name="airport" value="">
                              </div>
                               <div class="form-group">
                                  <label for="exampleInputEmail2">大概所需价格&nbsp;&nbsp;</label>
                                  <input type="text" class="form-control" id="exampleInputEmail2" placeholder="￥" name="price" value="">
                              </div>
                             
                        </div>
                        <br>
                        <div class="form-inline">
                            
                               <div class="form-group">
                                  <label for="exampleInputEmail2">热门程度&nbsp;&nbsp;</label>
                                    <input type="hidden" id="gradeSelectHidden"  value="${travel.grade}">
                           				<select id="gradeSelect" class="selectbox" name="grade" style="color:green" >
                                   		  <option value="1" >等级一</option>
                                  	      <option value="2" >等级二</option>
                                  	      <option value="3" >等级三</option>
                                  	      <option value="4" >等级四</option>
                                  	      <option value="5" >等级五</option>
                          				</select>
                               </div>
                               
                             
                        </div>
                        
                       <div class="sub-title">简介</div>
                       <div>
                           <textarea class="form-control" name="remark" rows="3"></textarea>
                       </div>
                     <div class="panel-body">
                         <div class="card-title" style="font-size:20px;padding:10px 0px;">
                             <div class="title">封面上传  <c:if test="${not empty travel.picUrl}">
                      	   已有图片
                      	  </c:if></div>
                     
                         </div>
                             <div class="form-group">
                             <input type="file" name="travel_pic" id="exampleInputFile">
                             <p class="help-block">支持jpg、png等格式上传</p>
                         </div>
                      	
                      	
                        
                     </div>
                        <br>
                       <div style="float:right;margin-right:30px;">
                       <button type="submit" class="btn btn-primary" id="travelAddOrUpdate">提交</button>
                       </div>
                       </form>
                   </div>
               </div>
           </div>
       </div>
   

    <script src="${pageContext.request.contextPath}/static/assets/js/jquery.metisMenu.js"></script>
	<script src="${pageContext.request.contextPath}/static/assets/js/select2.full.min.js"></script>
	<script type="text/javascript">
	$("#bookType").val(${Book.bookType});
	</script>
      <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/static/js/travel_add.js"></script> 
    <script src="${pageContext.request.contextPath}/static/assets/js/custom-scripts.js"></script> 
	
</html>