package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootmvcshopping.service.myPage.MemberMyInfoService;

@Controller
@RequestMapping("myPage")
public class MyPageController {
    @Autowired
    MemberMyInfoService memberMyInfoService;

    @GetMapping("memberMypage")
    public String memMypage(HttpSession session, Model model) {
        memberMyInfoService.execute(session, model);
        return "thymeleaf/myPage/memberMypage";
    }

    @GetMapping("memberUpdate")
    public String memberUpdate() {
        return "";
    }
}
