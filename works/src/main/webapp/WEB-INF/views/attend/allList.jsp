<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>

      <link rel="stylesheet" href="/css/attend/allList.css">
    </head>

    <body>

        <nav>
           <div id="right-sidebar">
             <div><a href="http://127.0.0.1:8080/home"><button><img src="/img/icon/board.png" alt=""></button></a></div>
             <div><img src="../resources/img/스크린샷 2024-06-18 195610.png" alt=""></div>
             <div id="title">게시판</div>
           </div>
           <div id="left-sidebar">
            <div><a href=""><img src="/img/icon/chatting.png" alt=""></a></div>
                <!-- 근태관리(인사부) -->
                <div><a href="http://127.0.0.1:8080/attend/allList"><img src="/img/icon/attendMange.png" alt=""></a></div>
                <div><a href=""><img src="/img/icon/organization-chart.png" alt=""></a></div>
                <div><a href=""><img src="/img/icon/customer.png" alt=""></a></div>
                <!-- 쪽지 -->
                <div><a href="http://127.0.0.1:8080/messenger/all"><img src="/img/icon/paper.png" alt=""></a></div>
                <div><a href=""><img src="/img/icon/reserved.png" alt=""></a></div>
                <div><a href="http://127.0.0.1:8080/board/list"><img src="/img/icon/board.png" alt=""></a></div>
                <div><a href=""><img src="/img/icon/calendar.png" alt=""></a></div>
                <div><a href="http://127.0.0.1:8080/todo/home"><img src="/img/icon/todo.png" alt=""></a></div>
                <div><button><img src="/img/icon/user.png" alt=""></button></div>
           </div>
      </nav>

      <main>

          <div id="all-list">
              <div id="employee-infor">
                <form action="searchFromAll" method="get">
                  <div id="name-search">
                      <div>
                          <select id="department-select" name="deptSearch">
                            <!-- 여기에서 value는 DB에 있는 DEPARTMENT 테이블에서 NO의 값이다. -->
                            <!-- 그렇기 때문에 value를 5로 하면 값이 나오지 않음.  -->
                              <option value="">부서 선택</option>
                              <option value="1">인사부</option>
                              <option value="2">총무부</option>
                              <option value="3">개발부</option>
                              <option value="4">영업부</option>
                              <option value="5">전체</option>
                          </select>
                      </div>
                      <div>
                          <input type="text" id="name-search-keyword" name="nameSearch" placeholder="사원명을 입력해주세요.">
                      </div>
                      <div>
                        <input type="submit" value="검색">
                      </div>
                  </div>
                </form>
                <br>
              </div>

              <table class="attend-table">
                  <thead>
                      <tr>
                          <th>이름</th>
                          <th>직급</th>
                          <th>부서</th>
                          <th>출근 시간</th>
                          <th>퇴근 시간</th>
                      </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="attend" items="${attendList}">
                          <tr>
                            <td>${attend.empName}</td>
                            <td>${attend.positionName}</td>
                            <td>${attend.deptName}</td>
                            <td>${attend.startTime}</td>
                            <td>${attend.endTime}</td>
                          </tr>
                      </c:forEach>
                  </tbody>
              </table>
          </div>
      </main>


    </body>

  </html>