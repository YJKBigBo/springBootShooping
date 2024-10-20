package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.domain.StartEndPageDTO;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    public Integer employeeCount();
    public List<EmployeeDTO> employeeSelectList(StartEndPageDTO sepDTO);
    public void employeeInsert(EmployeeDTO employeeDTO);
    public EmployeeDTO employeeSelectOne(String empNum);
    public void employeeUpdate(EmployeeDTO employeeDTO);
}
