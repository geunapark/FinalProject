<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>직원로그인</title>
    <!-- 글씨체 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">

   <link rel="stylesheet" href="/emp_login.css">
   <script src="/emp_login.js"></script>
</head>

<body>

    <main>

        <div class="mainjoin"><h1>🪪직원 로그인 </h1></div>

        <form id="signupForm" action="/app/?/?" method="post" enctype="multipart/form-data">
            <div class="form-group">
                 <label for="employee_no" class=""><h3> 사원번호 :</h3></label>
                 <input type="text" id="employeeNumber" name="employee_no" placeholder="사원번호 입력">
            </div>
            <div class="form-group">
                <label for="id"><h3>아이디</h3> </label>
                <input type="text" id="id"  name="id" class="id-input" placeholder="아이디 입력">

            </div>
            <div class="form-group">
                <label for="password"><h3>비밀번호</h3> </label>
                <input type="password" id="password" name="password" placeholder="비밀번호 입력">

            </div>

            <div class="btncenter">
                <button type="button" onclick="validateForm()">로그인하기</button>
            </div>
        </form>
    </main>


</body>
</html>