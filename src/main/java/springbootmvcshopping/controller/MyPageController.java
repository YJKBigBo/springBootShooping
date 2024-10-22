package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springbootmvcshopping.command.MemberCommand;
import springbootmvcshopping.service.myPage.MemberDropService;
import springbootmvcshopping.service.myPage.MemberMyInfoService;
import springbootmvcshopping.service.myPage.MemberMyUpdateService;
import springbootmvcshopping.service.myPage.MemberPwUpdateService;

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

}
