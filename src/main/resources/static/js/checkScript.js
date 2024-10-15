$(function (){
    $("#btn").click(function(){
        var userId = $("#userId").val();
        $(opener.document).find("#userId").val(userId);
        window.self.close();
    });

    $("#frm").submit(function (){
        if($("#memberPw").val() != $("#memberPwCon").val){
            alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
            $("#memberPw").val("");
            $("#memberPwCon").val("");
            $("#memberPw").focus();
            return false;
        }
    });

    $("#userId").bind("click", function (){
        $("#userId").val("");
        window.open("idCheck.use","아이디검색","width=400, height=200, left=130, top=150");
    });
})