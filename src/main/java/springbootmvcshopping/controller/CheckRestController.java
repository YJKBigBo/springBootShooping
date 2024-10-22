package springbootmvcshopping.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootmvcshopping.mapper.LoginMapper;
import springbootmvcshopping.sevice.EmailCheckService;
// spring boot html을 사용하지 않고 데이터나 오브젝트만 전달하기 위해 사용되는것
// spring 에서는 responseBody
@RestController

public class CheckRestController {
    @Autowired
    EmailCheckService emailCheckService;
    @Autowired
    private LoginMapper loginMapper;

    @PostMapping("/checkRest/userEmailCheck")
    public Integer emailCheck(String userEmail) {
        return emailCheckService.execute(userEmail);
    }

    @GetMapping("userConfirm")
    public String userConfirm(String chk) {
        Integer i = emailCheckService.update(chk);
        if(i == null){
            return "이메일이 존재하지 않습니다.";
        } else{
            if(i == 1){
                return "인증되었습니다.";
            } else {
                return "이미 인증이 되어있습니다.";
            }
        }
    }
}