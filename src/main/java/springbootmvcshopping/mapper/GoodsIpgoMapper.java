package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.GoodsIpgoDTO;

import java.util.List;

@Mapper
public interface GoodsIpgoMapper {
    public List<GoodsIpgoDTO> goodsIpgoSelectAll();
    public void goodsIpgoInsert(GoodsIpgoDTO goodsIpgoDTO);
    public GoodsIpgoDTO goodsIpgoSelectOne(String goodsIpgoNum);
    public void goodsIpgoUpdate(GoodsIpgoDTO goodsIpgoDTO);
}
