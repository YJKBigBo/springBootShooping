package springbootmvcshopping.service.myPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.MemberCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.MemberDTO;
import springbootmvcshopping.mapper.MemberInfoMapper;

@Service
public class MemberMyUpdateService {
    @Autowired
    PasswordEncoder passwordEncoder;

    private final MemberInfoMapper memberInfoMapper;

    public MemberMyUpdateService(MemberInfoMapper memberInfoMapper) {
        this.memberInfoMapper = memberInfoMapper;
    }

    public void execute(MemberCommand memberCommand, HttpSession session){
        MemberDTO dto = new MemberDTO();
        dto.setMemberGender(memberCommand.getMemberGender());
        dto.setMemberAddr(memberCommand.getMemberAddr());
        dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
        dto.setMemberBirth(memberCommand.getMemberBirth());
        dto.setMemberEmail(memberCommand.getMemberEmail());
        dto.setMemberId(memberCommand.getMemberId());
        dto.setMemberName(memberCommand.getMemberName());
        dto.setMemberPhone1(memberCommand.getMemberPhone1());
        dto.setMemberPhone2(memberCommand.getMemberPhone2());
        dto.setMemberPost(Integer.parseInt(memberCommand.getMemberPost()));
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String currentPw = auth.getUserPw();
        if(passwordEncoder.matches(memberCommand.getMemberPw(), currentPw)){
           memberInfoMapper.memberUpdate(dto);
        }
    }
}
