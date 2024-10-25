package springbootmvcshopping.service.goods;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.GoodsCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.mapper.GoodsMapper;

@Service
public class GoodsUpdateService {
    @Autowired
    GoodsMapper goodsMapper;

    public void execute(GoodsCommand goodsCommand, HttpSession session){
        GoodsDTO dto = new GoodsDTO();
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String empNum = auth.getUserNum();
        dto.setGoodsNum(goodsCommand.getGoodsNum());
        dto.setGoodsContents(goodsCommand.getGoodsContents());
        dto.setGoodsName(goodsCommand.getGoodsName());
        dto.setGoodsPrice(goodsCommand.getGoodsPrice());
        dto.setVisitCount(goodsCommand.getVisitCount());
        dto.setEmpNum(goodsCommand.getEmpNum());
        dto.setUpdateEmpNum(empNum);
        System.out.println("empNum 값: " + dto.getUpdateEmpNum());



        goodsMapper.goodsUpdate(dto);

    }
}
