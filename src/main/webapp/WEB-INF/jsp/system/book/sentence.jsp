<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
 <link href="${pageContext.request.contextPath }/static/css/cssReset.css" rel="stylesheet">
 <link href="${pageContext.request.contextPath }/static/css/liuyan.css" rel="stylesheet">

 <title>好句</title>
 <div class="header"> 
              <h1 class="page-header">
              </h1>
     
		 </div>
<div class="liuyan">
    <p class="p1">添加你要说的话</p>

        <textarea class="neirong" name="str" id="neirong"></textarea>
        <a href="#" onclick="submitMessage()">
        <div class="submit1">
            <p>发布</p>
        </div>
        </a>
</div>
<!-- <div class="daohang">
    <ul>
        <li><a href="#">全部</a></li>
        <li><a href="#">我的留言</a></li>
    </ul>

</div> -->
<div class="box" id="box">
  <p class="p1">内容</p>
  <br>
</div>
<div class="loading" id="load1">
<div class="div1">
 <%--  <img src="${pageContext.request.contextPath }/static/images/load.gif"> --%>
 <a onclick="loadMore()"> <div style="margin:auto;">点击加载更多</div></a>
</div>  
</div>
<div class="loading" id="load2" style="display:none;">
<div class="div1">
  <div style="float:left;margin:3px;"> &nbsp;&nbsp;&nbsp;&nbsp;已全部加载</div>
</div>  
</div>

<script>
 $(document).ready(function(){
	 $("#sentence").addClass("active-menu"); 
	 initMessage(1,10);
	 $("#load1").show();
	 $("#load2").hide();
	
 });
 var page =1;
 var rows =10;
 /* $(window).scroll(function () {
	    if ($(document).scrollTop() + $(window).height() >= $(document).height()) {
	    	page++;	       
	        initMessage(page,rows);
	        
	    }
	}); */
 function loadMore(){
	 page++;	       
     initMessage(page,rows);
 }
 //展示消息列表
 function initMessage(page,rows){
	 var str;
	 $.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/book/getSentenceData.do',
		data:{'page':page,'rows':rows},
		dataType:'json',
		success:function(data){
			if(data.length<rows){
				$("#load1").hide();
				$("#load2").show();
			}
			console.log(data);
			 $.each(data, function (i, item) { 
				 var img = item.headimg;
				 $("#box").append('<div class="center">'+
					      '<div class="wenzi">'+
					          '<p class="name">'+item.uid+'</p>'+
					          '<p class="time">'+item.creatTime+'</p>'+
					          '<p class="text">'+item.content+'</p>'+
					      '</div>'+

					  '</div>'+
					      '<div class="pinglun">'+
				        '<button class="pinglun_button" ></button>'+
				        '<div class="text"></div>'+
				    '</div>'
						);
		        });  
			

		},
		error:function(){
		   alert("请求失败");
		},
		 
	 });
	 
	 
 }
 
 
 function submitMessage(){
	 var str = $("#neirong").val();
	if(str==""){
		alert("留言不能为空！");
		return;
	}
	 $.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/book/addSentence.do',
			data:{'content':str},
			dataType:'json',
			success:function(data){
				var info=parseInt(data.code);
				if(info==1){
					window.location.reload(); 
				}
				if(info==0){
					alert("留言失败!");
				}

			},
			error:function(){
			   alert("请求失败");
			},
			 
		 });
		 
	
 }

</script>
