package springbootmvcshopping.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("AuthInfoDTO")
public class AuthInfoDTO {
    String userId;
    String userPw;
    String userName;
    String userEmail;
    String grade;
    String userNum;
}
