$(document).ready(function() {
    // loginMember 값 가져오기
    const loginMember = document.querySelector("#loginMember").innerText.trim();
    console.log("loginMember:", loginMember);
    
    // 리스트 조회하기
    $.ajax({
        url: "/api/rent/car",
        method: "get",
        success: (data) => {
            const content = document.querySelector("#carContent");

            let str = "";

            for (let i = 0; i < data.length; i++) {
                str += "<div>" + `${data[i].vhclRsvNo}` + "</div>";
                str += "<div>" + data[i].empName + "</div>";
                str += "<div>" + data[i].vhclNumber + "</div>";
                str += "<div>" + data[i].name + "</div>";
                str += "<div>" + data[i].approvalStatus + "</div>";
                str += `<button class="openBtn" data-no="${data[i].vhclRsvNo}">상세조회</button>`;
            }

            content.innerHTML = str;

            const openBtns = document.querySelectorAll(".openBtn");
            openBtns.forEach((btn) => {
                btn.addEventListener("click", () => {
                    const vhclRsvNo = btn.getAttribute("data-no");
                    detail(vhclRsvNo, loginMember);
                });
            });
        },
        error: () => {}
    });
});

function detail(no, loginMember) {
    const detail = document.querySelector("#detail");

    $.ajax({
        url: "/api/rent/detail/car",
        method: "get",
        data: {
            no: no
        },
        success: (data) => {
            let str = "";
            str += "<div>" + `${data.vhclRsvNo}` + "</div>";
            str += "<div>" + `${data.loanDate}` + "</div>";
            str += "<div>" + `${data.returnDate}` + "</div>";
            str += "<div>" + `${data.reason}` + "</div>";
            str += "<div>" + `${data.vhclNumber}` + "</div>";
            str += "<div>" + `${data.name}` + "</div>";
            str += "<div>" + data.approvalStatus + "</div>";
            str += "<div>" + data.empName + "</div>";

            const writeNo = data.empNo;

            if (loginMember === writeNo) {
                if (data.approvalStatus !== "승인" && data.approvalStatus !== "보류") {
                    str += `<button onclick="editDate('${data.vhclRsvNo}', '${data.loanDate}', '${data.returnDate}', '${data.reason}', '${data.vhclNumber}', '${data.name}')">수정하기</button>`;
                } else {
                    str += `<button onclick="cancel('${data.vhclRsvNo}')">예약 취소</button>`;
                }
            }

            detail.innerHTML = str;
            detail.style.display = "block"; 
        },
        error: () => {
            alert("잠시 후 다시 조회해주세요");
        }
    });
}

function editDate(vhclRsvNo, loanDate, returnDate, reason, vhclNumber, name) {
    const detail = document.querySelector("#detail");

    let str = `
        <input type="date" id="loanDate" name="loanDate" value="${loanDate}"><br><br>
        <input type="date" id="returnDate" name="returnDate" value="${returnDate}"><br><br>
        <label for="reason">사유:</label><br>
        <textarea id="reason" name="reason" placeholder="${reason}"></textarea><br><br>
        <select id="carOption">
        </select>
        <button onclick="carEdit('${vhclRsvNo}')">수정완료</button>
    `;

    detail.innerHTML = str;

    // 옵션 값 가져오기
    $.ajax({
        url: "/api/rent/option/car",
        method: "get",
        success: (data) => {
            const carOption = document.querySelector("#carOption");
            let option = "";

            for (let i = 0; i < data.length; i++) {
                if (data[i].vhclNumber === vhclNumber) {
                    option += `<option value="${data[i].vhclNo}" selected>${data[i].name} [ 차량번호 : ${data[i].vhclNumber} ]</option>`;
                } else {
                    option += `<option value="${data[i].vhclNo}">${data[i].name} [ 차량번호 : ${data[i].vhclNumber} ]</option>`;
                }
            }

            carOption.innerHTML = option;
        },
        error: () => {
            console.error("옵션 로딩 실패");
        }
    });
}

function carEdit(no) {

    const loanDate = document.querySelector("#loanDate").value;
    const returnDate = document.querySelector("#returnDate").value;
    const reason = document.querySelector("#reason").value;
    const carOption = document.querySelector("#carOption").value;
    console.log(loanDate);
    console.log(returnDate);
    console.log(reason);
    console.log(carOption);

    
    $.ajax({
        url:"/api/rent/car"
        ,method:"put"
        ,data:{
            no:no
            ,vhclNo:carOption
            ,loanDate:loanDate
            ,returnDate:returnDate
            ,reason:reason

        }
        ,success:()=>{
            alert("수정 성공하였습니다");
            location.reload();
            
        }
        ,error:()=>{
            alert("수정 실패하였습니다 담당부서로 연락주세요"+
                "010 - 5738 - 2844 [ 인사팀 : 박근아]"
            )
        }
    })
}

function cancel(no) {
    $.ajax({
        url:"/api/rent/carCancle"
        ,method:"put"
        ,data:{
            no:no
        }
        ,success:()=>{
            alert("예약 취소되었습니다 감사합니다")
            location.reload();
        }
        ,error:()=>{
            alert("예약취소 실패하였습니다 담당부서로 연락주세요 010-5738-2844 [인사팀 : 박근아]")
        }
    })    
}


var divTag = document.querySelector("#carImg");
var slides = document.querySelectorAll(".items");
var slidesCnt = slides.length;

var slider = document.querySelector(".slider");

// 초기 슬라이드 컨테이너의 너비와 슬라이드의 너비를 계산
function updateSliderWidth() {
    var divTagWidth = divTag.clientWidth;
    slider.style.width = (divTagWidth * slidesCnt) + 'px';
    return divTagWidth;
}

var divTagWidth = updateSliderWidth();
var slidIndex = 0;

// 슬라이드를 자동으로 전환하는 함수
function showSlides() {
    slidIndex++;
    if (slidIndex >= slidesCnt) {
        slidIndex = 0;
    }
    slider.style.transform = `translateX(${-divTagWidth * slidIndex}px)`;
    setTimeout(showSlides, 3000);
}

// 슬라이드 쇼 시작
showSlides();

// 윈도우 크기 변경 시 슬라이드 컨테이너 너비 업데이트
window.addEventListener('resize', function() {
    divTagWidth = updateSliderWidth();
    slider.style.transform = `translateX(${-divTagWidth * slidIndex}px)`;
});
