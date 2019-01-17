<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/desk/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/desk/css/register.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/desk/css/footer&cbl.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/desk/css/daohang.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/desk/js/jquery-1.11.3.js" ></script>		
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/desk/js/bootstrap.js" ></script>
		<title>注册</title>
	</head>
	<body>
	<div id="main">
		<nav class=" navbar-inverse" id="daohang">
				<div class="daohang">
					<div class="navbar-header clearfix">
						<button type="button" class="zd" id="zd" >
							<span class="glyphicon glyphicon-align-justify"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="daohangtiao">
						<span class="close"><a href="${pageContext.request.contextPath}/renderLogin.do"><i></i></a></span>					
					</div>						
				</div>
				
			</nav>
		<div class="main">
			<div class="container  ">
				<div class="c2">
					<a href=""></a><span>
						<img src="${pageContext.request.contextPath}/static/desk/img/logo.png" />
					</span></a>
					<p>从这里开启读书之旅</p>	
				</div>
				<div class="c3">
					<form id="register_form">
						<div class="form-group">
    						<label for="usernameoremail">电子邮箱 *&nbsp;&nbsp;<span id="error_message" ></span></label>
    						<input type="text" class="form-control" name="uid" id="_uid">
    						<span class="pp hide">此项必须填写</span>
  						</div>
  						<div class="form-group">
    						<label for="password">用户名</label>
    						<input type="text" class="form-control"name="name"  id="_name">
  							<span class="pp hide">此项必须填写</span>
  						</div>
  						<div class="form-group">
    						<label for="password">密码  <img class="help" src="${pageContext.request.contextPath}/static/desk/img/help.png" title="最少6位"/>*</label>
    						<input type="password" class="form-control" name="password" id="_password">
    						<span class="pp hide">此项必须填写</span>
  						</div>
  						<div class="checkbox">
    						<label>
     		 					<input type="checkbox"> 我已经阅读并同意<a>服务条款</a>以及<a>法律声明</a>
    						</label>
  						</div>
  						
					</form>
					<div class="c3-1">
							<button type="button" class="btn btn-default btn1" onclick="register_button()">注册</button>  
							<a href="${pageContext.request.contextPath}/renderLogin.do" type="button" class="btn btn-default btn2">已经有账号了?请登录</a>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	</body>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/desk/js/hp.js" ></script>
	<script type="text/javascript">
	//注册
	function register_button(){
		var uid = $("#_uid").val();
		var name = $("#_name").val();
		var pwd = $("#_password").val();
		var reg = /^[0-9A-Za-z]{6,}$/;
	    if(uid==''){
	    	$("#_uid").next("span").text(" 邮箱不能为空！");
			$("#_uid").next("span").removeClass("hide");
			return;
	    }
	    if(name==''){
	    	$("#_name").next("span").text("用户名不能为空！");
			$("#_name").next("span").removeClass("hide");
			return;
	    }
		/* if(pwd.lengrh<6){
			$("#_password").next("span").text("密码长度不小于六位！");
			$("#_password").next("span").removeClass("hide");
			
			return;
		} */
		
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/user/register.do',
			data:$("#register_form").serialize(),
			dataType:'json',
			success:function(result){
				var info = parseInt(result.code);
				if (info==1) {
					
					window.location = '${pageContext.request.contextPath}/renderLogin.do';
				} else {			
					$("#error_message").text(result.message);
				}
				
			},
			error:function(){
				$("#error_message").text("出现未知错误！");
			}
			
			
		
		});
		
		
	}

	</script>
	
</html>
