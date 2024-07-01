<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/layout/admin/same.css">
    <title>Document</title>
</head>
<body>
    <%@ include file="/WEB-INF/views/layout/admin/aside.jsp" %>

    <h1>작성하기</h1>
    <form action="/notice/write" method="post">
        <input type="text" name="title" value="제목">
        <textarea name="content"></textarea>
        <input type="submit" value="작성하기">
    </form>
</body>
</html>