package springbootmvcshopping.service.myPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.mapper.EmployeeMyInfoMapper;
import springbootmvcshopping.mapper.MemberInfoMapper;

@Service
public class EmployeeMyInfoService {
    @Autowired
    EmployeeMyInfoMapper employeeMyInfoMapper;

    public void execute(HttpSession session, Model model) {
        String empId = session.getId();
        EmployeeDTO dto = employeeMyInfoMapper.EmployeeSelectOne(empId);
        model.addAttribute("EmployeeCommand", dto);
    }
}
