package springbootmvcshopping.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.MemberCommand;
import springbootmvcshopping.domain.MemberDTO;
import springbootmvcshopping.mapper.MemberMapper;

@Service
public class MemberUpdateService {
    @Autowired
    MemberMapper memberMapper;
    public void execute(MemberCommand memberCommand) {
        MemberDTO dto = new MemberDTO();
        dto.setMemberGender(memberCommand.getMemberGender());
        dto.setMemberAddr(memberCommand.getMemberAddr());
        dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
        dto.setMemberBirth(memberCommand.getMemberBirth());
        dto.setMemberEmail(memberCommand.getMemberEmail());
        dto.setMemberId(memberCommand.getMemberId());
        dto.setMemberName(memberCommand.getMemberName());
        dto.setMemberNum(memberCommand.getMemberNum());
        dto.setMemberPhone1(memberCommand.getMemberPhone1());
        dto.setMemberPhone2(memberCommand.getMemberPhone2());
        dto.setMemberPost(Integer.parseInt(memberCommand.getMemberPost()));
        memberMapper.memberUpdate(dto);
    }
}