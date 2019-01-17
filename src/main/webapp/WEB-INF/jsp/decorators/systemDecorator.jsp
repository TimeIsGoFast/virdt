<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="on the way" name="description" />
    <meta content="webthemez" name="author" />
    <title>
    <sitemesh:write property='title'/>
    </title>
	<!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/static/assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/static/assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/static/assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <link href="${pageContext.request.contextPath}/static/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.min.js"></script>
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">VIRTUAL DESKTOP</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.do"><strong><i class="icon fa fa-plane"></i>VIRTUAL DESKTOP</strong></a>
				<div id="sideNav" href="">
		<i class="fa fa-bars icon"></i> 
		</div>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> 个人信息</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/logout.do"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                </li>
                &nbsp;&nbsp;&nbsp;
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                  <ul class="nav" id="main-menu">
					<li>
                        <a id="_index" href="${pageContext.request.contextPath}/index.do" id="dashboard"><i class="fa fa-dashboard"></i>主页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/user/render.do" id="userManage"><i class="fa fa-users"></i>用户管理</a>
                    </li>
                     <li>
                        <a href="${pageContext.request.contextPath}/session/render.do" id="bookInfo"><i class="fa fa-book"></i>会话记录</a>
                    </li>
             <%--        <li>
                        <a href="${pageContext.request.contextPath}/travel/render.do" id="touristInfo"><i class="fa fa-map-marker"></i>会话记录</a>
                    </li>
				
                    <li>
                        <a href="${pageContext.request.contextPath}/book/getSentencePage.do" id="sentence"><i class="fa fa-edit"></i>虚拟机</a>
                    </li>
                    
                    <li>
                        <a href="#"><i class="fa fa-table"></i>管理员审核</a>
                    </li> --%>
                   
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
		  <div class="header"> 
               <sitemesh:write property='body'/>						
		</div>
            <div id="page-inner"> 
				 <footer><p style="text-align:center">Copyright &copy; 2017.Company name weilongzeng rights reserved.</p></footer>
			</div>
         </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
      <!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath}/static/assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/static/assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
      <script src="${pageContext.request.contextPath}/static/assets/js/custom-scripts.js"></script>
</body>
<script type="text/javascript">
  var path = '${pageContext.request.contextPath}';
</script>
</html>