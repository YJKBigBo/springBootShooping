package springbootmvcshopping.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.UserCommand;
import springbootmvcshopping.domain.MemberDTO;
import springbootmvcshopping.mapper.UserMapper;

@Service
public class MemberJoinService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

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

        userMapper.userInsert(memberDTO);
    }
}
