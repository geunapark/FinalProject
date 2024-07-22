<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CarList</title>
    <link rel="stylesheet" href="/css/rent/carList.css">
</head>
<body>
    
        <%@ include file="/WEB-INF/views/layout/nav.jsp" %>

    <main>
        <%@ include file="/WEB-INF/views/layout/rent/aside.jsp" %>
        
        <div id="main">
            <div id="carList">
                <div>실시간 차량예약 현황</div>
                <div id="carContent">

                </div>
                <div style="display: none;" id="detail">

                </div>
            </div>
            <div style="display: none;" id="loginMember">${loginEmpVo.no}</div>
            <div id="carImg">
                <ul class="slider">
                    <li class="items"><img src="/img/rent/차량1.jpg" alt=""></li>
                    <li class="items"><img src="/img/rent/차량2.jpg" alt=""></li>
                    <li class="items"><img src="/img/rent/차량3.jpg" alt=""></li>
                    <li class="items"><img src="/img/rent/차량4.jpg" alt=""></li>
                    <li class="items"><img src="/img/rent/차량5.jpg" alt=""></li>
                </ul>
                <div class="overlay">
                    <div class="overlay-text">
                        저희 <h2>Baby-Works는</h2>
                        임원분들의 편안한 출장과 워크샵을 위하여
                        최상의 차량을 제공합니다
                    </div>
                </div>
            </div>
        </div>
    </main>

</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/rent/carList.js"></script>

