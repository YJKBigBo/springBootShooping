package springbootmvcshopping.service.myPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.mapper.EmployeeMyInfoMapper;

@Service
public class EmployeePwUpdateService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmployeeMyInfoMapper employeeMyInfoMapper;

    public void execute(String oldPw, String newPw, HttpSession session){
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        if(passwordEncoder.matches(oldPw, auth.getUserPw())){
            String pw = passwordEncoder.encode(newPw);
            employeeMyInfoMapper.employeePwUpdate(pw, auth.getUserId());
            auth.setUserPw(pw);
        }
    }
}
