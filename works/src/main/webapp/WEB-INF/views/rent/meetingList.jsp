<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>meetingList</title>
    <link rel="stylesheet" href="/css/rent/meetingList.css">
</head>
<body>
    
    <%@ include file="/WEB-INF/views/layout/nav.jsp" %>

    <main>
        <%@ include file="/WEB-INF/views/layout/rent/aside.jsp" %>
        
        <div id="main">
            <div id="meetingList">
                <h1>실시간 회의실  예약 현황</h1>
                <div id="meetingContent">
                </div>
                <div style="display: none;" id="detail">
                </div>
            </div>
            <div style="display: none;" id="loginMember">${loginEmpVo.no}</div>
            <div id="meetingImg">
                <div class="overlay">
                    <div class="overlay-text">
                        저희 <h2>Baby-Works는</h2>임원분들을 위해
                        최상의 회의실을 제공합니다
                    </div>
                </div>
                <ul class="slider">
                    <li class="items"><img src="/img/rent/회의실10.jpg" alt=""></li>
                    <li class="items"><img src="/img/rent/회의실9.jpg" alt=""></li>
                    <li class="items"><img src="/img/rent/회의실6.jpg" alt=""></li>
                    <li class="items"><img src="/img/rent/회의실7.jpg" alt=""></li>
                    <li class="items"><img src="/img/rent/회의실8.jpg" alt=""></li>
                </ul>
            </div>
        </div>
    </main>

</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script src="/js/rent/meetingList.js"></script>

