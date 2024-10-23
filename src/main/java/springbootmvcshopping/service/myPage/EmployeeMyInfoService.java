package springbootmvcshopping.service.myPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.mapper.EmployeeMyInfoMapper;
import springbootmvcshopping.mapper.MemberInfoMapper;

@Service
public class EmployeeMyInfoService {
    @Autowired
    EmployeeMyInfoMapper employeeMyInfoMapper;

    public void execute(HttpSession session, Model model) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String empId = auth.getUserId();
        EmployeeDTO dto = employeeMyInfoMapper.employeeSelectOne(empId);
        model.addAttribute("EmployeeCommand", dto);
    }
}
