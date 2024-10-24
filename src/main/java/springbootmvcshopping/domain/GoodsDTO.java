package springbootmvcshopping.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("GoodsDTO")
public class GoodsDTO {
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
    Date goodsRegistDate;
    String updateEmpNum;
    Date goodsUpdateDate;
}