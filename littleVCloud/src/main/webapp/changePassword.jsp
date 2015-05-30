<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type"content="text/html;charset=UTF-8"/>
	
	<title>小V云盘 - Setting</title>

	
	<link rel="stylesheet" href="css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/xenon-core.css">
	<link rel="stylesheet" href="css/xenon-forms.css">
	<link rel="stylesheet" href="css/xenon-components.css">
	<link rel="stylesheet" href="css/xenon-skins.css">
	<link rel="stylesheet" href="css/custom.css">

	<script src="js/jquery-1.11.1.min.js"></script>

	
</head>
<body class="page-body login-page">

	
	<div class="login-container">
	
		<div class="row">
		
			<div class="col-sm-6">

				
				
				
				<div class="login-content reg-content">
		</div>
				
				
				
				<!-- Add class "fade-in-effect" for login form effect -->
				<form method="post" id="login" class="login-form fade-in-effect">
					<div class="login-header">
						<a class="logo">
							<img src="images/login.png" alt="" width="130" />
						</a>
								
					</div>	
					
					<!-- Errors container -->
				<div class="errors-container">
				
									
				</div>										
					
					<div class="form-group">
						<label class="control-label" for="useraccount=">旧密码</label>
						<input type="password" class="form-control input-dark" name="username" id="oldPassword" autocomplete="off" />
					</div>
					
					<div class="form-group">
						<label class="control-label" for="passwd">新密码</label>
						<input type="password" class="form-control input-dark" name="passwd" id="password" autocomplete="off" />
					</div>
					
					<div class="form-group">
						<label class="control-label" for="passwd2">再次输入新密码</label>
						<input type="password" class="form-control input-dark" name="passwd2" id="password2" autocomplete="off" />
					</div>										
					
				</form>
				
				<!-- External login -->
				<div class="external-login">
		
					<a onclick = "changePassword(); return false;" href="#" class="twitter">
						<i class="fa-user-md"></i>
						注册
					</a>
                                       
						
				</div>
				
			</div>
			
		</div>
		
	</div>



	<!-- Bottom Scripts -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/TweenMax.min.js"></script>
	<script src="js/resizeable.js"></script>
	<script src="js/joinable.js"></script>
	<script src="js/xenon-api.js"></script>
	<script src="js/xenon-toggles.js"></script>
	<script src="js/jquery-validate/jquery.validate.min.js"></script>
	<script src="js/toastr/toastr.min.js"></script>
	


	<!-- JavaScripts initializations and stuff -->
	<script src="js/xenon-custom.js"></script>

	<!-- JavaScripts initializations and stuff -->
	<script src="js/myregister.js"></script>
	<script type="text/javascript">
					jQuery(document).ready(function($)
					{
						// Reveal Login form
						setTimeout(function(){ $(".fade-in-effect").addClass('in'); }, 1);
						
						
						// Validation and Ajax action
						$("form#login").validate({
							rules: {
								username: {
									required: true
								},
								
								passwd: {
									required: true
								}
							},
							
							messages: {
								username: {
									required: '请输入帐号'
								},
								
								passwd: {
									required: '请输入密码'
								}
							},
							
						});
						
						// Set Form focus
						$("form#login .form-group:has(.form-control):first .form-control").focus();
					});
					</script>
</body>
</html>