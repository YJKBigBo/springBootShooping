package springbootmvcshopping.service.item;

import com.fasterxml.jackson.databind.ObjectMapper;
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

        if (goodsNum.startsWith("{") && goodsNum.contains("goodsNum")) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, String> goodsMap = mapper.readValue(goodsNum, Map.class);
                goodsNum = goodsMap.get("goodsNum");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Map<String, String> map = new HashMap<>();
        map.put("goodsNum", goodsNum);
        map.put("memberNum", memberNum);

        goodsStockMapper.goodsMapWish(map);
    }

}

