package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springbootmvcshopping.command.LoginCommand;
import springbootmvcshopping.service.IdcheckService;
import springbootmvcshopping.service.login.UserLoginService;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    IdcheckService idcheckService;
    @Autowired
    UserLoginService userLoginService;

    @PostMapping("userIdCheck")
    public @ResponseBody Integer uesrIdCheck(String userId) {
        return idcheckService.execute(userId);
    }

    @PostMapping("login")
    public String login(LoginCommand loginCommand, HttpSession session) {
        userLoginService.execute(loginCommand, session);
        return "redirect:/";
    }
}
