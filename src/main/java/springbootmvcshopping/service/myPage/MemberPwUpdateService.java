package springbootmvcshopping.service.myPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.mapper.MemberInfoMapper;

@Service
public class MemberPwUpdateService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private MemberInfoMapper memberInfoMapper;

    public void execute(String oldPw, String newPw, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        if(passwordEncoder.matches(oldPw, auth.getUserPw())){
            memberInfoMapper.memberPwUpdate(newPw, auth.getUserId());
            String pw = passwordEncoder.encode(newPw);
            auth.setUserPw(pw);
        }
    }
}
