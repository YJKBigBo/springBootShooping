package springbootmvcshopping.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCommand {
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
