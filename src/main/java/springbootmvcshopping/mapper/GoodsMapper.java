package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.GoodsDTO;

import java.util.List;

@Mapper
public interface GoodsMapper {
    public List<GoodsDTO> goodsSelectAll();
}
