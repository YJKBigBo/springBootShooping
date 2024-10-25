package springbootmvcshopping.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.GoodsIpgoDTO;
import springbootmvcshopping.mapper.GoodsIpgoMapper;

import java.util.List;

@Service
public class GoodsIpgoListService {

    @Autowired
    GoodsIpgoMapper goodsIpgoMapper;

    public void execute(Model model){
        List<GoodsIpgoDTO> dto = goodsIpgoMapper.goodsIpgoSelectAll();
        model.addAttribute("goodsIpgoCommand", dto);
    }
}
