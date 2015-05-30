// Here is just a sample how to open chat conversation box
jQuery(document).ready(function($)
{
	
	/***********************
	
	*************************/
	
 $.ajax({
    url: 'http://localhost:8080/littleVCloud/resourceController/getAllResources.do',
    type: 'GET',
    contentType:'application/json;charset=UTF-8'
   })
    .success(function (datas, status, headers, config) {				            	
    	var $table = $("#resource-table");
    	var $template = $table.find(".resource-template");
    	var $body = $table.children("tbody");
    	if (datas.length > 0) {
        	$table.find(".no_data").hide();
    	}
    	for(var i = 0; i < datas.length; ++i) {
    		var $clone = $template.clone();
				$clone.removeClass("hidden resource-template");
    		$clone.children(".name").html(datas[i].resourceName);
    		$clone.children(".size").html(datas[i].size);
    		$clone.children(".type").html(datas[i].type);
    		$clone.children(".date").html(datas[i].uploadTime);
    		$body.append($clone);
    		
    	}    		
});					
});