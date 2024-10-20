package springbootmvcshopping.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("EmployeeDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    String empNum;
    String empId;
    String empPw;
    String empName;
    String empAddr;
    String empAddrDetail;
    Integer empPost;
    String empPhone;
    String empJumin;
    String empEmail;
    Date empHireDate;
    String empImage;
}
