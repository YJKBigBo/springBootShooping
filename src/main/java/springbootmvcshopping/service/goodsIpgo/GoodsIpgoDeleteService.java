package springbootmvcshopping.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoDeleteService {
    @Autowired
    GoodsIpgoMapper goodsIpgoMapper;

    public void execute(String goodsIpgoNum){
        goodsIpgoMapper.goodsIpgoDelete(goodsIpgoNum);
    }
}
