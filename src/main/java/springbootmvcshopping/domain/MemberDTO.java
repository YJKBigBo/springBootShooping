package springbootmvcshopping.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("MemberDTO")
@Data
public class MemberDTO {
    //테이블에 있는 칼럼 이름과 같아야한다.
    String memberNum;
    String memberName;
    String memberId;
    String memberPw;
    String memberAddr;
    String memberAddrDetail;
    int memberPost;
    Date memberRegist;
    String memberGender;
    String memberPhone1;
    String memberPhone2;
    String memberEmail;
    Date memberBirth;
    int memberPoint;
    String memberEmailConfirm;
}
