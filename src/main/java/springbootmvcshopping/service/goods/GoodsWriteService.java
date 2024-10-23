package springbootmvcshopping.service.goods;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.GoodsCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.mapper.AutoNumMapper;
import springbootmvcshopping.mapper.GoodsMapper;

@Service
public class GoodsWriteService {
    @Autowired
    GoodsMapper goodsMapper;

    public void execute(GoodsCommand goodsCommand, String goodsNum, HttpSession session) {
        GoodsDTO dto = new GoodsDTO();
        dto.setGoodsName(goodsCommand.getGoodsName());
        dto.setGoodsPrice(goodsCommand.getGoodsPrice());
        dto.setGoodsContents(goodsCommand.getGoodsContents());
        dto.setGoodsNum(goodsNum);
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        dto.setEmpNum(auth.getUserNum());
        goodsMapper.goodsInsert(dto);
    }
}
