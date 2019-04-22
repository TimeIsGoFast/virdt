 var categoriess;
 var datas =[];
  $(document).ready(function () {
	    $("#main-menu li a").removeClass("active-menu");
		$("#sessionTable").addClass("active-menu");
		
	
		var currentDate = getNowFormatDate();
	    $("#selectDate").val(currentDate);
		sendRequestToRefershBarData(currentDate);
   });
   
   function sendRequestToRefershBarData(currentDate){
  		$.ajax({
    			type:'post',
    			url:path+'/session/refershBarData.do',
    			dataType:'json',
    			data:{'date':currentDate},
    			success:function(result){
    		 	//categoriess = result.categore;
    		    //datas =result.data; 
    			    if(result.categore.length==0){
    			    	console.log("main should be hide")
	   	   		    	//$("#main").hide();
	   		   		 }
 	   		    categoriess = result.categore.split(',');
 	   		    var dataString = result.data.split(',');
 	   		    //datas=[535,1193,1597,496,628];
	    	   		for(var i=0;i<dataString.length;i++) {
	    	   			datas[i] = parseInt(dataString[i]);
	    	   		}
 	   		    console.log("datas="+datas);
 	   		    console.log("categoriess="+categoriess);
 	   		 
	    	   		myChart.setOption({
	    			        xAxis: {
	    			            data: categoriess
	    			        },
	    			        series: [{
	    			            // 根据名字对应到相应的系列
	    			            name: '使用时间 ',
	    			            data:datas
	    			        }]
	    			 });
    			},
    			error:function(){
    				$(".error_message").text("出现未知错误！");
    			}
    			
    		
    		});
   }
   
   function getNowFormatDate() {
       var date = new Date();
       var seperator1 = "-";
       var year = date.getFullYear();
       var month = date.getMonth() + 1;
       var strDate = date.getDate();
       if (month >= 1 && month <= 9) {
           month = "0" + month;
       }
       if (strDate >= 0 && strDate <= 9) {
           strDate = "0" + strDate;
       }
       var currentdate = year + seperator1 + month + seperator1 + strDate;
       return currentdate;
   }
   
   // 基于准备好的dom，初始化echarts实例
   var myChart = echarts.init(document.getElementById('main'));
 
   // 指定图表的配置项和数据
  function fetchData(cb) {
 // 通过 setTimeout 模拟异步加载
	    myChart.hideLoading();
	    setTimeout(function () {
	        cb({
	            categories: categoriess,
	            data: datas
	        });
	    }, 1000);
	}

	// 初始 option
	option = {
		color: ['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83',  '#ca8622', '#bda29a','#6e7074', '#546570', '#c4ccd3'],

	    title: {
	        text: '使用时间柱状图'
	    },
	    tooltip: {},
	    legend: {
	        data:['使用时间']
	    },
	    xAxis: {
	        data: []
	    },
	    yAxis: {},
	    series: [{
	        name: '使用时间',
	        type: 'bar',
	        data: []
	    }]
	};
	
	fetchData(function (data) {
	    myChart.setOption({
	        xAxis: {
	            data: data.categories
	        },
	        series: [{
	            // 根据名字对应到相应的系列
	            name: '使用时间 ',
	            data: data.data
	        }]
	    });
	});

   // 使用刚指定的配置项和数据显示图表。
   myChart.setOption(option);
  
$(function(){
	
	$("#searchBySelectDate").click(function(){
		console.log("start searchBySelectDate");
		var date = $("#selectDate").val();
		sendRequestToRefershBarData(date);
		
	
	});
	
});
 