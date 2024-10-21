package springbootmvcshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootmvcshopping.command.UserCommand;
import springbootmvcshopping.service.memberJoin.MemberJoinService;

@Controller
@RequestMapping("register")
public class MemberJoinController {
    @Autowired
    MemberJoinService memberJoinService;

    @ModelAttribute
    public UserCommand userCommand() {
        return new UserCommand();
    }
    //Model model
    //model.addAttribute("userCommand", new UserCommand)와 같다
    //이렇게 모듈화하여 다른 메소드에서 userCommand를 줄 필요 없이 자동으로 매개변수에 채워짐
    
    @RequestMapping ("userAgree")
    public String userAgree(){
        return "thymeleaf/memberJoin/agree";
    }

    @GetMapping("userWrite")
    public String userWrite(){
        return "thymeleaf/memberJoin/userForm";
    }

    @PostMapping("userWrite")
    public String userWrite(@Validated UserCommand userCommand, BindingResult result){
        //command에서 error result를 가지고 있음
        if(result.hasErrors()){
            return "thymeleaf/memberJoin/userForm";
        }
        memberJoinService.execute(userCommand);
        return "thymeleaf/memberJoin/welcome";
    }
}
