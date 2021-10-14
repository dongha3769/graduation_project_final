var slideIndex = 1;

$(document).ready(function(){
    popup();
    tab();
    menu();
    slide();
});

function popup(){
    $(".pop").click(function(){
        $("#popup").show();
    });
    $("#closeBtn").click(function(){
        $("#popup").hide();
    });
}

function tab(){
    $(".tab_btn>a").eq(0).click(
        function(){
            // alert("공지사항!");
            $(".tab_contents>div").eq(0).show();
            $(".tab_contents>div").eq(1).hide();
        }
    )

    $(".tab_btn>a").eq(1).click(
        function(){
            // alert("갤러리!");
            $(".tab_contents>div").eq(0).hide();
            $(".tab_contents>div").eq(1).show();
        }
    )
}

function menu(){
    //드랍다운 메뉴
    //전체 드랍다운
    $(".gnb>li").hover(
        
        //mouseover시에 실행할기능
        function (){
            $(".lnb").stop().slideDown(500);
        },
        function (){
            $(".lnb").stop().slideUp(500);
        }
    )
}

function slide() {
    //슬라이드 관련
    setInterval(slide_move, 3000);
    //setInterval 유명한 콜백함수
    //3초마다 slide_move함수를 호출한다.
}

function slide_move(){
    var newLeft = -1200 * slideIndex;
    $("#slide_contents").animate({"left":newLeft},400,"swing");
    //left 음수가 왼쪽방향 이동
    slideIndex++;

    if(slideIndex>2){
        slideIndex = 0;
    }
}