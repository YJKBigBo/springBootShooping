package springbootmvcshopping.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCommand {
    String goodsNum;
    String goodsName;
    int goodsPrice;
    String goodsContents;
    int visitCount;
    String goodsMainImage;
    String goodsMainStoreImage;
    String goodsDetailImage;
    String goodsDetailStoreImage;
    String empNum;
    Date goodsRegistDate;
    String updateEmpNum;
    Date goodsUpdateDate;
}
