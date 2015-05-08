<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
</script>
<script>

    $.ajax({
            url: 'http://localhost:8080/littleVCloud/userController/getUserAndTeams/1.do',
            dataType: 'json',
            method: 'GET',
            headers: {
                "Content-Type": "application/json"
            }})
            .success(function (data, status, headers, config) {
            	//alert("数据：" + data + "\n状态：" + status);
            	/* for(var i = 0;i<data.length;i++){
            		 $('.list').append('<li>'+data[i].userName+'</li>');
            	} */
            	 $('.list').append('<li>'+data.userName+'</li>');
            })
            .error(function (data, status, headers, config) {
                alert(data);
            });
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <ul class="list"></ul>
</body>
</html>