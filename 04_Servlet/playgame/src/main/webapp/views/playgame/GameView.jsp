<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="./GameView.css">
<body>
     <h1>========= 강화 관리 프로그램 및 레이드 프로그램==========</h1>
  <form action="/playEnforce">
    <input type="submit" value="1.강화하기">
  </form>
    
    <button onclick="selectAll()">2. 전체 목록 조회</button><br>
    <button onclick="insert()">3. 장비 이름 저장</button><br>
    <button onclick="deleteItem()">4. 목록 삭제하기</button><br>
    <button onclick="selectKeyword()">5. 키워드 검색</button><br>
    <button onclick="update()">6. 사용처 수정하기</button><br>
    <button onclick="showHuman()">7. 유저 옵션 보기</button><br>
    <button onclick="showMonster()">8. 몬스터 옵션 보기</button><br>
    <button onclick="monsterAttack()">9. 몬스터 사냥하기</button><br>
    <button onclick="exitProgram()">10. 프로그램 종료</button>

    <div id="output">여기에 결과가 표시됩니다.</div>
    <script src="GameView.js"></script>
</body>
</html>