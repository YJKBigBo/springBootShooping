package springbootmvcshopping.service.employee;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.mapper.EmployeeMapper;

@Service
public class EmployeeDetailService {
    @Autowired
    EmployeeMapper employeeMapper;

    public void execute(String empNum, Model model, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String empId = auth.getUserNum();
        EmployeeDTO employeeDTO = employeeMapper.employeeSelectOne(empId);
        model.addAttribute("employeeCommand", employeeDTO);
    }
}
