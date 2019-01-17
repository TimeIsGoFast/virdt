 $(document).ready(function () {
   /* $('#dataTables-example').dataTable();*/
    $("#dataTables-example").dataTable().fnDraw(false);  
    $("#main-menu li a").removeClass("active-menu");
	$("#bookInfo").addClass("active-menu");
	
	
});
 function _deleteBook(id){
	    $("#deleteUserId").val(id);
		$('#deleteModal').modal('show');
}
	
function bookDetail(id){
	window.location.href=path+"/book/bookDetail/"+id+".do";
}
 $(function(){
	$("#deleteBook2").click(function(){
		var id = $("#deleteUserId").val();
		$.ajax({
			type:'post',
			url:path+'/book/deleteBook.do',
			data:{'id':id},
			dataType:'json',
			success:function(data){
				if(data.code==1){
					$('#deleteModal').modal('hide');
					window.location.reload();
				}
			},
		});
			
			
	}); 
	

 });