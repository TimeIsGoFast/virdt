$(document).ready(function() {
	$("#touristInfo").addClass("active-menu");
	 var selectValue=  $("#gradeSelectHidden").val();
	 if(selectValue!=""){
	 $("#gradeSelect").val(selectValue);
	 }
	 
/*	$("#bookAddOrUpdate").click(function(){
		
		//验证
		$.ajax({
		    type: 'post',
		    url: path+"/book/bookAddOrUpdate.do",
		    dataType:'json',
		    data: $("#bookInfoForm").serialize(),
		    success: function(data) {
		        console.log(data);
		    }
		});
	}); */
});