package springbootmvcshopping.command;

import lombok.Data;

@Data
public class LoginCommand {
    String userId;
    String userPw;
}
