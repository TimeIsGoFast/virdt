var tables;
$(document).ready(function () {
	tables = $("#dataTables-example").myDataTableUtil('#dataTables-example', path+'/deskUser/getPage.do', 'post',
		[
            {"data": 'id' },
            {"data": 'userName' },
            {"data": 'fullName' },
            {"data": 'upn' },
            {"data": 'domain' },
            {"data": 'creatDate' },
            {"data": 'modifiedDate' }
        ])
    tables.fnDraw(false);  
    $("#main-menu li a").removeClass("active-menu");
	$("#userManage").addClass("active-menu");
	
	
});
 function deleteUser(id){
	    $("#deleteUserId").val(id);
		$('#deleteModal').modal('show');
}
 $(function(){
	$("#deleteUser2").click(function(){
		var id = $("#deleteUserId").val();
		$.ajax({
			type:'post',
			url:path+'/user/deleteUser.do',
			data:{'id':id},
			dataType:'json',
			success:function(data){
				if(data==1){
					$('#deleteModal').modal('hide');
					window.location.reload();
				}
			},
		});
			
			
	}); 
 });