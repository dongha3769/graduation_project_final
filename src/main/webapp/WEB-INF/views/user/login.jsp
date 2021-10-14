<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-23
  Time: 오후 7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원 로그인</title>
    <link rel="preload" as="style" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap">
    <link rel="stylesheet" href="resources/stylesheets/common.css">
    <script src="resources/scripts/common.js"></script>
</head>
<body>
    <main>
        <form id="login-form" method="post">
            <h1>환영합니다.</h1>
            <div class="credential">
                <label>
                    <input maxlength="50" name="email" placeholder="이메일" type="email">
                </label>
                <label>
                    <input maxlength="100" name="password" placeholder="비밀번호" type="password">
                </label>
            </div>
            <div class="buttons">
                <input class="button green" type="submit" value="로그인">
            </div>
        </form>
    </main>
</body>
</html>
