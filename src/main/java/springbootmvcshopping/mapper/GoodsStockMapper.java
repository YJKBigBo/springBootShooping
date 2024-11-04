package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springbootmvcshopping.domain.GoodsStockDTO;
import springbootmvcshopping.domain.WishDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsStockMapper {
    public GoodsStockDTO goodsStockSelectOne(String goodsNum);
    public int goodsVisitCountUpdate(String goodsNum);
    public void goodsMapWish(Map<String, String> map);

    public List<WishDTO> goodsWishList(String goodsNum);
}
