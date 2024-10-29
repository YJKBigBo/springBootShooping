package springbootmvcshopping.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.mapper.GoodsMapper;

import java.util.List;

@Service
public class MainGoodsListService {
    @Autowired
    GoodsMapper goodsMapper;

    public void execute(Integer page, Model model) {
        int limit = 6;
        int startRow = ((page - 1) * limit) +1 ;
        int endRow = startRow + limit - 1 ;

        List<GoodsDTO> list = goodsMapper.goodsSelectList(startRow, endRow);
        int count = goodsMapper.goodsCount();
        int maxPage = (int)((double)count/limit + 0.95);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("list", list);
    }
}
