package springbootmvcshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
//절대주소로 앞에 붙던 member을 굳이 사용하지 않아도 됨
public class MemberController {


    //@GetMapping("member/memberList") 앞에 붙던 절대주소 member를 사용하지 않아도 됨
    @GetMapping("memberList")
    public String list(){
        //return "member/memberList"; jsp 사용
        return "thymeleaf/member/memberList"; //html 사용
    }

    @GetMapping("memberWrite")
    public String write(){
        //return "member/memberform"; jsp 사용
        return "thymeleaf/member/memberForm";
    }

    @PostMapping("memberRegist")
    public String regist(){
        return "redirect:memberList";
    }
}
