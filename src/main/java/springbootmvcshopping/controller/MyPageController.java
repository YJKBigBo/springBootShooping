package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootmvcshopping.command.MemberCommand;
import springbootmvcshopping.service.myPage.MemberMyInfoService;
import springbootmvcshopping.service.myPage.MemberMyUpdateService;

@Controller
@RequestMapping("myPage")
public class MyPageController {
    @Autowired
    MemberMyInfoService memberMyInfoService;

    @Autowired
    MemberMyUpdateService memberMyUpdateService;

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

}
