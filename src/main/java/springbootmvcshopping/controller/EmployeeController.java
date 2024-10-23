package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springbootmvcshopping.command.EmployeeCommand;
import springbootmvcshopping.service.AutoNumService;
import springbootmvcshopping.service.employee.*;

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

    @Autowired
    EmployeeDetailService employeeDetailService;

    @Autowired
    EmployeeUpdateService employeeUpdateService;

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

    @GetMapping("empDetail/{empNum}")
    public String employeeDetail(@PathVariable("empNum") String empNum, Model model, HttpSession session){
        employeeDetailService.execute(empNum, model, session);
        return "thymeleaf/employee/employeeDetail";
    }

    @GetMapping("employeeUpdate")
    public String employeeUpdate(String empNum, Model model){
        employeeDetailService.execute(empNum, model);
        return "thymeleaf/employee/employeeModify";
    }

    @PostMapping("employeeUpdate")
    public String employeeUpdate(EmployeeCommand employeeCommand){
        employeeUpdateService.execute(employeeCommand);
        return "redirect:employeeList";
    }

    @GetMapping("employeeDelete/{empNum}")
    public String employeeDelete(@PathVariable("empNum") String[] empNum){
        employeeDeleteService.execute(empNum);
        return "redirect:../employeeList";
    }

}
