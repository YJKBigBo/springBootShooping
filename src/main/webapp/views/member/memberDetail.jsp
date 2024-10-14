<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>memberDetail</title>
</head>
<body>
회원상세 <br />
    회원번호 : ${dto.memberNum} <br />
    회원이름 : ${dto.memberName} <br />
    회원생일 : ${dto.memberBirth} <br/>
    회원주소 : ${dto.memberAddr} <br />
    회원연락처 : ${dto.memberPhone1} <br />
    회원성별 : <c:if test="${dto.memberGender == 'M'}">남자</c:if>
            <c:if test="${dto.memberGender == 'F'}">여자</c:if>
    <br />
    <a href="memberUpdate.mem?memberNum=${dto.memberNum}">회원수정</a>
    <a href="memberDelete.mem?memberNum=${dto.memberNum}">회원삭제</a>
</body>
</html>
