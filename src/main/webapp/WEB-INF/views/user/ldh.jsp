<%@ page import="dev.yhp.db.models.UserModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Object loginObj = session.getAttribute(UserModel.Name);
    UserModel userModel = loginObj instanceof UserModel ? (UserModel) loginObj : null;
%>
0
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>자취생사이트</title>
    <link href="resources/stylesheets/style.css" rel="stylesheet">
    <link href="resources/stylesheets/header.css" rel="stylesheet">
    <link href="resources/stylesheets/slide.css" rel="stylesheet">
    <link href="resources/stylesheets/contents.css" rel="stylesheet">
    <link href="resources/stylesheets/footer.css" rel="stylesheet">
    <link href="resources/stylesheets/popup.css" rel="stylesheet">

    <script src="resources/scripts/jquery-1.12.4.js"></script>
    <script src="resources/scripts/app.js"></script>

</head>
<body>
<div method="post">
    <div id="popup">
        <div>
            자취생 사이트
        </div>

        <div>
            <p>
                안녕하세요. 대구대학교 이동하, 박건화입니다.
            </p>
            <p>
                자취생 사이트는 여러 이유로 인해 혼자서 생활하는 <br/>
                자취생들을 위하여 만든 사이트입니다.
            </p>
            <p>
                하나의 홈페이지로 다양한 것을 이용할 수 있습니다.<br/>
                번거로움을 제거하고 편리함에 중점을 두어 제작하였습니다.
                앞으로도 새로운 부분을 개선하여 이용에 불편함 없도록 하겠습니다.
            </p>
        </div>

        <div id="closeBtn"><img src="resources/images/popup_btn.jpg" alt="창닫기"></div>
    </div>

    <div id="wrap">
        <header id="header">
            <div class="logo">
                <img class="pop" src="resources/images/home.jpg">
            </div>



            <nav class="nav">
                <div class="gnb"><i id="un"><b>${userModel.name}</b></i> 님</div>
                <ul class="gnb">

                    <li><a href="#">인터넷</a>
                        <ul class="lnb">
                            <li><a href="http://www.naver.com">네이버</a></li>
                            <li><a href="http://www.daum.net">다음</a></li>
                            <li><a href="http://google.com">구글</a></li>
                        </ul>
                    </li>
                    <li><a href="#">영화</a>
                        <ul class="lnb">
                            <li><a href="http://netflix.com">넷플릭스</a></li>
                            <li><a href="http://watcha.com">왓챠</a></li>
                        </ul>
                    </li>
                    <li><a href="#">방구하기</a>
                        <ul class="lnb">
                            <li><a href="http://dabangapp.com">다방</a></li>
                            <li><a href="http://zigbang.com">직방</a></li>
                        </ul>
                    </li>
                    <li><a href="#">배달</a>
                        <ul class="lnb">
                            <li><a href="http://baemin.com">배달의민족</a></li>
                            <li><a href="http://yogiyo.co.kr">요기요</a></li>
                            <li><a href="http://coupang.com">쿠팡</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </header>
        <div id="slide">
            <div id="slide_contents">
                <img src="resources/images/sunglass.jpeg" alt="선글라스">
                <img src="resources/images/season.png" alt="계절">
                <img src="resources/images/blue.png" alt="바다">
            </div>
        </div>
        <div id="contents">
            <div id="cont1">
                <article class="tab">
                    <div class="tab_btn">
                        <a href="#" class="active">
                            공지사항
                        </a>
                       <!-- <a href="#">
                            인테리어
                        </a>-->
                    </div>
                    <div class="tab_contents">
                        <div>
                            <ul class="notice_list">
                                <li><a href="#">2021-09-13 업데이트 <span>[2021-09-13]</span></a></li>
                                <li><a href="#">2021-10-20 업데이트 예정<span>[2021-09-13]</span></a></li>
                                <li><a href="#">자취생을 위한 사이트 개방<span>[2021-09-13]</span></a></li>
                                <li><a href="#">대구대학교 이동하,박건화<span>[2021-09-13]</span></a></li>
                                <li><a href="#"><span></span></a></li>
                            </ul>
                        </div>
                        <div class="display_off">
                            <ul class="gallery_list">
                                <li><a href="#"><img src="resources/images/" alt="갤러리"></a></li>
                                <li><a href="#"><img src="resources/images/" alt="갤러리"></a></li>
                                <li><a href="#"><img src="resources/images/" alt="갤러리"></a></li>
                            </ul>
                        </div>
                    </div>
                </article>
            </div>
          <!--  <div id="cont2">
                <img src="">
            </div>
            <div id="cont3">
                <img src="">
            </div> -->
        </div>
        <footer id="footer">
            <div class="logo">
                <a href="http://daegu.ac.kr"><img src="resources/images/DU.jpg" alt="대구대"></a>
            </div>
            <div class="copyright">
                <address>
                   개발자 : 대구대학교 소프트웨어전공 이동하 </br>
                    개발자 : 대구대학교 소프트웨어전공 박건화
                </address>
            </div>
            <div class="sns">
                <ul class="sns_list">
                    <li><a href="http://facebook.com"><img src="resources/images/SNS01.jpg" alt="페이스북"></a></li>
                    <li><a href="http://twitter.com"><img src="resources/images/SNS02.jpg" alt="트위터"></a></li>
                    <li><a href="http://instagram.com"><img src="resources/images/SNS03.jpg" alt="인스타"></a></li>
                </ul>
            </div>
        </footer>
    </div>
</form>
</body>
</html>