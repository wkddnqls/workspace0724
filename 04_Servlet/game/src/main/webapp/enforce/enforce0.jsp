<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강화하기</title>
<style>
body {
    font-family: "Noto Sans KR", sans-serif;
    background-color: #2c3e50; /* 단색 */
    margin: 0;
    padding: 0;
    color: #fff;
    text-align: center;
}

h1 {
    margin: 0;
    padding: 30px 0;
    font-size: 28px;
    background: rgba(0, 0, 0, 0.3);
    text-shadow: 2px 2px 4px rgba(0,0,0,0.6);
}

form {
    margin-top: 50px;
}

button, .link-button {
    display: inline-block;
    padding: 15px 30px;
    margin: 15px 10px;
    font-size: 18px;
    font-weight: bold;
    border-radius: 10px;
    cursor: pointer;
    border: none;
    transition: all 0.3s ease;
    text-decoration: none;
    color: #fff;
    box-shadow: 0 4px 8px rgba(0,0,0,0.3);
}

button {
    background-color: #1abc9c;
}

button:hover {
    background-color: #16a085;
    transform: scale(1.05);
    box-shadow: 0 6px 12px rgba(0,0,0,0.4);
}

.link-button {
    background-color: #e74c3c;
}

.link-button:hover {
    background-color: #c0392b;
    transform: scale(1.05);
    box-shadow: 0 6px 12px rgba(0,0,0,0.4);
}
</style>

<h1>강화 시도! 1~2 중 숫자를 맞추세요 (확률 50%)</h1>

<form action="enforceAction.do" method="post">
    <input type="hidden" name="name" value="${param.name}">
    <input type="hidden" name="type" value="${param.type}">
    
    <button type="submit" name="num" value="1">1번</button>
    <button type="submit" name="num" value="2">2번</button>
    <a href="<%=request.getContextPath()%>/index.jsp" class="link-button">강화 포기 (메인 메뉴로 돌아가기)</a>
</form>

</body>
</html>