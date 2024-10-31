package springbootmvcshopping.service.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.GoodsStockDTO;
import springbootmvcshopping.mapper.GoodsStockMapper;

@Service
public class GoodsDetailViewService {
    @Autowired
    GoodsStockMapper goodsStockMapper;

    public void execute(String goodsNum, Model model) {
        goodsStockMapper.goodsVisitCountUpdate(goodsNum);
        GoodsStockDTO dto = goodsStockMapper.goodsStockSelectOne(goodsNum);
        model.addAttribute("dto", dto);

    }

}
