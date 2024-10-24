package springbootmvcshopping.service.login;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import springbootmvcshopping.command.LoginCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.mapper.LoginMapper;
import springbootmvcshopping.service.IdcheckService;

@Service
public class UserLoginService {
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    public void execute(LoginCommand loginCommand
            ,HttpSession session, BindingResult result) {
        AuthInfoDTO auth = loginMapper.loginSelectOne(loginCommand.getUserId());
        System.out.println(auth.getUserNum());
        System.out.println(auth.getUserName());
        System.out.println(auth.getUserPw());
        if(auth != null) {
            System.out.println("아이디가 존재합니다.");
            if(passwordEncoder.matches(loginCommand.getUserPw()
                    , auth.getUserPw())) {
                System.out.println("비밀번호가 일치합니다.");
                session.setAttribute("auth", auth);
                System.out.println(auth.getUserId());
            }else {
                result.rejectValue("userPw", "loginCommand.userPw"
                        , "비밀번호가 틀렸습니다.");
                System.out.println("비밀번호가 일치하지 않는다.");
            }
        }else {
            result.rejectValue("userId", "loginCommand.userId"
                    , "아이디가 존재하지 않습니다.");
            System.out.println("아이디가 존재하지 않습니다.");
        }

    }
}
