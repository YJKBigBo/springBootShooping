package springbootmvcshopping.command;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class GoodsCommand {
    String goodsNum;
    String goodsName;
    Integer goodsPrice;
    String goodsContents;
    Integer visitCount;
    String goodsMainImage;
    String goodsMainStoreImage;
    String goodsDetailImage;
    String goodsDetailStoreImage;
    String empNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date goodsRegistDate;

    String updateEmpNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date goodsUpdateDate;
}