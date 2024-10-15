package springbootmvcshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springbootmvcshopping.service.IdcheckService;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    IdcheckService idcheckService;

    @PostMapping("userIdCheck")
    public @ResponseBody Integer uesrIdCheck(String userId) {
        return idcheckService.execute(userId);
    }
}
