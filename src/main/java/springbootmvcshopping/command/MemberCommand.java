package springbootmvcshopping.command;

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
    String memberName;
    String memberId;
    String memberPw;
    String memberPwCon;
    String memberAddr;
    String memberAddrDetail;
    String memberPost;
    String memberPhone1;
    String memberPhone2;
    String memberGender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date memberBirth;
    String memberEmail;

    public boolean isMemberPwEqualMemberPwCon(){
        return memberPw.equals(memberPwCon);
    }
}
