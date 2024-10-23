package springbootmvcshopping.service.myPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.EmployeeCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.mapper.EmployeeMyInfoMapper;

@Service
public class EmployeeModifyService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmployeeMyInfoMapper employeeMyInfoMapper;

    public void execute(EmployeeCommand employeeCommand, HttpSession session){
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        if(passwordEncoder.matches(employeeCommand.getEmpPw(), auth.getUserPw())){
            EmployeeDTO dto =  new EmployeeDTO();
            dto.setEmpPhone(employeeCommand.getEmpPhone());
            dto.setEmpEmail(employeeCommand.getEmpEmail());
            dto.setEmpAddr(employeeCommand.getEmpAddr());
            dto.setEmpAddrDetail(employeeCommand.getEmpAddrDetail());
            dto.setEmpPost(employeeCommand.getEmpPost());
            dto.setEmpNum(employeeCommand.getEmpNum());
            employeeMyInfoMapper.employeeModify(dto);
        }
    }
}
