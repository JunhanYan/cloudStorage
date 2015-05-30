<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type"content="text/html;charset=UTF-8"/>
	
	
	<title>小V云盘</title>

	
	<link rel="stylesheet" href="css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/xenon-core.css">
	<link rel="stylesheet" href="css/xenon-forms.css">
	<link rel="stylesheet" href="css/xenon-components.css">
	<link rel="stylesheet" href="css/xenon-skins.css">
	<link rel="stylesheet" href="css/custom.css">
   <link rel="stylesheet" href="css/dialog.css">
	<script src="js/jquery-1.11.1.min.js"></script>
   <script src="js/dialog.js"></script>
   
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
</head>
<body class="page-body">

	<div class="page-container">
		<div class="sidebar-menu toggle-others fixed">
			
			<div class="sidebar-menu-inner">	
				
				<header class="logo-env">
					
					<!-- logo -->
					<div class="logo">
						<a href="dashboard-1.html" class="logo-expanded">
							<img src="images/logo-login1.png" width="100" alt="" />
						</a>
						
						<a href="dashboard-1.html" class="logo-collapsed">
							<img src="images/logo1.png" width="40" alt="" />
						</a>
					</div>
					
					<!-- This will toggle the mobile menu and will be visible only on mobile devices -->
					<div class="mobile-menu-toggle visible-xs">
						<a href="#" data-toggle="user-info-menu">
							<i class="fa-bell-o"></i>
							<span class="badge badge-success">7</span>
						</a>
						
						<a href="#" data-toggle="mobile-menu">
							<i class="fa-bars"></i>
						</a>
					</div>
                    
								
				</header>
						
				
						
				<ul id="main-menu" class="main-menu">
					<!-- add class "multiple-expanded" to allow multiple submenus to open -->
					<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
					<li class="opened active">
						<a href="#">
							<i class="linecons-database"></i>
							<span id="share_title" class="title">他/她的分享</span>
						</a>
                        </li>
					
						</ul>			
					</li>					
						
			</div>
			
		</div>
		
		<div class="main-content">
					
			<!-- User Info, Notifications and Menu Bar -->
			<nav class="navbar user-info-navbar" role="navigation" id="navbar">

				<!-- Right links for user info navbar -->
				<ul class="user-info-menu right-links list-inline list-unstyled" id="right-links">
					
					<li class="search-form"><!-- You can add "always-visible" to show make the search input visible -->
						
						<form method="get" action="extra-search.html">
							<input type="text" name="s" class="form-control search-field" placeholder="Type to search..." />
							
							<button type="submit" class="btn btn-link">
								<i class="linecons-search"></i>
							</button>
						</form>
						
					</li>
					
					<li class="dropdown user-profile">
						<a href="myresource.jsp" data-toggle="dropdown">
							
							<span id = "name" class = "username" >
							
								<i class="fa-angle-down"></i>
								<span data-type="username"></span>
							</span>
						</a>
						
						<ul class="dropdown-menu user-profile-menu list-unstyled">
							<li>
								<a onclick="showhidediv('setting')">
									<i class="fa-wrench"></i>
									Settings
								</a>
							</li>
							<li class="last">
								<a href="login.jsp">
									<i class="fa-lock"></i>
									Logout
								</a>
							</li>
						</ul>
					</li>
					
					<li>
						<a href="#" data-toggle="chat">
							<i class="fa-comments-o"></i>
						</a>
					</li>
					
				</ul>
				
			</nav>
			<div>
                <div class="page-title control-navbar">
                	<div class="title-env" id="isFollow">
                
                      
                     
                       
                       
                    </div>
                </div>
				 
			<div class="panel panel-default cloud-table">
                
                    <table class="table responsive" id="resource-table">
                        <thead>
                            <tr>
                                <th><input type="checkbox" name="ifAll" id="ifAll" ></input></th>
                                <th>文件名</th>
                                <th>大小</th>
                                <th>文件类型</th>
                                
                                <th>上传时间</th>
                                     
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                   
                </div>
		
		<script type="text/javascript">
			// Here is just a sample how to open chat conversation box
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
	    var userid = getCookieValue("userId");
	    var username = getCookieValue("userName");

	    $("#navbar #right-links [data-type='username']").html(username);
	    var $table = $("#resource-table");
	 	var $body = $table.children("tbody");
		var resources = [];
	 	var alias_icon = {
		doc: "file-word-o"
		, music: "music"
		, video: "video-camera"
		, picture: "photo"
		, others: "file-text"
 		};
 	
	 	var $template = $('<tr>' +
	 		'<td><input class="checkbox" type="checkbox" name="selectFlag" value="checkbox1"></input></td>' +
	 		'<td class="name"></td>' +
	 		'<td class="size"></td>' +
	 		'<td class="type"></td>' +	 		
	 		'<td class="date"></td></tr>');

	 	/* reset table */
 	
		var url = location.search; //获取url中"?"符后的字串
		var currentid = "";
	    if (url.indexOf("?") != -1) {    //判断是否有参数
	      var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
	      strs = str.split("=");   //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
	              //直接弹出第一个参数 （如果有多个参数 还要进行循环的）
	      currentid=strs[1];
	    }

		jQuery(document).ready(function($)
			{
				$.ajax({
		 			url: 'http://172.31.34.180/littleVCloud/userController/getUserById/' + currentid + '.do'
		 			, type: 'GET'
		 			, contentType: 'application/json;charset=UTF-8'
		 		})
		 		.done(function(data) {
		 			$("#share_title").html(data.userName+'的分享');
		 		})
				$.ajax({
		            url: 'http://172.31.34.180/littleVCloud/resourceController/getSharedResource/'+currentid+'.do',
		            dataType: 'json',
		            method: 'GET',
		            contentType:'application/json;charset=UTF-8'
		            })
		            .success(function (datas, status, headers, config) {
		            	for (var i = 0; i < datas.length; ++i) {
	 				var $clone = $template.clone();
	
	 				$clone.children(".name").html('<i class="fa fa-' + alias_icon[datas[i].type] + '"></i> <span class="resourceName">' + datas[i].resourceName + '</span>');
	 				$clone.children(".size").html(formatUtil(datas[i].size));
	 				$clone.children(".type").html(datas[i].type);
	 				
	 				$clone.children(".date").html(datas[i].uploadTime);
	 				$clone.find(".checkbox").data("resource-id", datas[i].resourceId);	 							 
					 		
	 				$body.append($clone);
	 			}
		            })
			
				$.ajax({
		            url: 'http://172.31.34.180/littleVCloud/followController/getTarget/'+userid+'.do',
		            dataType: 'json',
		            method: 'GET',
		            contentType:'application/json;charset=UTF-8'
		            })
		            .success(function (datas, status, headers, config) {
		            	var content = "";
		            	var isFollowed=false;
		            	var dataid="";
		            	$("#isFollow").html(content);//清空缓存
		            	if(datas.length>0){
		            		$.each(datas, function(i, data){ 
		            			if(data.userId==currentid){
		            				isFollowed=true;
		            				
		            			}
		            			dataid=data.userId;
		            		})
		            		if(currentid==userid){
	            				content+="<button onclick = 'download()' id='download-button'class='btn btn-orange'>下载</button>"
	            			}else{
			            		if(isFollowed){
			            			content+="<a href='javascript:deleteFollow("+currentid+","+userid+")' onclick='delcfm()'>取消关注<i class='fa-heart'></i></a>"+
			            				"<button onclick = 'download()' id='download-button'class='btn btn-orange'>下载</button>"
			            		}else{
			            			content+="<a href='javascript:addFollow("+currentid+","+userid+")'>关注<i class='fa-heart-o'></i></a>"+
			            				"<button onclick = 'download()' id='download-button'class='btn btn-orange'>下载</button>"
			            		}
	            			}
		            		$("#isFollow").html(content);
		            	}else if(datas.length==0){
		            		if(currentid==userid){
		            				content+="<button onclick = 'download()' id='download-button'class='btn btn-orange'>下载</button>"
		            			}else{
		            				content+="<a href='javascript:addFollow("+currentid+","+userid+")'>关注<i class='fa-heart-o'></i></a>"+
		            				"<button onclick = 'download()' id='download-button'class='btn btn-orange'>下载</button>"
		            			}
		            		$("#isFollow").html(content);
		            	}
		            })
			});
	      
		function download() {
	 		
	 		var $checkboxes = $("#resource-table .checkbox");

	 	 	var folder_ids = [];
	 	 	var resource_ids = [];
	 	 	var resource_names = [];
	 	 	$checkboxes.each(function() {
	 	 		if ($(this).is(":checked")) {
	 	 			var f_id = $(this).data("folder-id");
	 	 			var r_id = $(this).data("resource-id");
	 	 			if (f_id) folder_ids.push(f_id);
	 	 			if (r_id) {
	 	 				resource_ids.push(r_id);
	 	 				resource_names.push($(this).parents("tr").find(".resourceName").html());
	 	 			}
	 	 		}
	 	 	});

	 	 	
	 	 	console.log(resource_names);
	 	 	for (var i = 0; i < resource_names.length; ++i) {
	 	 		window.open('download.do?file=' + resource_names[i]);
	 	 	}
	 	 	return	 	 	
	 	}
			function addFollow(targetid,whoid){
				$.ajax({
		            url: 'http://172.31.34.180/littleVCloud/followController/addFollow.do',
		            dataType: 'json',
		            method: 'POST',
		            contentType:'application/json;charset=UTF-8',
		            data: JSON.stringify({
		            	target : targetid,
		                who : whoid	
		                })
		            })
				.success(function (datas, status, headers, config) {
	            	
	            		location.reload() ;
	            		alert("关注成功！");
	            	
	            })
			}
			
			function formatUtil(str){
				 var result='';
				 if(str<0){
					 result = parseInt((-str+2147483647)/1000000)+'M';
				 }else if(str>=0&&str<1000000){
					 
					 if(str/1000>=1){
						result= parseInt(str/1000)+'K'
					 }else{
						 result= str/1000+'K'
					 }
					 
				 }else{
					 result=parseInt(str/1000000)+'M'
				 }
				 return result;
			 }
			function deleteFollow(targetid,whoid){
				$.ajax({
		            url: 'http://172.31.34.180/littleVCloud/followController/deleteFollow/'+targetid+'-'+whoid+'.do',
		            dataType: 'json',
		            method: 'DELETE',
		            contentType:'application/json;charset=UTF-8'
		        })
		        .success(function (datas, status, headers, config) {
	            	if(datas.result=="success"){
	            		location.reload() ;
	            		alert("取消关注成功！");
	            	}else{
	            		alert("取消关注失败！");
	            	}
	            })
			}
	    

		function delcfm() { 
			if (!confirm("确认要取消关注？")) { 
			window.event.returnValue = false; 
			} 
		} 	
			
			

			</script>	

			<!-- Main Footer -->
			<!-- Choose between footer styles: "footer-type-1" or "footer-type-2" -->
			<!-- Add class "sticky" to  always stick the footer to the end of page (if page contents is small) -->
			<!-- Or class "fixed" to  always fix the footer to the end of page -->
			<footer class="main-footer sticky footer-type-1">
				
				<div class="footer-inner">
				
					<!-- Add your copyright text here -->
                    <!--
					<div class="footer-text">
						&copy; 2014 
						<strong>Xenon</strong> 
						More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
					</div>
					-->
					
					<!-- Go to Top Link, just add rel="go-top" to any link to add this functionality -->
					<div class="go-up">
					
						<a href="#" rel="go-top">
							<i class="fa-angle-up"></i>
						</a>
						
					</div>
					
				</div>
				
			</footer>
		</div>

	<!-- Bottom Scripts -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/TweenMax.min.js"></script>
	<script src="js/resizeable.js"></script>
	<script src="js/joinable.js"></script>
	<script src="js/xenon-api.js"></script>
	<script src="js/xenon-toggles.js"></script>


	<!-- JavaScripts initializations and stuff -->
	<script src="js/xenon-custom.js"></script>
	<script src="js/datatables/js/jquery.dataTables.min.js"></script>


	<!-- Imported scripts on this page -->
	<script src="js/datatables/dataTables.bootstrap.js"></script>
	<script src="js/datatables/yadcf/jquery.dataTables.yadcf.js"></script>
	<script src="js/datatables/tabletools/dataTables.tableTools.min.js"></script>
	

</body>
</html>