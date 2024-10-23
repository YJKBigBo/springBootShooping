package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.GoodsDTO;

import java.util.List;

@Mapper
public interface GoodsMapper {
    public List<GoodsDTO> goodsSelectAll();
    public void goodsInsert(GoodsDTO GoodsDTO);
    public GoodsDTO goodsSelectOne(String goodsNum);
    public void goodsUpdate(GoodsDTO GoodsDTO);
}
