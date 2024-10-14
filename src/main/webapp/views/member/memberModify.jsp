<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="memberModify.mem" method="post">
  <table border="1">
    <tr>
      <td>회원번호 : <input type="text" name="memberNum" value="${dto.memberNum}" readonly="readonly"></td>
    </tr>
    <tr>
      <td>회원이름 : <input type="text" name="memberName" value="${dto.memberName}"/></td>
    </tr>
    <tr>
      <td>회원아이디 : <input type="text" name="memberId" value="${dto.memberId}"/></td>
    </tr>
    <tr>
      <td>회원비밀번호 : <input type="password" name="memberPw" value="${dto.memberPw}"/></td>
    </tr>
    <tr>
      <td>회원주소 : <input type="text" name="memberAddr" value="${dto.memberAddr}"/></td>
    </tr>
    <tr>
      <td>상세주소 : <input type="text" name="memberAddrDetail" value="${dto.memberAddrDetail}"/></td>
    </tr>
    <tr>
      <td>우편번호 : <input type="text" name="memberPost" value="${dto.memberPost}"/></td>
    </tr>
    <tr>
      <td>회원성별 :
        <input type="radio" name="memberGender" value="M"
        <c:if test="${dto.memberGender == 'M'}">checked</c:if>/>남자
        <input type="radio" name="memberGender" value="F"
        <c:if test="${dto.memberGender == 'F'}">checked</c:if>/>여자
      </td>
    </tr>
    <tr>
      <td>회원연락처 1 : <input type="tel" name="memberPhone1" value="${dto.memberPhone1}"/></td>
    </tr>
    <tr>
      <td>회원연락처 2 : <input type="tel" name="memberPhone2" value="${dto.memberPhone2}"/></td>
    </tr>
    <tr>
      <td>회원생년월일 : <input type="date" name="memberBirth" value="${dto.memberBirth}"/></td>
    </tr>
    <tr>
      <td>회원이메일 : <input type="email" name="memberEmail" value="${dto.memberEmail}"/></td>
    </tr>
  </table>
  <input type="submit" value="회원수정" />
  </table>
</form>
</body>
</html>
