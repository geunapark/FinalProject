<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="UTF-8">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <link rel="stylesheet" href="/css/todo/todoWrite.css">
      <script defer src="/js/todo/write.js"></script>
    </head>

    <body>

      <main>

        <h3> 할일 작성</h3>

        <form action="/todo/write" method="post">

          <label for="title">제목:</label>
          <input type="text" id="title" name="title" required>
          <br><br>

          <label for="content">내용:</label>
          <textarea id="content" name="content" required></textarea>
          <br><br>

        
          <label for="parNo" data-name="todoEmpNo">담당자:${loginEmpVo.name}</label>
          <br><br>


              <select id="todoManager" name="todoManagerList[]" multiple>
                 <option value="">참여자 선택</option>
                 <c:forEach var="employee" items="${employeeList}">
                     <option value="${employee.no}" name="todoManagerList" class="click-option">${employee.name}&nbsp;&nbsp;&nbsp;${employee.deptNo}</option>
                 </c:forEach>
              </select>
              <input type="hidden" id="todoManagerList" name="todoManagerList">
              <label for="parNo">참여자:</label>

          
          <br><br>
          
          
          <label for="endDate">기한</label>
          <input type="hidden" id="endDate" name="endDate">
          <button type="button" onclick="setEndDate('today')">오늘</button>
          <button type="button" onclick="setEndDate('tomorrow')">내일</button>
          <button type="button" onclick="setEndDate('nextWeek')">다음주</button>
          <br><br>

          <input type="submit" value="작성">
        </form>





      </main>

    </body>

    </html>