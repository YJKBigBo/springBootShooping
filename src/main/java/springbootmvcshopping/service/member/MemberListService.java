package springbootmvcshopping.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springbootmvcshopping.domain.MemberDTO;
import springbootmvcshopping.domain.StartEndPageDTO;
import springbootmvcshopping.mapper.MemberMapper;
import springbootmvcshopping.service.StartEndPageService;

@Service
public class MemberListService {
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    StartEndPageService startEndPageService;

    public void execute(String searchWord, Integer page, Model model) {
        // 한 페이지에 몇개를 보여줄 것인가
        Integer limit = 3;

        StartEndPageDTO sepDTO = startEndPageService.execute(page,limit,searchWord);

        Integer count = memberMapper.memberCount();

        List<MemberDTO> list = memberMapper.memberSelectList(sepDTO);

        startEndPageService.execute(page, limit, count, searchWord, list, model);
    }
}
