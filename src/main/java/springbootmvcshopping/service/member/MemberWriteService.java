package springbootmvcshopping.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.MemberCommand;
import springbootmvcshopping.domain.MemberDTO;
import springbootmvcshopping.mapper.MemberMapper;

@Service
public class MemberWriteService {
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void execute(MemberCommand memberCommand){
        MemberDTO dto = new MemberDTO();
        dto.setMemberGender(memberCommand.getMemberGender());
        dto.setMemberAddr(memberCommand.getMemberAddr());
        dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
        dto.setMemberBirth(memberCommand.getMemberBirth());
        dto.setMemberEmail(memberCommand.getMemberEmail());
        dto.setMemberId(memberCommand.getMemberId().trim());
        dto.setMemberName(memberCommand.getMemberName().trim());
        dto.setMemberNum(memberCommand.getMemberNum());
        dto.setMemberPhone1(memberCommand.getMemberPhone1().trim());
        if(memberCommand.getMemberPhone2() != null){
            dto.setMemberPhone2(memberCommand.getMemberPhone2().trim());
        }

        // 스프링 시큐리티를 이용한 간단한 암호화 과정
        String encodePw = passwordEncoder.encode(memberCommand.getMemberPw());
        dto.setMemberPw(encodePw);
        // 암호화 하여 암호문을 DB에 저장
        dto.setMemberPost(Integer.parseInt(memberCommand.getMemberPost()));
        memberMapper.memberInsert(dto);
    }
}