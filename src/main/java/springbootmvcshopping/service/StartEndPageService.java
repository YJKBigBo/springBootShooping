package springbootmvcshopping.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.StartEndPageDTO;

import java.util.List;

@Service
public class StartEndPageService {

    public StartEndPageDTO execute(int page, int limit, String searchWord){
        int startRow = 1 + (page-1)*limit ;
        int endRow = page*limit;
        StartEndPageDTO sepDTO = new StartEndPageDTO(startRow, endRow, searchWord);

        return sepDTO;
    }

    public void execute(int page, int limit, int count, String searchWord, List list, Model model){
        // 페이지 목록 1  --- 현재페이지 --- 10 11페이지 전까지는 1~10
        int limitPage = 10;
        int startPageNum = (int)((double)page / limitPage - 0.05) * limitPage +1;
        int endPageNum = startPageNum + limitPage -1;
        int maxPage = (int)((double)count/ limit +0.95);
        if(endPageNum == 0) endPageNum = 1;
        if(endPageNum > maxPage) {
            endPageNum = maxPage;
        }
        if(searchWord == null) {
            searchWord = "";
        }
        model.addAttribute("list", list);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("page", page);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("count", count);
    }
}
