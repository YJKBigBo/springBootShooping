package springbootmvcshopping.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.GoodsIpgoDTO;
import springbootmvcshopping.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoDetailService {
    @Autowired
    GoodsIpgoMapper goodsIpgoMapper;

    public void execute(String goodsIpgoNum, Model model){
        GoodsIpgoDTO dto = goodsIpgoMapper.goodsIpgoSelectOne(goodsIpgoNum);
        model.addAttribute("goodsIpgoCommand", dto);
    }
}
