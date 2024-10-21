package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String login(@Validated LoginCommand loginCommand, BindingResult bindingResult, HttpSession session) {
        userLoginService.execute(loginCommand, session, bindingResult);
        if(bindingResult.hasErrors()) {
            return "thymeleaf/index"; // html 파일을 열어 값을 가져옴
        }
        return "redirect:/"; //주소가 바뀜 값을 가져오지 못함
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
