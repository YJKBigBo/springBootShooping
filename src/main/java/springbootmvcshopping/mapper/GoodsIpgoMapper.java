package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.GoodsIpgoDTO;

@Mapper
public interface GoodsIpgoMapper {
    public GoodsIpgoDTO goodsIpgoSelectAll();
    public void goodsIpgoInsert(GoodsIpgoDTO goodsIpgo);
}
