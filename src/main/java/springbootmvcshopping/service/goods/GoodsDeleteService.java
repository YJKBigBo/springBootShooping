package springbootmvcshopping.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.mapper.GoodsMapper;

@Service
public class GoodsDeleteService {
    @Autowired
    GoodsMapper goodsMapper;

    public void execute(String goodsNum){
        goodsMapper.goodsDelete(goodsNum);
    }
}
