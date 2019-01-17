<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
 <meta name="viewport" content="width=device-width, initial-scale=1" />
 <link rel="Shortcut Icon" href="${pageContext.request.contextPath }/static/images/title.jpg" type="image/x-icon">
    <link href="${pageContext.request.contextPath}/static/css/cssReset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
    
<script type="text/javascript">
	
</script>
</head>
<body>
<div class="message">
    <img src="${pageContext.request.contextPath}/static/images/logo1.png">
    <p class="p2">ONTEHWAY</p>
    <p class="p1">身体和灵魂，总要有一个在路上</p>
</div>
<div class="navs-slider">
    <a href="#" onclick="_login()" id="nav_login">登录</a>
    <a href="#" onclick="register()" id="nav_register">注册</a>
</div>
<p class="error_message"></p>
<div class="_login"  id="choseLogin">
    <form id="fm" method="post">
        <div class="div1">
            <input type="text" name="username" id="username" placeholder="学号或手机号">
        </div>
        <div class="div2">
            <input type="password"  name="password" id="password" placeholder="密码">
        </div>

    </form>
    <input type="button" value="登录" class="submit1" onclick="login()">
</div>
<div class="_register" style="display: none" id="choseRegister">
    <form id="register_form" method="post">
        <div class="div1">
            <input type="text" name="uid" id="_uid" placeholder="学号或手机号">
        </div>
        <div class="div1">
            <input type="text" name="name"  id="_name" placeholder="昵称或姓名">
        </div>
        <div class="div2">
            <input type="password" name="password" id="_password" placeholder="密码(密码不小于6位)">
        </div>


    </form>
    <input type="button" value="注册sunshine" class="submit1" onclick="register_button()">
</div>

</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/login.js"></script>
<script>
    //登录选择
    function _login(){
    	$(".error_message").text("");
          $("#choseLogin").show();
          $("#choseRegister").hide();
          $("#nav_login").css("color","#eb283e");
          $("#nav_register").css("color","#666");
    }
    //注册选择
    function register(){
    	$(".error_message").text("");
        $("#choseLogin").hide();
        $("#choseRegister").show();
        $("#nav_login").css("color","#666");
        $("#nav_register").css("color","#eb283e");

    }
    
    var loginUrl = 'login.do';
	var successUrl = 'index.do';
	
	function login() {

		$('#fm').form('submit', {
			url : loginUrl,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success) {
					window.location = successUrl;
				} else {			
					$(".error_message").text(result.msg);
				}
			}
		});
	}   
	//注册

	var path = '${pageContext.request.contextPath}';
	
	//注册
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
			url:'${pageContext.request.contextPath}/user/register.do',
			data:$("#register_form").serialize(),
			dataType:'json',
			success:function(result){
				var info = parseInt(result);
				if (info==1) {
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


</script>
</html>