package springbootmvcshopping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springbootmvcshopping.command.MemberCommand;
import springbootmvcshopping.service.AutoNumService;
import springbootmvcshopping.service.member.*;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
//절대주소로 앞에 붙던 member을 굳이 사용하지 않아도 됨
public class MemberController {
    private final MemberWriteService memberWriteService;
    @Autowired
    MemberListService memberListService;

    @Autowired
    AutoNumService autoNumService;

    @Autowired
    MemberDeleteService memberDeleteService;

    @Autowired
    MemberDetailService memberDetailService;

    @Autowired
    MemberUpdateService memberUpdateService;

    //@GetMapping("member/memberList") 앞에 붙던 절대주소 member를 사용하지 않아도 됨
    @GetMapping("memberList")
    public String list(Model model,@RequestParam(value = "searchWord", required = false) String searchWord,
                       @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        memberListService.execute(searchWord, page, model);
        //return "member/memberList"; jsp 사용
        return "thymeleaf/member/memberList"; //html 사용
    }

    @GetMapping("memberWrite")
    public String write(Model model){
        String autoNum = autoNumService.execute("mem_", "member_num", 5, "members");
        MemberCommand memberCommand = new MemberCommand();
        memberCommand.setMemberNum(autoNum);
        model.addAttribute("memberCommand", memberCommand);

        //return "member/memberform"; jsp 사용
        return "thymeleaf/member/memberForm";
    }

    @PostMapping("memberRegist")
    public String write(@Validated MemberCommand memberCommand, BindingResult result , Model model){
        if(result.hasErrors()){
            return "thymeleaf/member/memberForm";
        }

        if(!memberCommand.isMemberPwEqualMemberPwCon()){
            //model.addAttribute("errPw","비밀번호가 일치하지 않습니다."); 모델말고 command로 에러메세지를 날림, result를 사용해서
            result.rejectValue("memberPwCon","memberCommand.memberPwCon", "비밀번호가 일치하지 않습니다.");
            return "thymeleaf/member/memberForm";
        }
        memberWriteService.execute(memberCommand);
        return "redirect:memberList";
    }

    @RequestMapping("membersDelete")
    //public String membersDelete(String nums[])로 사용이 가능하다.
    public String membersDelete(@RequestParam("nums") String memberNums[]){
        memberDeleteService.execute(memberNums);
        return "redirect:memberList";
    }

    @GetMapping("memberDetail/{memberNum}")
    public String memberDetail(@PathVariable("memberNum") String memberNum, Model model){
        memberDetailService.execute(model, memberNum);
        return "thymeleaf/member/memberInfo";
    }

    @GetMapping("memberUpdate")
    public String memberUpdate(String memberNum,Model model) {
        memberDetailService.execute(model, memberNum);
        return "thymeleaf/member/memberModify";
    }

    @PostMapping("memberUpdate")
    public String memberUpdate(MemberCommand memberCommand) {
        memberUpdateService.execute(memberCommand);
        return "redirect:memberDetail/"+memberCommand.getMemberNum();
    }

    @GetMapping("memberDelete/{memberNum}")
    public String memberDelete(@PathVariable("memberNum") String memberNum) {
        memberDeleteService.execute(memberNum);
        return "redirect:../memberList";
    }
}
