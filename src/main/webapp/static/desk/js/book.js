
//页面加载执行
$(function(){
   		
})


/*顶部导航滑过显示*/
$(function(){
	$(".wd1").hover(function(){
		$(".wd2").fadeIn();
		
	},function(){
		$(".wd2").hide();
	})
})
$(function(){
	$(".gy1").hover(function(){
		$(".gy2").fadeIn();
	},function(){
		$(".gy2").hide();
	})
})

/*1秒打开部分滑过显示*/
$(function(){
	$(".c6 a").hover(function(){
		$(this).find("img:first-child").fadeIn();
	},function(){
		$(this).find("img:first-child").fadeOut();
	})
})

/*跟后台连接js*/
$(function(){
	//书籍的搜索功能实现
	$("#btn_search").on("click",function(){
		var searchValue=$("#searchBook").val();
		window.location.href=path+"/deskBook/searchBook.do?key="+searchValue;
	});
	
	
});

//bookDatil
$(function(){
   	$("#bookCommnetBtn").on('click',function()){
   		var bookId = $("#bookId").val();
   		var comment = $("#bookComment").val();
   		$.ajax({
   			type:'post',
   			url:path+'/deskBook/addBookComment.do',
   			data:{'bookId':bookId,'comment':comment},
   			dataType:'json',
   			success:function(data){
   				if(data.code==1){
   					window.reload();
   				}else{
   					alert("保存失败");
   				}
   			}
   		});
   		
   	}
	
})