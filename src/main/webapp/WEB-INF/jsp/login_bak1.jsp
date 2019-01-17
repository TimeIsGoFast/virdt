<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/desk/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/desk/css/login.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/desk/css/footer&cbl.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/desk/css/daohang.css" />
		<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.min.js"></script>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/desk/js/bootstrap.js" ></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/static/desk/js/templet.js" ></script>
		<title>登录</title>
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
						<span class="close"><a href="index.html"><i></i></a></span>					
					</div>						
				</div>
			</nav>
			<div class="main">	
			<div class="container">
				<div class="c2">
					<a href=""></a><span>
						<img src="${pageContext.request.contextPath}/static/desk/img/logo.png" />
					</span>
					<p>从这里开启精彩的人生</p>	
				</div>
				<div class="c3">
					<form id="fm">
						<div class="form-group">
    						<label for="usernameoremail">用户名或邮箱&nbsp;&nbsp;<span id="error_message" ></span></label>
    						<input type="text" class="form-control" name="username" id="username">
  						</div>
  						<div class="form-group">
    						<label for="password">密码</label>
    						<input type="password" class="form-control" name="password" id="password">
  						</div>
  						<div class="checkbox">
    						<label>
     		 					<input type="checkbox" name="rememberMe" id="rememberMe"> 记住我（请在私人计算机上使用此功能）
    						</label>
  						</div>
  						<div class="c3-1">
							<button id="denglu" type="button" class="btn btn-default btn1" onclick="login()">登录</button>  
							<a href="${pageContext.request.contextPath}/register.do" type="button" class="btn btn-default btn2">注册</a>
						</div>
						
						<div class="c3-3 clearfix">
							<a href="" class="pull-right">忘记密码？点这里找回</a>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		</div>		
	</body>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.easyui.min.js"></script>
	<script>
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
					$("#error_message").text(result.msg);
				}
			}
		}); 
	
		}   
	</script>
</html>
