package springbootmvcshopping.service.myPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.mapper.EmployeeMapper;
import springbootmvcshopping.mapper.EmployeeMyInfoMapper;

@Service
public class EmployeeInfoService {
    @Autowired
    EmployeeMyInfoMapper employeeMyInfoMapper;

    public void execute(HttpSession session, Model model) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        EmployeeDTO dto = employeeMyInfoMapper.employeeSelectOne(auth.getUserId());
        model.addAttribute("employeeCommand", dto);
    }
}
