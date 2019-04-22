
 var tables;

   $(document).ready(function () {
	   tables = $("#dataTables-example").myDataTableUtil('#dataTables-example', path+'/session/getPage.do', 'post',
				[
		            {"data": 'userName' },
		            {"data": 'fullName' },
		            {"data": 'machineName' },
		            {"data": 'computerName' },
		            {"data": 'startDate' },
		            {"data": 'endDate' },
		            {"data": 'timeDiff' }           
		        ])
		tables.fnDraw(false); 
	   /* $('#dataTables-example').dataTable();*/
	    /*$("#dataTables-example").dataTable();*/
	    $("#main-menu li a").removeClass("active-menu");
		$("#sessionInfo").addClass("active-menu");
		
   });
  
$(function(){
	
	
	$("#exportBtn").click(function(){
		
		var deskgroupId = $("#desktopId").val();
		var passTime = $("#pass_time").val();
		/*$.ajax({
			type:'post',
			url:path+'/session/export.do',
			dataType:'json',
			data:{'passTime':passTime,'deskgroupId':deskgroupId},
			success:function(result){
		
			},
			error:function(){
				$(".error_message").text("出现未知错误！");
			}		
			
		});*/
		window.location.href=path+"/session/export.do?deskgroupId="+deskgroupId+"&passTime="+passTime;
		rel="external nofollow"
	});
	$("#searchByAddition").click(function(){
		
		var deskgroupId = $("#desktopId").val();
		var passTime = $("#pass_time").val();
		console.log("deskgroupId="+deskgroupId+",passTime="+passTime);
		window.location.href=path+"/session/render.do?deskgroupId="+deskgroupId+"&passTime="+passTime;
	});
	

	
});
 