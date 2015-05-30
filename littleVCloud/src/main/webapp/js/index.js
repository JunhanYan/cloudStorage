 var userId = "";
 var current_parent = 0;
var home_id = 0;

 function main(route, parent) {
 	userId = getCookieValue("userId");
 	if (userId === "") {
 		window.location.href = 'login.jsp';
 	}
 	if (parent || parent === 0) {
	 	$.ajax({
			url: 'http://172.31.34.180/littleVCloud/folderController/getFolderByParentAndUser/' + parent + '-' + userId + '.do'
			, type: 'GET'
			, contentType: 'application/json;charset=UTF-8'
		})
		.done(function(datas) {
			home_id = datas[0].folderId;
		 	loadTable(route, datas[0].folderId);
		});
 	} else {
 		loadTable(route, parent);
 	}
 	$("#ifAll").click(function() {
 		$('.checkbox').prop('checked', $(this).is(':checked'));
 	});

 	$("#rubbish-button").click(function(e) {
 		e.preventDefault();
 		checkBoxHandler(2, route, current_parent);
 	});

 	$("#share-button").click(function(e) {
 		e.preventDefault();
 		checkBoxHandler(1, route, current_parent);
 	});

 	$("#download-button").click(function(e) {
 		e.preventDefault();
 		checkBoxHandler("download");
 	});
 	
 	$(".search-form form").on('submit', function (e) {
		e.preventDefault();
		var data = $(this).serializeArray()[0].value;
		loadTable('getResourcesByName/' + data, false, true);
	});
 	
 	
 	$("#newfile-button").click(function (e) {
 		e.preventDefault();
 		var $table = $("#resource-table");
 		var $body = $table.children("tbody");

 		var $template = $('<tr>' +
 			'<th colspan="6"><form role="form" class="form-horizontal">' +
 			'<div class="input-group">' +
 			'<input type="text" name="folderName" class="form-control" id="field-1" placeholder="新建文件夹">' +
 			'<span class="input-group-btn">' +
 			'<button class="btn btn-purple" type="submit">更改</button>' +
 			'<button class="btn btn-red cancel" type="button">取消</button>' +
 			'</span>' +
 			'</div>' + '</th></tr>');
 		$template.find(".cancel").click(function (e) {
 			e.preventDefault();
 			$template.remove();
 		});
 		$template.find("form").on('submit', function (e) {
 			e.preventDefault();
 			var data = {
 					folderName: $(this).serializeArray()[0].value
 					, parentId: current_parent
 					, userId: userId
 					, date: getDate()
 			};
 			$.ajax({
 				headers: { 
 			        'Accept': 'application/json',
 			        'Content-Type': 'application/json' 
 			    }
 				, type: 'POST'
				, dataType: 'json'
 				, url: 'http://172.31.34.180/littleVCloud/folderController/newFolder.do'
 				, data: JSON.stringify(data)
 				, success: function () {
 					loadTable(route, current_parent);
 				}
 				, error: function (e, q) {
 					loadTable(route, current_parent);
 				}
 			});
 		});
 		$body.prepend($template);
 	});
 }

 function getDate() {
	 var dateObj = new Date();
	 var month = dateObj.getUTCMonth() + 1; //months from 1-12
	 var day = dateObj.getUTCDate();
	 var year = dateObj.getUTCFullYear();

	 return year + "-" + month + "-" + day;
 }
 
 function getCookieValue(name) { /**获取cookie的值，根据cookie的键获取值**/
 	//用处理字符串的方式查找到key对应value
 	var name = escape(name);
 	//读cookie属性，这将返回文档的所有cookie
 	var allcookies = document.cookie;
 	//查找名为name的cookie的开始位置
 	name += "=";
 	var pos = allcookies.indexOf(name);
 	//如果找到了具有该名字的cookie，那么提取并使用它的值
 	if (pos != -1) { //如果pos值为-1则说明搜索"version="失败
 		var start = pos + name.length; //cookie值开始的位置
 		var end = allcookies.indexOf(";", start); //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置
 		if (end == -1) end = allcookies.length; //如果end值为-1说明cookie列表里只有一个cookie
 		var value = allcookies.substring(start, end); //提取cookie的值
 		return (value); //对它解码      
 	} else { //搜索失败，返回空字符串
 		return "";
 	}
 }
 var username = getCookieValue("userName");
 $("#navbar #right-links [data-type='username']").html(username);

 function loadTable(route, parent, isSearch) {
	current_parent = (parent !== false) ? (parent) : (home_id);
 	var $table = $("#resource-table");
 	var $body = $table.children("tbody");

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
 		'<td class="uploader"></td>' +
 		'<td class="date"></td></tr>');

 	/* reset table */
 	$body.html('');

 	var resources = [];
 	var directories = [];
 	var requests = [];
 	
 	if (parent || parent === 0) {
 		console.log(parent);
		if (parent != home_id) {
			requests.push(
	 			$.ajax({
	 				url: 'http://172.31.34.180/littleVCloud/folderController/getFolderById/' + parent + '.do'
	 				, type: 'GET'
	 				, contentType: 'application/json;charset=UTF-8'
	 			})
	 			.done(function(datas) {
	 				$body.prepend('<tr><th colspan="6"> <a href = "#" onclick="loadTable(\'' + route + '\', ' + datas.parentId + '); return false;"><i class="fa fa-folder-open"></i> 返回上一级</a> </th></tr>');
	 			})
	 		);
		}
		requests.push(
	 		$.ajax({
	 				url: 'http://172.31.34.180/littleVCloud/folderController/getFolderByParentAndUser/' + parent + '-' + userId + '.do'
	 				, type: 'GET'
	 				, contentType: 'application/json;charset=UTF-8'
	 			})
	 			.done(function(datas) {
	 				for (var i = 0; i < datas.length; ++i) {
	 					var $clone = $template.clone();
	
	 					$clone.children(".name").html('</i><a href = "#" onclick="loadTable(\'' + route + '\', ' + datas[i].folderId + '); return false;"><i class="fa fa-folder"></i> ' + datas[i].folderName + '</a>');
	 					$clone.children(".size").html("--");
	 					$clone.children(".type").html("dir");
	 					$clone.children(".uploader").html("----");
	 					$clone.children(".date").html(datas[i].date);
	 					$clone.find(".checkbox").data("folder-id", datas[i].folderId);
	 					directories.push($clone);
	 				}
	 			})
		);
 	}
 	requests.push(
	 	$.ajax({
	 			url: 'http://172.31.34.180/littleVCloud/resourceController/' + route + ( (isSearch) ? ("") : ( (parent || parent === 0) ? (parent) : (userId)) ) + '.do' //+ ((parent || parent === 0) ? (parent) : (userId))
	 			, type: 'GET'
	 			, contentType: 'application/json;charset=UTF-8'
	 		})
	 		.done(function(datas) {
 				datas.forEach(function (data) {
	 				var $clone = $template.clone();
	 				
	 				$clone.children(".name").html('<i class="fa fa-' + alias_icon[data.type] + '"></i> <span class="resourceName">' + data.resourceName + '</span>');
	 				$clone.children(".size").html(formatUtil(data.size));
	 				$clone.children(".type").html(data.type);
	 				//$clone.children(".uploader").html('');
	 				$clone.children(".date").html(data.uploadTime);
	 				$clone.find(".checkbox").data("resource-id", data.resourceId);
	 				

	 				
	 				requests.push(
					 	$.ajax({
				 			url: 'http://172.31.34.180/littleVCloud/userController/getUserById/' + data.uploaderId + '.do'
				 			, type: 'GET'
				 			, contentType: 'application/json;charset=UTF-8'
				 		})
				 		.done(function(data) {
				 			$clone.children(".uploader").html("<a href='memberShare.jsp?userid="+data.userId+"'>" + data.userName+"</a>");
				 			//console.log(userdatas);
				 		})
				 		);
	 				resources.push($clone);
 		 		});
	 		})
	 );
 	
 	$.when.apply($, requests).always(function() {

 		$body.append(directories, resources);
 	});
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
 
 
 function checkBoxHandler(statusValue, route, parent) {
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

 	if (statusValue == "download") {
 		console.log(resource_names);
 		for (var i = 0; i < resource_names.length; ++i) {
 			window.open('download.do?file=' + resource_names[i]);
 		}
 		return;
 	}
 	
 	var pendingRequestNb = resource_ids.length + folder_ids.length;


 	if (statusValue == -1) { /*special status delete resources */
 		for (var i = 0; i < resource_ids.length; ++i) {
 			$.ajax({
 					url: 'http://172.31.34.180/littleVCloud/resourceController/deleteResource/' + resource_ids[i] + '.do'
 					, type: 'DELETE'
 					, contentType: 'application/json;charset=UTF-8'
 				})
 				.success(function(datas, status, headers, config) {
 					pendingRequestNb--;
 					if (pendingRequestNb == 0) loadTable(route, parent);
 				});
 		}
 		return;
 	}


 	for (var i = 0; i < resource_ids.length; ++i) {
 		$.ajax({
 				url: 'http://172.31.34.180/littleVCloud/resourceController/getResourceById/' + resource_ids[i] + '.do'
 				, type: 'GET'
 				, contentType: 'application/json;charset=UTF-8'
 			})
 			.success(function(datas) {
 				datas.status = statusValue;
 				$.ajax({
 						url: 'http://172.31.34.180/littleVCloud/resourceController/modifyResource.do'
 						, type: 'PUT'
 						, dataType: 'json'
 						, data: JSON.stringify(datas)
 						, contentType: 'application/json;charset=UTF-8'
 					})
 					.success(function(datas, status, headers, config) {
 						pendingRequestNb--;
 						if (pendingRequestNb == 0) loadTable(route, parent);
 					});
 			});
 	}

 	if (statusValue == 2) {
 		for (var i = 0; i < folder_ids.length; ++i) {
 			$.ajax({
 					url: 'http://172.31.34.180/littleVCloud/folderController/deleteFolderById/' + folder_ids[i] + '.do'
 					, type: 'DELETE'
 					, contentType: 'application/json;charset=UTF-8'
 				})
 				.success(function(datas, status, headers, config) {
 					pendingRequestNb--;
 					if (pendingRequestNb == 0) loadTable(route, parent);
 				});
 		}
 	}
 }
