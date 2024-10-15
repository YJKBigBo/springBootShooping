package springbootmvcshopping.command;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberCommand {
    String memberNum;
    @NotEmpty(message = "이름을 입력해주세요.")
    String memberName;

    @NotEmpty(message = "아이디를 입력해주세요.")
    String memberId;

//    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
    @NotEmpty(message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
    String memberPw;

    @NotBlank(message = "비밀번호 확인을 입력해주세요.")
    String memberPwCon;

    @NotEmpty(message = "주소를 입력해 주세요.")
    String memberAddr;
    String memberAddrDetail;
    String memberPost;

    @NotEmpty(message = "연락처를 입력해 주세요.")
    @Size(min = 11, max = 23)
    String memberPhone1;

    String memberPhone2;

    String memberGender;

    @NotNull(message = "생년월일을 입력해주세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date memberBirth;

    @NotEmpty(message = "이메일을 입력하여 주세요.")
    String memberEmail;

    public boolean isMemberPwEqualMemberPwCon(){
        return memberPw.equals(memberPwCon);
    }
}
