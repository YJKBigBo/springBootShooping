package springbootmvcshopping.command;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class GoodsIpgoCommand {
    String goodsNum;
    String ipgoNum;
    Integer ipgoQty;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date ipgoDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date madeDate;
    Integer ipgoPrice;
    String empNum;
}
