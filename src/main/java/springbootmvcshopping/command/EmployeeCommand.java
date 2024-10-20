package springbootmvcshopping.command;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeCommand {
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
