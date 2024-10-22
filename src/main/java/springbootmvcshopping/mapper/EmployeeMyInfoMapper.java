package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.EmployeeDTO;

@Mapper
public interface EmployeeMyInfoMapper {
    public EmployeeDTO EmployeeSelectOne(String empId);
}
