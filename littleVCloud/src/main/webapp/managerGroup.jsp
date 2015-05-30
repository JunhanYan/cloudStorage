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
						<a href="myresource.jsp">
							<i class="linecons-database"></i>
							<span class="title">全部文件</span>
						</a>
                        </li>
					<li>
						<a href="document.jsp">
							<i class="linecons-note"></i>
							<span class="title">文档</span>
						</a>
                        </li>
					 <li>
						<a href="picture.jsp">
							<i class="linecons-photo"></i>
							<span class="title">图片</span>
						</a>
                        </li>
					 <li>
						<a href="video.jsp">
							<i class="linecons-tv"></i>
							<span class="title">视频</span>
						</a>
					</li>
					<li>
						<a href="music.jsp">
							<i class="linecons-music"></i>
							<span class="title">音乐</span>
						</a>
                        </li>
					<li>
						<a href="others.jsp">
							<i class="linecons-params"></i>
							<span class="title">其他</span>
						</a>
                        </li>
					<li class="opened active">
						<a href="managerGroup.jsp">
							<i class="linecons-user"></i>
							    <span class="title">群组管理</span>
						</a>
						<ul>
							<li>
								<a href="share.jsp">
									<span class="title">我的分享</span>
								</a>
							</li>
							<li>
								<a href="managerGroup.jsp">
									<span class="title">群组成员信息</span>
								</a>
							</li>
							<li>
								<a href="applyGroup.jsp">
									<span class="title">申请入组</span>
								</a>
							</li>
							<li>
								<a href="inviteGroup.jsp">
									<span class="title">邀请入组</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="trash.jsp">
							<i class="linecons-trash"></i>
							<span class="title">回收站</span>
						</a>			
					</li>	
                    <li class="opened active">
						<a href="#">
							<i class="linecons-cloud"></i>
							<span class="title">关注</span>
						</a>
						<ul>
							<li>
								<a href="followWho.jsp">
									<span class="title">我关注的</span>
								</a>
							</li>
							<li>
								<a href="whoFollow.jsp">
									<span class="title">谁关注我</span>
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
								<a href="changePassword.jsp">
									<i class="fa-wrench"></i>
									设置
								</a>
							</li>
							<li class="last">
								<a href="login.jsp" onclick="">
									<i class="fa-lock"></i>
									注销
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
                	<div class="title-env">
                       <button id="upload-button"class="btn btn-turquoise"></button>
                       <button id="download-button"class="btn btn-orange"></button>
                       <button id="newfile-button"class="btn btn-purple"></button>
                       <button id="rubbish-button"class="btn btn-secondary"></button>
                       <button id="share-button"class="btn btn-pink"></button>
                       <button id="private-button"class="btn btn-red"></button>
                       
                       
                    </div>
                </div>
				 
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">群组/成员列表</h3>
							
							<div class="panel-options">
								<a href="#">
									<i class="linecons-cog"></i>
								</a>
								<a href="#" data-toggle="panel">
									<span class="collapse-icon">&ndash;</span>
									<span class="expand-icon">+</span>
								</a>
								<a href="#" data-toggle="reload">
									<i class="fa-rotate-right"></i>
								</a>
								<a href="#" data-toggle="remove">
									&times;
								</a>
							</div>
						</div>
					<div class="panel-body">
					
						<div class="row">
							<div class="col-sm-6">
								<!-- Basic Table -->
								<strong>群组列表</strong>
								<table class="table table-hover" id="page">
									<thead>
										<tr>
											<th style="display: none">群组id</th>
											<th>群组名称</th>
										</tr>
									</thead>
									<tbody id="team-template">
										
									</tbody>
								</table>
							</div>
							
							<div class="col-sm-6">
								<!-- Hover Table -->
								<strong>成员列表</strong>
								<table class="table responsive">
									<thead>
										<tr>
											<th>成员姓名</th>
										</tr>
									</thead>
									<tbody id="member-template">
										
									</tbody>
								</table>
							</div>
						</div>
						<div class="vspacer v3"></div>
					</div>
					<div class="tab-content no-margin">
						<ul class="pager wizard">
							<li class="previous">
								<a href="javascript:;" onclick=" openDialogGroup();" >新增组</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
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
		
		function delcfm() { 
			if (!confirm("确认要删除？")) { 
			window.event.returnValue = false; 
			} 
		} 

			jQuery(document).ready(function($)
			{
				$.ajax({
		            url: 'http://172.31.34.180/littleVCloud/userController/getUserTeams/'+userid+'.do',
		            dataType: 'json',
		            method: 'GET',
		            contentType:'application/json;charset=UTF-8'
		            })
		            .success(function (datas, status, headers, config) {
		            	var content = "";
		            	
		            	$("#team-template").html(content);//清空缓存
						if(datas.length > 0){
							$.each(datas, function(i, data){ 
								if(data.ownerId==userid){
								content +="<tr><th> <a href='javascript:test("+data.teamId+")'>" + data.teamName+"</a></th><th><a href='javascript:deleteGroup("+data.teamId+");' onclick='delcfm()'>解散组</a></th></tr>";
								}else{
									content +="<tr><th> <a href='javascript:test("+data.teamId+")'>" + data.teamName+"</a></th></tr>";
								}
							});
		            	}else{
		            		content = "<tr class='no_data'><th>No data available</th></tr>";
		            	}
						
						$("#team-template").html(content);

		            })
			});
			function test(id){
				$.ajax({
		            url: 'http://172.31.34.180/littleVCloud/teamController/getTeamAndMembers/'+id+'.do',
		            dataType: 'json',
		            method: 'GET',
		            contentType:'application/json;charset=UTF-8'
		            })
		            .success(function (datas, status, headers, config) {
		            	var content = "";
		            	$("#member-template").html(content);//清空缓存
						if(datas.users.length > 0){
							$.each(datas.users, function(i, data){ 
								content +="<tr><th><a href='memberShare.jsp?userid="+data.userId+"'>" + data.userName+"</a></th></tr>";
							});
		            	}else{
		            		content = "<tr ><th>No data available</th></tr>";
		            	}
						
						$("#member-template").html(content);

		            })
				
			}
			
			function deleteGroup(tid){
				$.ajax({
		            url: 'http://172.31.34.180/littleVCloud/teamController/deleteTeam/'+tid+'.do',
		            dataType: 'json',
		            method: 'DELETE',
		            contentType:'application/json;charset=UTF-8',
		            data: JSON.stringify({
		            	teamId: tid
		                })
		            })
		            .success(function (datas, status, headers, config) {
		            	if(datas.result=="success"){
		            		location.reload() ;
		            		alert("删除成功！");
		            	}else{
		            		alert("删除失败！");
		            	}
		            })
			}
			
			function  openDialogGroup(){
				//清空缓存
				$("#groupName").val('');
				//打开弹出框
				Dialog('.detailDialog');
			}
			function addGroup(){
				var groupName = $("#groupName").val();
				$.ajax({
		            url: 'http://172.31.34.180/littleVCloud/teamController/createTeam.do',
		            dataType: 'json',
		            method: 'POST',
		            contentType:'application/json;charset=UTF-8',
		            data: JSON.stringify({
		            	teamName : $('#groupName').val(),
		                ownerId : userid	
		                })
		            })
		            .success(function (datas, status, headers, config) {
		            	$.ajax({
    			            url: 'http://172.31.34.180/littleVCloud/teamController/addUserToTeam/'+datas.ownerId+'-'+datas.teamId+'.do',
    			            dataType: 'json',
    			            method: 'POST',
    			            contentType:'application/json;charset=UTF-8'
    			            })
    			            .success(function (datas, status, headers, config) {
    			            	if(datas.result=="success"){
    			            		location.reload() ;
    			            		alert("添加成功！");
    			            	}else{
    			            		alert("添加失败！");
    			            	}
    			            })
		            	
		            })
			}

			</script>	
         
         
         <!-- 添加群组弹出框开始 -->
            <div class="dialog detailDialog">
			    <h2><img src="images/close_06.png" onClick="DialogClose('.detailDialog')" title="关闭" /></h2>
			    <div class="layer">
			        <div class="tit">添加组</div>
			        <div class="txtMain">
			                     组名称：<input name="groupName" id="groupName" style="margin-top: 20px; margin-left: 5px;"/><br/><br/>
			                <input type="button" value="添加" onClick=" addGroup()" style="margin-top: 20px; margin-left: 115px;">&nbsp;&nbsp;<input type="button" value="取消" style="margin-top: 20px; margin-left: 5px;" onClick="DialogClose('.detailDialog')">
			        </div>
			    </div>
			</div>	
          <!-- 添加群组弹出框结束 -->
         

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