package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springbootmvcshopping.domain.GoodsStockDTO;

import java.util.Map;

@Mapper
public interface GoodsStockMapper {
    public GoodsStockDTO goodsStockSelectOne(String goodsNum);
    public int goodsVisitCountUpdate(String goodsNum);
    public int goodsWish(@Param("goodsNum") String goodsNum, @Param("memberNum") String memberNum);
    public void goodsMapWish(Map<String, String> map);
}
