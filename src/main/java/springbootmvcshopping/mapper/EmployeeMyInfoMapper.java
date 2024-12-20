package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springbootmvcshopping.domain.EmployeeDTO;

@Mapper
public interface EmployeeMyInfoMapper {
    public EmployeeDTO employeeSelectOne(String empId);
    public Integer employeeModify(EmployeeDTO employeeDTO);
    public void employeePwUpdate(@Param("pw") String pw, @Param("empId") String empId);
}
