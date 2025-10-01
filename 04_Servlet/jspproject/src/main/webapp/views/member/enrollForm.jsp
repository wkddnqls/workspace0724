<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
     <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
   <style>

 .container{
    padding: 72px 24px;
    display:flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 24px;
   }
   .container table tr{
    height: 4px;
   }
   </style>
   
</head>

<body>
    <jsp:include page="/views/common/menubar.jsp"/>
  <div class="container">

    <h2>회원가입</h2>
    <form action="${pageContext.request.contextPath}/insert.me" method="post">
        <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="userId" required class="form-control" placeholder="아이디를 입력하세요"></td>
                    <td><button type="button" onclick="" class="btn">중복확인</button></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="userPwd" required class="form-control" placeholder="비밀번호 입력"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>비빌번호 확인</td>
                    <td><input type="password" required class="form-control" placeholder="비밀번호 확인(입력)"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="userName" required class="form-control" placeholder="이름 입력.."></td>
                    <td></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone" class="form-control" placeholder="전화번호 입력.."></td>
                    <td></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" name="email" class="form-control" placeholder="이메일 입력.." ></td>
                    <td></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address" class="form-control" placeholder="주소 입력.."></td>
                    <td></td>
                </tr>
                <tr>
                    <td>관심분야</td>
                    <td colspan="2">
                        <label>
                            <input type="checkbox" name="interest" value="sports">
                            운동
                        </label>
                        <label>
                            <input type="checkbox" name="interest" value="hiking">
                            등산
                        </label>
                        <label>
                            <input type="checkbox" name="interest" value="fishing">
                            낚시
                        </label>
                        <br>
                        <label>
                            <input type="checkbox" name="interest" value="cooking">
                            요리
                        </label>
                        <label>
                            <input type="checkbox" name="interest" value="gaming">
                            게임
                        </label>
                        <label>
                            <input type="checkbox" name="interest" value="movie">
                            영화
                        </label>
                        <label>
                            <input type="checkbox" name="interest" value="other">
                            기타
                        </label>
                    </td>
                </tr>
            </table>

            <br><br>

            <div align = "center">
                <input type="submit" value="회원가입" class="btn btn-secondary">
                <input type="reset" value="다시입력" class="btn btn-secondary">
            </div>
    </form>
  </div>
    
</body>
</html>














