<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
</script>
<script>


function a(){
    $.ajax({
            url: 'http://localhost:8080/littleVCloud/userController/register.do',
            dataType: 'json',
            type: 'POST',
            contentType:'application/json;charset=UTF-8',
            data: JSON.stringify({
            	userName : $('#userName').val(),
            	password :$('#password').val(),
            	userAccount: $('#userAccont').val()           	
            })
           	})
            .success(function (data, status, headers, config) {
            	
            	for(var i = 0;i<data.length;i++){
            		 $('.user').append('<li>'+data[i].userName+'</li>');
            	}
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
            <td><input type="text" id="userName" size="10"></td>
    </tr>
    <tr>
            <td>密码</td>
            <td><input type="password" id="password" size="10"></td>
	 </tr>
 	<tr>
            <td>用户帐号</td>
            <td><input type="text" id="userAccount" size="10"></td>
    </tr>
</table>
</form>
 <button id="button_register" onclick ="a()">注册</button> 
<dir class = 'user'></dir>
</body>
</html>