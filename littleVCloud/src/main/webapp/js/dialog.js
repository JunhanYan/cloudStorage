//弹出层-对话框
function Dialog(dom){
    $(dom).find('.dialog_cont').height($(window).height()-250);
    var _domW =$(dom).width()/2;
    var _domH = $(dom).height()/2;
    if(!$('body').find('.mask').length){
        $('body').append('<div class=mask></div>'); 
    }
    $('.mask').height($(document).height()).show();
    $(dom).css({'margin-left':-_domW,'margin-top':-_domH}).fadeIn();
    if('undefined' == typeof(document.body.style.maxHeight)){
         $("body").append('<iframe frameborder="0" class="ie6_iframe"></iframe>');
         $('.ie6_iframe').height($(document).height());
    }
    $(window).resize(function(){
        $(dom).find('.dialog_cont').height($(window).height()-250);
        var _domW =$(dom).width()/2;
        var _domH = $(dom).height()/2;
        $(dom).css({'margin-left':-_domW,'margin-top':-_domH});
    });
};

//弹出层-关闭对话框
function DialogClose(dom){
    $(dom).fadeOut();
    $(window).unbind('resize');
    $('.mask').fadeOut(function(){
        $('.mask').remove();
        $(".ie6_iframe").remove();      
    });
    return false;
};