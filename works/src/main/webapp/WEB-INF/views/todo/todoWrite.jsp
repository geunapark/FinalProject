<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="UTF-8">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
    </head>

    <body>

      <form action="/todo/write" method="post">
        <label>제목 :</label><input type="text" name="title">
        <br>
        <label>내용: </label><input type="text" name="content">
        <br>
        <button id="empList">주소록</button>
        <input type="submit" value="작성하기">



      </form>

    </body>

    </html>