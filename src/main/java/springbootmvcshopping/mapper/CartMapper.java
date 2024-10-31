package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {

    public void goodsCart(@Param("goodsNum") String goodsNum, @Param("cartQty") String cartQty, @Param("memberNum") String memberNum);
}
