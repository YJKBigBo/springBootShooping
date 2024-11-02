package springbootmvcshopping.service.item;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.CartDTO;
import springbootmvcshopping.mapper.CartMapper;

import java.util.List;

@Service
public class BucketListService {

    @Autowired
    CartMapper cartMapper;

    public List<CartDTO> execute(HttpSession session){
        AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
        String memberNum = auth.getUserNum();
        List<CartDTO> list = cartMapper.cartList(memberNum);
        return list;
    }

}
