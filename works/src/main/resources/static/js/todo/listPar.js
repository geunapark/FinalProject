function listPar() {
  console.log("담당할일");

  $.ajax({
    url: "http://127.0.0.1:8080/todo/listPar",
    method: "GET",
    data: {},
    success: function (listPar) {
      //리스트 데이터 받아옴
      const table = document.querySelector("#todoList");
      const detail = document.querySelector("#detail");

      let str = "";
      for (let i = 0; i < listPar.length; i++) {
        str += "<tr>";
        str +=
          "<td class='todo-checkbox-container'><input type='checkbox' class='todo-checkbox' todo-no='" +
          listPar[i].todoNo +
          "'></td>";
        //completedYn이용하여 완료한 할일은 제목에 줄 그어주기...!
        if (listPar[i].completedYn === "Y") {
          str +=
            "<td class='todo-title' style='text-decoration: line-through;'>" +
            listPar[i].title +
            "</td>";
        } else {
          str += "<td class='todo-title'>" + listPar[i].title + "</td>";
        }
        str += "<td class='hidden-column' >" + listPar[i].todoNo + "</td>"; // todoNo 열을 숨김 처리
        str += "</tr>";
        str += "<tr>";
        str +=
          "<td class='empAndEnd' colspan='2'>요청자: " +
          listPar[i].todoEmpName +
          " | 기한: " +
          listPar[i].endDate +
          "</td>";
        str += "</tr>";
        str += "<tr><td colspan='2'>&nbsp;</td></tr>"; //공백추가
      }
      table.innerHTML = str;
      detail.innerHTML = "";
    },
    error: function (err) {
      console.error("담당조회 아작스 실행중 에러", err);
      alert("담당조회 아작스 실행중 에러");
    },
  });
}
