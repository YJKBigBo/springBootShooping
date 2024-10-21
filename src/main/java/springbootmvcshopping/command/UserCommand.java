package springbootmvcshopping.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserCommand {
    @NotBlank(message = "이름을 입력해야합니다.")
    String memberName;
    @NotEmpty(message = "아이디를 입력해야합니다.")
    String memberId;
    String memberPw;
    String memberPwCon;
    String memberAddr;
    String memberAddrDetail;
    Integer memberPost;
    String memberGender;
    String memberPhone1;
    String memberPhone2;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date memberBirth;
    String memberEmail;
}
