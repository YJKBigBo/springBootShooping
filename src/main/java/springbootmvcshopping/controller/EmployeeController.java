package springbootmvcshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springbootmvcshopping.command.EmployeeCommand;
import springbootmvcshopping.service.AutoNumService;
import springbootmvcshopping.service.employee.EmployeeDeleteService;
import springbootmvcshopping.service.employee.EmployeeListService;
import springbootmvcshopping.service.employee.EmployeeWriteService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeListService employeeListService;

    @Autowired
    AutoNumService autoNumService;

    @Autowired
    EmployeeWriteService employeeWriteService;

    @Autowired
    EmployeeDeleteService employeeDeleteService;

    @GetMapping("employeeList")
    public String employeeList(@RequestParam(value = "searchWord", required = false) String searchWord, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page, Model model){
        employeeListService.execute(searchWord, page, model);
        return "thymeleaf/employee/employeeList";
    }

    @GetMapping("employeeWrite")
    public String employeeWrite(Model model){
        String employeeNum = autoNumService.execute("emp_", "emp_num", 5, "employees");
        EmployeeCommand employeeCommand = new EmployeeCommand();
        employeeCommand.setEmpNum(employeeNum);
        model.addAttribute("employeeCommand", employeeCommand);
        return "thymeleaf/employee/employeeForm";
    }

    @PostMapping("employeeRegist")
    public String empRegist(@Validated EmployeeCommand employeeCommand, BindingResult result , Model model){
        if(result.hasErrors()){
            return "thymeleaf/employee/employeeForm";
        }
        employeeWriteService.execute(employeeCommand);
        return "redirect:employeeList";
    }

    @RequestMapping("employeesDelete")
    public String employeesDelete(@RequestParam("nums") String employeesNums[]){
        employeeDeleteService.execute(employeesNums);
        return "redirect:employeeList";
    }
}
