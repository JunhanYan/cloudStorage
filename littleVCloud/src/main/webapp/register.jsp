<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="registerform" action="userController/register.do" method="post">
<table width="300" border="1">
    <tr>
        <td colspan="2">登录窗口</td>
    </tr>
    <tr>
            <td>用户名</td>
            <td><input type="text" name="userName" size="10"></td>
    </tr>
    <tr>
            <td>密码</td>
            <td><input type="password" name="password" size="10"></td>
	 </tr>
 	<tr>
            <td>用户帐号</td>
            <td><input type="text" name="userAccount" size="10"></td>
    </tr>
	 <tr>
        <td colspan="2"><input type="submit" name="submit"
            value="注册"></td>
    </tr>
</table>
</form>
</body>
</html>