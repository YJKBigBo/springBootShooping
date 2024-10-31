package springbootmvcshopping.service.item;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.WishDTO;
import springbootmvcshopping.mapper.GoodsStockMapper;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    GoodsStockMapper goodsStockMapper;

    public List<WishDTO> execute(Model model, HttpSession session) {
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String memberNum = auth.getUserNum();
        List<WishDTO> list = goodsStockMapper.goodsWishList(memberNum);
        return list;
    }
}
