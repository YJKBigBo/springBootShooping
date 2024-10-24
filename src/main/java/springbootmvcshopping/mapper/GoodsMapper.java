package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.domain.StartEndPageDTO;

import java.util.List;

@Mapper
public interface GoodsMapper {
    public List<GoodsDTO> goodsSelectAll(StartEndPageDTO sepDTO);
    public void goodsInsert(GoodsDTO GoodsDTO);
    public GoodsDTO goodsSelectOne(String goodsNum);
    public void goodsUpdate(GoodsDTO GoodsDTO);
    public int goodsDelete(String[] goodsNum);
    public int goodsCount();
    public String goodsName(String goodsNum);
}
