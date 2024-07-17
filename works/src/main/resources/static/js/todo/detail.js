function getTodoDetail(todoNo) {
  $.ajax({
    url: "http://127.0.0.1:8080/todo/detail",
    method: "GET",
    data: { todoNo: todoNo },
    success: function (data) {
      console.log(data);
      const detail = document.querySelector("#detail");

      let str = "";
      str += `<div id='todoNo' class='hidden-no'>${data[0].todoNo}</div>`;
      str += `<div class='todo-content'>`;
      str += `<span name='changeTitle' id='title'>${data[0].title}</span>`;
      str += `<span name='changeContent' id='content'>${data[0].content}</span>`;
      str += `</div>`;
      str += `<div id='create-date'>작성일: ${data[0].createDate}</div>`;
      str += `<div id='end-date'>기한: ${data[0].endDate}</div>`;

      str += `<div class='request'>요청자: <button onclick="getEmpDetail(${data[0].todoEmpNo});">${data[0].todoEmpName}</button></div>`;

      str += `<div class='manager'>담당자: `;
      for (let i = 0; i < data.length; i++) {
        str += `<button onclick="getEmpDetail(${data[i].todoManagerNo});">${data[i].todoManagerName}</button>`;
      }
      str += `</div>`;

      // 수정 및 삭제 버튼을 같은 div에 넣기
      str += `<div class='action-btn'>`;
      str += `<button class='editBtn' onclick='editBtn(${data[0].todoNo});'>수정하기</button>`;
      str += `<button onclick='delTodo(${data[0].todoNo});'>삭제하기</button>`;

      // 완료되지 않은 할일에만 버튼 생기게
      if (data[0].completedYn !== "Y") {
        str += `<button id='comBtn' onclick='complete(${data[0].todoNo});'>완료하기</button>`;
      }
      str += `</div>`; // action-btn div 종료

      // 기존 내용을 제거하고 새로운 내용을 삽입
      detail.innerHTML = str; // 수정: str을 사용하여 내용을 업데이트
    },
    error: function (err) {
      console.error("상세조회 ajax 실행중 에러", err);
    },
  });
}
