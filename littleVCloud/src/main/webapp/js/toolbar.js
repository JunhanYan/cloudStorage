// Here is just a sample how to open chat conversation box
jQuery(document).ready(function($)
{
		
	/***********************
	***/

	var 
		$toolbar = $("#toolbar"),
		$rubbishButton = $toolbar.find("#rubbish-button")
	;
	
	// var $chat_conversation = $(".chat-conversation");
	
	// $(".chat-group a").on('click', function(ev)
	// {
	// 	ev.preventDefault();
		
	// 	$chat_conversation.toggleClass('is-open');
		
	// 	$(".chat-conversation textarea").trigger('autosize.resize').focus();
	// });
	
	// $(".conversation-close").on('click', function(ev)
	// {
	// 	ev.preventDefault();
	// 	$chat_conversation.removeClass('is-open');
	// });

    var ck = function(){
    	
    	alert("用户名或密码错误，请重新输入！");
    }
	$rubbishButton.on('click', ck);
});