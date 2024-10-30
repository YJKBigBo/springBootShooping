package springbootmvcshopping.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("goodsIpgoGoodsName")
public class GoodsIpgoGoodsNameDTO {
    String goodsName;
    GoodsIpgoDTO goodsIpgoDTO;
}
