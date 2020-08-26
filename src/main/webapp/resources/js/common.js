$(document).ready(function($) {
	//alert("hello");//여기에 사용자 액션 내용을 입력하시면 됩니다.
    $(".menu-toggle-btn").click(function(){
        $(".gnb").stop().slideToggle("fast");
    });	
})