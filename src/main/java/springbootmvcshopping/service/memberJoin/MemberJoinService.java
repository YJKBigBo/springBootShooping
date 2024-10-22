package springbootmvcshopping.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.UserCommand;
import springbootmvcshopping.domain.MemberDTO;
import springbootmvcshopping.mapper.UserMapper;
import springbootmvcshopping.service.EmailSendService;

@Service
public class MemberJoinService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailSendService emailSendService;

    public void execute(UserCommand userCommand){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberGender(userCommand.getMemberGender());
        memberDTO.setMemberAddr(userCommand.getMemberAddr());
        memberDTO.setMemberAddrDetail(userCommand.getMemberAddrDetail());
        memberDTO.setMemberBirth(userCommand.getMemberBirth());
        memberDTO.setMemberEmail(userCommand.getMemberEmail());
        memberDTO.setMemberId(userCommand.getMemberId());
        memberDTO.setMemberName(userCommand.getMemberName());
        memberDTO.setMemberPhone1(userCommand.getMemberPhone1());
        memberDTO.setMemberPhone2(userCommand.getMemberPhone2());
        memberDTO.setMemberPost(userCommand.getMemberPost());
        memberDTO.setMemberPw(passwordEncoder.encode(userCommand.getMemberPw()));

        int i = userMapper.userInsert(memberDTO);
        System.out.println(i);
        //메일링 코드
        //1.try catch문으로 에러가 생기지 않았을때 메일링 실행
        //2.CUD는 정수를 반환받기 때문에 int를 반환받아 갯수가 0개 이상일때 만 실행되는 로직
        if(i>0){
            String content = "<html><body>";
                    content += memberDTO.getMemberEmail() + "님 가입을 환영합니다.";
                    content += "가입을 완료하시려면";
                    content += "<a href='http://localhost:8080/userConfirm?chk="+memberDTO.getMemberEmail()+"'>여기</a>를 클릭하세요.";
                    content += "</html></body>";
            String subject = "메일 테스트";
            String fromEmail = "highland0@nate.com";
            String toEmail = memberDTO.getMemberEmail();
            emailSendService.mailSend(fromEmail, toEmail, subject, content);
        }
    }
}
