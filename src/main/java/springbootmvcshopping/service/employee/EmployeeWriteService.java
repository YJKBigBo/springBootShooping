package springbootmvcshopping.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.EmployeeCommand;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.mapper.EmployeeMapper;

@Service
public class EmployeeWriteService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmployeeMapper employeeMapper;

    public void execute(EmployeeCommand employeeCommand){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmpAddr(employeeCommand.getEmpAddr());
        dto.setEmpEmail(employeeCommand.getEmpEmail());
        dto.setEmpId(employeeCommand.getEmpId());
        dto.setEmpJumin(employeeCommand.getEmpJumin());
        dto.setEmpHireDate(employeeCommand.getEmpHireDate());
        dto.setEmpAddrDetail(employeeCommand.getEmpAddrDetail());
        dto.setEmpPost(employeeCommand.getEmpPost());
        dto.setEmpPhone(employeeCommand.getEmpPhone());
        dto.setEmpNum(employeeCommand.getEmpNum());
        dto.setEmpName(employeeCommand.getEmpName());

        // 스프링 시큐리티를 이용한 간단한 암호화 과정
        String encodePw = passwordEncoder.encode(employeeCommand.getEmpPw());
        dto.setEmpPw(encodePw);

        employeeMapper.employeeInsert(dto);
    }
}
