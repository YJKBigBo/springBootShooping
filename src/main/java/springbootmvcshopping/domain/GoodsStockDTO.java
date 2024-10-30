package springbootmvcshopping.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("GoodsStockDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsStockDTO {
    Integer stock;
    GoodsDTO goodsDTO;
}
