package springbootmvcshopping.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.MemberDTO;
import springbootmvcshopping.mapper.MemberMapper;

import java.util.List;

@Service
public class MemberListService {
    @Autowired
    MemberMapper memberMapper;

    public void execute(Model model, String searchWord){
        List<MemberDTO> list = memberMapper.memberSelectList(searchWord);
        model.addAttribute("list", list);
        model.addAttribute("searchWord", searchWord);
    }
}
