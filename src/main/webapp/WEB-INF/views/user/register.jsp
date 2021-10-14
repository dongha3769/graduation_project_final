<%@ page import="dev.yhp.db.enums.user.RegisterResult" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-28
  Time: 오후 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원 로그인</title>
    <link rel="preload" as="style" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap">
    <link rel="stylesheet" href="resources/stylesheets/common.css">
    <script src="resources/scripts/common.js"></script>
    <script>
        ${registerVo.result == RegisterResult.DUPLICATE_EMAIL ? "alert('해당 이메일은 이미 사용 중입니다.')" : ""}
        ${registerVo.result == RegisterResult.DUPLICATE_NICKNAME ? "alert('해당 닉네임은 이미 사용 중입니다.')" : ""}
    </script>
</head>
<body>
    <main>
        <form id="login-form" method="post">
            <h1>자취생<br/>회원가입</h1>
            <div class="credential">
                <label>
                    <input maxlength="50" name="email" placeholder="이메일" type="email" value="${registerVo.email}">
                </label>
                <label>
                    <input maxlength="100" name="password" placeholder="비밀번호" type="password" >
                </label>
                <label>
                    <input maxlength="50" name="nickname" placeholder="닉네임" type="text" value="${registerVo.nickname}">
                </label>
                <label>
                    <input maxlength="50" name="name" placeholder="이름" type="text" value="${registerVo.name}">
                </label>
                <label>
                    <input maxlength="50" name="contact" placeholder="연락처" type="text" value="${registerVo.contact}">
                </label>
            </div>
            <div class="buttons">
                <input class="button green" type="submit" value="회원가입">
            </div>
        </form>
    </main>
</body>
</html>
