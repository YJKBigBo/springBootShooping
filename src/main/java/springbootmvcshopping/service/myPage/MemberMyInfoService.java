package springbootmvcshopping.service.myPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.MemberDTO;
import springbootmvcshopping.mapper.MemberInfoMapper;

@Service
public class MemberMyInfoService {
    @Autowired
    MemberInfoMapper memberInfoMapper;

    public void execute(HttpSession session, Model model) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String memberId = auth.getUserId();
        MemberDTO memberDTO = memberInfoMapper.memberSelectOne(memberId);
        model.addAttribute("memberCommand", memberDTO);
    }
}
