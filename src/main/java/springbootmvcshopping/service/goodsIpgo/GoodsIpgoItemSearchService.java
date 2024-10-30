package springbootmvcshopping.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.mapper.GoodsIpgoMapper;
import springbootmvcshopping.mapper.GoodsMapper;

import java.util.List;

@Service
public class GoodsIpgoItemSearchService {
    @Autowired
    GoodsMapper goodsMapper;

    public void execute(Model model){
        List<GoodsDTO> list = goodsMapper.goodsIpgoItems();
        model.addAttribute("list", list);
    }

}