<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>memberList</title>
</head>
<body>
회원리스트 <br />
회원수 : ${list.size()}<br />
<c:forEach items="${list}" var="dto">
    <table border="1">
        <tr>
            <td><a href="memberDetail.mem?memberNum=${dto.memberNum}">회원번호 : ${dto.memberNum}</a></td>
            <td>회원이름 : ${dto.memberName}</td>
            <td>회원생일 : ${dto.memberBirth}</td>
        </tr>
    </table>
</c:forEach>
<a href="memberWrite.mem">회원등록</a> <br/>
</body>
</html>
