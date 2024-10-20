package springbootmvcshopping.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("EmployeeDTO")
@Data
public class EmployeeDTO {
    String empNum;
    String empId;
    String empPw;
    String empName;
    String empAddr;
    String empAddrDetail;
    int empPost;
    String empPhone;
    String empJumin;
    String empEmail;
    Date empHireDate;
    String empImage;
}
