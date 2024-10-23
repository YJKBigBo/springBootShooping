package springbootmvcshopping.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.mapper.GoodsMapper;

import java.util.List;

@Service
public class GoodsListService {
    @Autowired
    GoodsMapper goodsMapper;

    public void execute(Model model){
        List<GoodsDTO> dto = goodsMapper.goodsSelectAll();
        model.addAttribute("goodsCommand", dto);
    }
}
