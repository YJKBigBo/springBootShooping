package springbootmvcshopping.command;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class GoodsIpgoCommand {
    String goodsNum;
    String ipgoNum;
    Integer ipgoQty;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date ipgoDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) //pattern 사용해도 무관
    LocalDateTime madeDate;
    Integer ipgoPrice;
    String empNum;
}
