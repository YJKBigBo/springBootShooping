package springbootmvcshopping.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.EmployeeCommand;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.mapper.EmployeeMapper;

@Service
public class EmployeeUpdateService {
    @Autowired
    EmployeeMapper employeeMapper;

    public void execute(EmployeeCommand employeeCommand) {
        System.out.println(employeeCommand);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpPw(employeeCommand.getEmpPw());
        employeeDTO.setEmpName(employeeCommand.getEmpName());
        employeeDTO.setEmpNum(employeeCommand.getEmpNum());
        employeeDTO.setEmpPost(employeeCommand.getEmpPost());
        employeeDTO.setEmpPhone(employeeCommand.getEmpPhone());
        employeeDTO.setEmpEmail(employeeCommand.getEmpEmail());
        employeeDTO.setEmpAddrDetail(employeeCommand.getEmpAddrDetail());
        employeeDTO.setEmpAddr(employeeCommand.getEmpAddr());
        employeeDTO.setEmpJumin(employeeCommand.getEmpJumin());
        employeeDTO.setEmpId(employeeCommand.getEmpId());
        employeeMapper.employeeUpdate(employeeDTO);
    }
}
