package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springbootmvcshopping.domain.CartDTO;

import java.util.List;

@Mapper
public interface CartMapper {

    public void goodsCart(@Param("goodsNum") String goodsNum, @Param("cartQty") String cartQty, @Param("memberNum") String memberNum);
    public List<CartDTO> cartList(String memberNum);
}
