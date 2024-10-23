package springbootmvcshopping.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("GoodsDTO")
public class GoodsDTO {
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
