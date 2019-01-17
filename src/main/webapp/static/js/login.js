function register_button(){
	var uid = $("#_uid").val();
	var name = $("#_name").val();
	var pwd = $("#_password").val();
	var reg = /^[0-9A-Za-z]{6,}$/;

	if(!uid.match("\\d+")){
		$(".error_message").text("账号必须为数字！");
		return;
	}
	if(!reg.test(pwd)){
		$(".error_message").text("密码长度不小于六位！");
		return;
	}
	
	$.ajax({
		type:'post',
		url:path+'/user/register.do',
		data:$("#register_form").serialize(),
		dataType:'json',
		success:function(result){
			if (result.code==1) {
				$("#username").val(uid);
				$("#password").val(pwd);
				_login();
				
			} else {			
				$(".error_message").text("该账号已被注册！");
			}
			
		},
		error:function(){
			$(".error_message").text("出现未知错误！");
		}
		
		
	
	});
	
	
}
