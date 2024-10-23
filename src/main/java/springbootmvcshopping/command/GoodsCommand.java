package springbootmvcshopping.command;

import lombok.Data;

import java.util.Date;

@Data
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
