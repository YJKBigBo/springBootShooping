<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="js/daumAddressScript.js"></script>
<script type="text/javascript" src="js/checkScript.js"></script>
<body>
<form action="memberRegist.mem" method="post">
    <table border="1">
        <tr>
            <td>회원번호 : <input type="text" name="memberNum" value="${memberNum}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>회원이름 : <input type="text" name="memberName" /></td>
        </tr>
        <tr>
            <td>회원아이디 : <input type="text" name="memberId" id="userId"/></td>
        </tr>
        <tr>
            <td>회원비밀번호 : <input type="password" name="memberPw" /></td>
        </tr>
        <tr>
            <td>회원비밀번호 확인 : <input type="password" name="memberPwCon" /></td>
        </tr>
        <tr>
            <td>회원주소 : <input type="text" name="memberAddr" id="sample4_roadAddress" required="required" readonly="readonly"zz/> <button type="button" onclick="execDaumPostcode();">우편번호 검색</button></td>
        </tr>
        <tr>
            <td>상세주소 : <input type="text" name="memberAddrDetail" /></td>
        </tr>
        <tr>
            <td>우편번호 : <input type="text" name="memberPost" /></td>
        </tr>
        <tr>
            <td>회원성별 :
                <input type="radio" name="memberGender" value="M" />남자
                <input type="radio" name="memberGender" value="F" />여자
            </td>
        </tr>
        <tr>
            <td>회원연락처 1 : <input type="tel" name="memberPhone1" /></td>
        </tr>
        <tr>
            <td>회원연락처 2 : <input type="tel" name="memberPhone2" /></td>
        </tr>
        <tr>
            <td>회원생년월일 : <input type="date" name="memberBirth" /></td>
        </tr>
        <tr>
            <td>회원이메일 : <input type="email" name="memberEmail" /></td>
        </tr>
    </table>
        <input type="submit" value="회원등록" />
    </table>
</form>
회원 등록 페이지 입니다.
</body>
</html>
