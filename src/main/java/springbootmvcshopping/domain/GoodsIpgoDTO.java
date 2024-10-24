package springbootmvcshopping.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("GoodsIpgoDTO")
@Data
public class GoodsIpgoDTO {
    String goodsNum;
    String ipgoNum;
    Integer ipgoQty;
    Date ipgoDate;
    Date madeDate;
    Integer ipgoPrice;
    String empNum;
}
