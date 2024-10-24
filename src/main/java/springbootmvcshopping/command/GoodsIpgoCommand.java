package springbootmvcshopping.command;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsIpgoCommand {
    String goodsNum;
    String ipgoNum;
    Integer ipgoQty;
    Date ipgoDate;
    Date madeDate;
    Integer ipgoPrice;
    String empNum;
}
