package springbootmvcshopping.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.Date;

@Alias("GoodsIpgoDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsIpgoDTO {
    String goodsNum;
    String ipgoNum;
    Integer ipgoQty;
    Date ipgoDate;
    Timestamp madeDate;
    Integer ipgoPrice;
    String empNum;
}
