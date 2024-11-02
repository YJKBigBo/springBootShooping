package springbootmvcshopping.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("CartDTO")
public class CartDTO {
    String goodsNum;
    String memberNum;
    Date cartDate;
    Integer cartQty;
    GoodsDTO goodsDTO;
}
