
 
$(function(){
	$("#searchByAddition").click(function(){
		
		var deskgroupId = $("#desktopId").val();
		var passTime = $("#pass_time").val();
		console.log("deskgroupId="+deskgroupId+",passTime="+passTime);
		window.location.href=path+"/session/render.do?deskgroupId="+deskgroupId+"&passTime="+passTime;
	});
	
	$("#searchBySelectDate").click(function(){
		console.log("start searchBySelectDate");
		var date = $("#selectDate").val();
		sendRequestToRefershBarData(date);
		
	
	});
	
});
 