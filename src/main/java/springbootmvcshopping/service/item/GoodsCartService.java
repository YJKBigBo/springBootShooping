package springbootmvcshopping.service.item;

import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.mapper.CartMapper;
import springbootmvcshopping.mapper.GoodsStockMapper;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsCartService {
    @Autowired
    CartMapper cartMapper;

    public void execute(String goodsNum, String cartQty, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String memberNum = auth.getUserNum();
        cartMapper.goodsCart(goodsNum, cartQty, memberNum);
    }



}
