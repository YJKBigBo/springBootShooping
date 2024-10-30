package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.domain.StartEndPageDTO;

import java.util.List;

@Mapper
public interface GoodsMapper {
    public List<GoodsDTO> goodsSelectAll(StartEndPageDTO sepDTO);
    public void goodsInsert(GoodsDTO GoodsDTO);
    public GoodsDTO goodsSelectOne(String goodsNum);
    public int goodsUpdate(GoodsDTO GoodsDTO);
    public int goodsDelete(String[] goodsNum);
    public int goodsCount();
    public String goodsName(String goodsNum);
    public List<GoodsDTO> goodsSelectList(@Param("startRow") int startRow, @Param("endRow") int endRow);

    public int goodsCounts(String searchWord);

    public List<GoodsDTO> goodsIpgoItems();
}