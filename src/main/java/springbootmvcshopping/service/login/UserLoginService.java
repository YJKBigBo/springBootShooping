package springbootmvcshopping.service.login;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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

    public void execute(LoginCommand loginCommand, HttpSession httpSession) {
        AuthInfoDTO auth = loginMapper.loginSelectOne(loginCommand.getUserId());
        if(auth != null){
            //passwordEncoder.matches('본문','암호문'); 복호화 과정
            if(passwordEncoder.matches(loginCommand.getUserPw(), auth.getUserPw())){
                httpSession.setAttribute("auth", auth);
            }
        } else {
            System.out.println("아이디가 존재하지 않습니다.");
        }
    }
}
