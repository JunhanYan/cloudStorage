<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
</script>
<script>
function user(userAccount,password){  
    this.username=username;  
    this.password=password;  
    }  
function a(){
    $.ajax({
            url: 'http://localhost:8080/littleVCloud/login.do',
            dataType: 'json',
            type: 'POST',
            contentType:'application/json;charset=UTF-8',
            data: JSON.stringify({userAccount : $('#userAccount').val(),			
            	password : $('#password').val()})
           })
            .success(function (data, status, headers, config) {           	
            		 $('#user').append(data.userName);
            		
            })
            .error(function (data, status, headers, config) {
                alert("aaaa");
            });
  
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<table width="300" border="1">
    <tr>
        <td colspan="2">登录窗口</td>
    </tr>
    <tr>
            <td>用户名</td>
            <td><input type="text" id="userAccount" size="10"></td>
    </tr>
    <tr>
            <td>密码</td>
            <td><input type="password" id="password" size="10"></td>
 </tr>
 
</table>
</form>
  <button id="button_login" onclick = "a()" type="button">登录</button> 
  <div id = "user"></div>
</body>
</html>