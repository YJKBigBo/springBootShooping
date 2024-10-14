package springbootmvcshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootmvcshopping.command.MemberCommand;
import springbootmvcshopping.service.AutoNumService;
import springbootmvcshopping.service.member.MemberWriteService;

@Controller
@RequestMapping("member")
//절대주소로 앞에 붙던 member을 굳이 사용하지 않아도 됨
public class MemberController {
    @Autowired
    MemberWriteService memberWriteService;

    @Autowired
    AutoNumService autoNumService;

    //@GetMapping("member/memberList") 앞에 붙던 절대주소 member를 사용하지 않아도 됨
    @GetMapping("memberList")
    public String list(){
        //return "member/memberList"; jsp 사용
        return "thymeleaf/member/memberList"; //html 사용
    }

    @GetMapping("memberWrite")
    public String write(Model model){
        autoNumService.execute(model, "mem_", "member_num", 4, "members");
        //return "member/memberform"; jsp 사용
        return "thymeleaf/member/memberForm";
    }

    @PostMapping("memberRegist")
    public String write(MemberCommand memberCommand, Model model){
        if(!memberCommand.isMemberPwEqualMemberPwCon()){
            model.addAttribute("errPw","비밀번호가 일치하지 않습니다.");
            return "thymeleaf/member/memberForm";
        }
        memberWriteService.execute(memberCommand);
        return "redirect:memberList";
    }
}
