package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springbootmvcshopping.command.EmployeeCommand;
import springbootmvcshopping.command.MemberCommand;
import springbootmvcshopping.service.employee.EmployeeUpdateService;
import springbootmvcshopping.service.myPage.*;

import java.util.Map;

@Controller
@RequestMapping("myPage")
public class MyPageController {
    @Autowired
    MemberMyInfoService memberMyInfoService;

    @Autowired
    MemberMyUpdateService memberMyUpdateService;

    @Autowired
    MemberPwUpdateService memberPwUpdateService;

    @Autowired
    MemberDropService memberDropService;

    @Autowired
    EmployeeMyInfoService employeeMyInfoService;

    @Autowired
    EmployeeInfoService employeeInfoService;

    @Autowired
    EmployeeModifyService employeeModifyService;

    @GetMapping("memberMypage")
    public String memMypage(HttpSession session, Model model) {
        memberMyInfoService.execute(session, model);
        return "thymeleaf/myPage/memberMypage";
    }

    @GetMapping("memberUpdate")
    public String memberUpdate(HttpSession session, Model model) {
        memberMyInfoService.execute(session, model);
        return "thymeleaf/myPage/myModify";
    }

    @PostMapping("memberModify")
    public String memberModify(MemberCommand memberCommand, HttpSession session) {
        memberMyUpdateService.execute(memberCommand, session);
        return "redirect:memberMypage";
    }

    @RequestMapping(value="memberPwModify", method = RequestMethod.GET)
    public String memberPwModify() {
        return "thymeleaf/myPage/myNewPw";
    }

    @RequestMapping(value="memberPwPro", method = RequestMethod.POST)
    public String newPw(String oldPw, String newPw, HttpSession session) {
        memberPwUpdateService.execute(oldPw, newPw, session);
        return "thymeleaf/myPage/myNewPw";
    }

    @GetMapping("memberDrop")
    public String memberDrop(){
        return "thymeleaf/myPage/memberDrop";
    }

    @PostMapping("memberDropOk")
    public String memberDropOk(String memberPw, HttpSession session){
        memberDropService.execute(memberPw, session);
        return "redirect:/";
    }

    @GetMapping("empModify")
    public @ResponseBody Map<String, Object> empPage(HttpSession session, Model model) {
        Map<String, Object> map = employeeInfoService.execute(session, model);
        return map;
    }

    @PostMapping("empModify")
    public String empModify(EmployeeCommand employeeCommand, HttpSession session) {
        employeeModifyService.execute(employeeCommand, session);
        return "redirect:employeeMyPage";
    }

    @GetMapping("employeeMyPage")
    public String empMyPage() {
        return "thymeleaf/myPage/employeeInfo";
    }

    @PostMapping("empMyPage")
    public ModelAndView empMyPage(HttpSession session, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("jsonView");
        employeeInfoService.execute(session, model);
        return mav;
    }

    @Autowired
    EmployeePwUpdateService employeePwUpdateService;

    @PostMapping("empPwPro")
    public String empPwPro(@RequestParam("oldPw") String oldPw, String newPw, HttpSession session) {
        employeePwUpdateService.execute(oldPw, newPw, session);
        return "redirect:employeeMyPage";
    }

}
