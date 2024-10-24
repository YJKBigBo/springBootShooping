package springbootmvcshopping.command;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class GoodsCommand {
    String goodsNum;
    String goodsName;
    Integer goodsPrice;
    String goodsContents;
    Integer visitCount;
    String empNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date goodsRegistDate;

    String updateEmpNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date goodsUpdateDate;

    MultipartFile goodsMainImage;
    String goodsMainStoreImage;
    MultipartFile[] goodsDetailImage;
    String goodsDetailStoreImage;
}