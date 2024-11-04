package springbootmvcshopping.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("WishDTO")
@Data
public class WishDTO {
    String memberNum;
    String goodsNum;
    Date wishDate;
    GoodsDTO goodsDTO;
}
