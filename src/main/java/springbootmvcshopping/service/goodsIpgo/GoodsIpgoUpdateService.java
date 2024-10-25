package springbootmvcshopping.service.goodsIpgo;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.command.GoodsIpgoCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.GoodsIpgoDTO;
import springbootmvcshopping.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoUpdateService {
    @Autowired
    GoodsIpgoMapper goodsIpgoMapper;

    public void execute(GoodsIpgoCommand goodsIpgoCommand, HttpSession session){
        AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
        String empNum = auth.getUserNum();

        GoodsIpgoDTO dto = new GoodsIpgoDTO();
        dto.setIpgoNum(goodsIpgoCommand.getIpgoNum());
        System.out.println(goodsIpgoCommand.getIpgoNum());
        dto.setIpgoPrice(goodsIpgoCommand.getIpgoPrice());
        dto.setIpgoQty(goodsIpgoCommand.getIpgoQty());
        dto.setIpgoDate(goodsIpgoCommand.getIpgoDate());
        dto.setMadeDate(goodsIpgoCommand.getMadeDate());
        dto.setEmpNum(empNum);
        dto.setGoodsNum(goodsIpgoCommand.getGoodsNum());

        goodsIpgoMapper.goodsIpgoUpdate(dto);
    }
}
