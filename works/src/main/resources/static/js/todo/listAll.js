function listAll() {
  console.log("전체할일");

  $.ajax({
    url: "http://127.0.0.1:8080/todo/listAll",
    method: "GET",
    data: {},
    success: function (listAll) {
      //리스트 데이터 받아옴
      const table = document.querySelector("#todoList");

      let str = "";
      for (let i = 0; i < listAll.length; i++) {
        str += "<tr>";
        str += "<td>" + listAll[i].title + "</td>";
        str += "<td class='hidden-column'>" + listAll[i].todoNo + "</td>"; // todoNo 열을 숨김 처리
        str += "</tr>";
        str += "<tr>";
        str += "<td>요청자 " + listAll[i].todoEmpName + "</td>";
        str += "<td>기한 " + listAll[i].endDate + "</td>";
        str += "</tr>";
        str += "<tr><td colspan='2'>&nbsp;</td></tr>"; //공백추가
      }
      table.innerHTML = str;
    },
    error: function (err) {
      console.error("리스트 아작스 실행중 에러", err);
      alert("리스트 아작스 실행중 에러");
    },
  });
}