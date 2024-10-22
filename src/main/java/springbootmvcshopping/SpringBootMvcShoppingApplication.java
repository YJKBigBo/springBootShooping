package springbootmvcshopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootmvcshopping.command.LoginCommand;
import springbootmvcshopping.service.EmailSendService;

@Controller
@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class})
//pom.xml에 oracle과 jdbc가 있다면 무조건 DB연결을 properties에서 찾기 때문에
// 위 exclude를 추가하여 DB연결을 찾지 않고 시작 되도록 설정한다.
// DB를 일시적으로 사용하고 싶지 않을때 사용한다
public class SpringBootMvcShoppingApplication {

    @GetMapping("/")
    public String index(LoginCommand loginCommand) {
        return "thymeleaf/index";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcShoppingApplication.class, args);
    }





    @Autowired
    EmailSendService emailSendService;

    @GetMapping("mailling")
    public String mail() {
        return "thymeleaf/email";
    }

    @PostMapping("mailling")
    public String mail(String fromEmail, String toEmail, String subject, String content) {
        emailSendService.mailSend(fromEmail, toEmail, subject, content);
        return "redirect:/";
    }

}
