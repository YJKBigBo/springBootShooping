package springbootmvcshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springbootmvcshopping.service.employee.EmployeeListService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeListService employeeListService;

    @GetMapping("employeeList")
    public String employeeList(@RequestParam(value = "searchWord", required = false) String searchWord, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page, Model model){
        employeeListService.execute(searchWord, page, model);
        return "thymeleaf/employee/employeeList";
    }
}
