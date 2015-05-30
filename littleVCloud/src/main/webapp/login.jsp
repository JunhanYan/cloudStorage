<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type"content="text/html;charset=UTF-8"/>
	
	<title>小V云盘 - Login</title>

	
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
					
					
					
					function login(){
						if($('#userAccount').val()==''||$('#password').val()==''){
							$('.errors-container').html("用户名或密码不能为空");
						}else{
						    $.ajax({
						            url: 'http://localhost:8080/littleVCloud/login.do',
						            dataType: 'json',
						            type: 'POST',
						            contentType:'application/json;charset=UTF-8',
						            data: JSON.stringify({userAccount : $('#userAccount').val(),			
						            	password : $('#password').val()})
						           })
						            .success(function (data, status, headers, config) {           	
						            											
											addCookie("userName",data.userName,7,"/");
											addCookie("userAccount",data.userAccount,7,"/");
											addCookie("userPass",data.password,7,"/");
											addCookie("userId",data.userId,7,"/");
									
						            		 window.location.href = 'myresource.jsp';						            
						            		
						            	
						            		
						            })
						            .error(function (data, status, headers, config) {
						            	$('.errors-container').html("用户名或密码不正确，请重新输入");
					            		
						            });
						}     
					  
					}
					
					function addCookie(name,value,days,path){	/**添加设置cookie**/
						var name = escape(name);
					    var value = escape(value);
					    var expires = new Date();
						expires.setTime(expires.getTime() + days * 3600000 * 24);
						//path=/，表示cookie能在整个网站下使用，path=/temp，表示cookie只能在temp目录下使用
						path = path == "" ? "" : ";path=" + path;
						//GMT(Greenwich Mean Time)是格林尼治平时，现在的标准时间，协调世界时是UTC
						//参数days只能是数字型
						var _expires = (typeof days) == "string" ? "" : ";expires=" + expires.toUTCString();
						document.cookie = name + "=" + value + _expires + path;
					}
					function getCookieValue(name){	/**获取cookie的值，根据cookie的键获取值**/
						//用处理字符串的方式查找到key对应value
						var name = escape(name);
					    //读cookie属性，这将返回文档的所有cookie
					    var allcookies = document.cookie;       
					    //查找名为name的cookie的开始位置
						name += "=";
					    var pos = allcookies.indexOf(name);    
					    //如果找到了具有该名字的cookie，那么提取并使用它的值
					    if (pos != -1){                                             //如果pos值为-1则说明搜索"version="失败
							var start = pos + name.length;                  //cookie值开始的位置
					        var end = allcookies.indexOf(";",start);        //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置
					        if (end == -1) end = allcookies.length;        //如果end值为-1说明cookie列表里只有一个cookie
					        var value = allcookies.substring(start,end); //提取cookie的值
					        return (value);                           //对它解码      
						}else{	//搜索失败，返回空字符串
							return "";
						}
					}
					function deleteCookie(name,path){	/**根据cookie的键，删除cookie，其实就是设置其失效**/
					    var name = escape(name);
					    var expires = new Date(0);
						path = path == "" ? "" : ";path=" + path;
						document.cookie = name + "="+ ";expires=" + expires.toUTCString() + path;
					}

					/**实现功能，保存用户的登录信息到cookie中。当登录页面被打开时，就查询cookie**/
					window.onload = function(){
						var userNameValue = getCookieValue("userAccount");
						document.getElementById("userAccount").value = userNameValue;
					    var userPassValue = getCookieValue("userPass");
						document.getElementById("password").value = userPassValue;
					}

					
					
					
					
				</script>

				
				
				<!-- Add class "fade-in-effect" for login form effect -->
				<form method="post" id="login" class="login-form fade-in-effect">
					<div class="login-header">
						<a class="logo">
							<img src="images/login.png" alt="" width="130" />
						</a>
								
					</div>	
					<div class="errors-container">
						
					</div>
					<div class="form-group">
						<label class="control-label" for="username">Username</label>
						<input type="text" class="form-control input-dark" name="username" id="userAccount" autocomplete="off" />
					</div>
					
					<div class="form-group">
						<label class="control-label" for="passwd">Password</label>
						<input type="password" class="form-control input-dark" name="passwd" id="password" autocomplete="off" />
					</div>
					
					<td align="center" colspan="2">
            			<span style="font-size:24px; color:white; vertical-align:middle;">Remember me</span>
            			<input type="checkbox" id="chkRememberPass" name="chkRememberPass" style="vertical-align:middle;" />
            		</td>
            		
					
					
					
					
				</form>
					
				<!-- External login -->
				<div class="external-login">
		
					<a href=“#” onclick = "login(); return false;" class="twitter">
						<i class="fa-lock"></i>
						登录
					</a>
                    <a href="myregister.jsp" class="gplus">
						<i class="fa-user-md"></i>
						新用户
					</a>
                    <a href="#" class="facebook">
						<i class="fa-facebook"></i>
						Facebook 登录
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

</body>
</html>