package springbootmvcshopping.service.item;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.mapper.GoodsStockMapper;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsWishService {
    @Autowired
    GoodsStockMapper goodsStockMapper ;

    public void execute(String goodsNum, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String memberNum = auth.getUserNum();

        Map<String, String> map = new HashMap<String, String>();
        map.put("goodsNum", goodsNum);
        map.put("memberNum", memberNum);

        goodsStockMapper.goodsWish(goodsNum, memberNum);
        goodsStockMapper.goodsMapWish(map);
    }

}
