<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   <!DOCTYPE html>
   <html lang="en">

   <head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Messenger</title>
     <link rel="stylesheet" href="/css/messenger/write.css">
   </head>

   <body>

     <nav>
       <div id="right-sidebar">
         <div><button><img src="../resources/img/free-icon-menu-2791777.png" alt=""></button></div>
         <div><img src="../resources/img/스크린샷 2024-06-18 195610.png" alt=""></div>
         <div id="title">게시판</div>
       </div>
       <div id="left-sidebar">
         <div><a href=""><img src="../resources/img/스크린샷 2024-06-18 195610.png" alt=""></a></div>
         <div><a href=""><img src="../resources/img/스크린샷 2024-06-18 195610.png" alt=""></a></div>
         <div><a href=""><img src="../resources/img/스크린샷 2024-06-18 195610.png" alt=""></a></div>
         <div><a href=""><img src="../resources/img/스크린샷 2024-06-18 195610.png" alt=""></a></div>
         <div><a href=""><img src="../resources/img/스크린샷 2024-06-18 195610.png" alt=""></a></div>
         <div><a href=""><img src="../resources/img/스크린샷 2024-06-18 195610.png" alt=""></a></div>
         <div><a href=""><img src="../resources/img/스크린샷 2024-06-18 195610.png" alt=""></a></div>
         <div><a href=""><img src="../resources/img/스크린샷 2024-06-18 195610.png" alt=""></a></div>
         <div><button><img src="../resources/img/free-icon-person-11081570.png" alt=""></button></div>
       </div>
     </nav>

     <main>
       <div id="sidebar">
         <div id="messenger-write"><button>쪽지쓰기</button></div>
         <div id="messenger-status">
           <div><button>안읽음</button></div>
           <div><button>중요</button></div>
           <div><button>휴지통</button></div>
         </div>
         <hr>
         <div id="all-messenger">
           <a href="http://localhost:8080/messenger/all"><p>전체쪽지</p></a>
         </div>
         <div id="receive-messenger">
           <p>받은쪽지</p>
         </div>
         <div id="send-messenger">
           <p>보낸쪽지</p>
         </div>
         <div id="save-messenger">
             <p>임시저장</p>
         </div>
       </div>



       <div id="messenger-main">
        <form action="/messenger/all" method="get" enctype="multipart/form-data">
         <div id="messenger-search">
           <div><input type="text" placeholder="검색어를 입력해주세요."></div>
           <div><input type="button" value="검색"></div>
         </div>
         <div id="messenger-check">
           <div id="check-all"><input type="checkbox">전체선택</div>
           <div id="check-delete"><input type="button" value="삭제"></div>
         </div>
         <div id="messenger-content">
           <c:forEach var="message" items="${voList}">
            <div class="messenger-item">
               <div><input id="checkbox-delete" type="checkbox"></div>
               <div><input id="checkbox-important" type="checkbox"></div>
               <div id="list-person">${message.name}</div>
               <div id="list-title">${message.title}</div>
               <div id="list-date">${message.sendDate}</div>
            </div>
           </c:forEach>
         </div>
        </form>
       </div>
     </main>


   </body>

   </html>