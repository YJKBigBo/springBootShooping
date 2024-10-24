package springbootmvcshopping.service.goodsIpgo;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.command.GoodsIpgoCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.GoodsIpgoDTO;
import springbootmvcshopping.mapper.GoodsIpgoMapper;
import springbootmvcshopping.mapper.GoodsMapper;
import springbootmvcshopping.service.AutoNumService;

@Service
public class GoodsIpgoWriteService {
    @Autowired
    GoodsIpgoMapper goodsIpgoMapper;

    public void execute(GoodsIpgoCommand goodsIpgoCommand, String goodsNum, HttpSession session, String goodsIpgoNum){
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String empNum = auth.getUserNum();
        GoodsIpgoDTO dto = new GoodsIpgoDTO();
        dto.setGoodsNum(goodsNum);
        dto.setIpgoQty(goodsIpgoCommand.getIpgoQty());
        dto.setIpgoDate(goodsIpgoCommand.getIpgoDate());
        dto.setMadeDate(goodsIpgoCommand.getMadeDate());
        dto.setIpgoPrice(goodsIpgoCommand.getIpgoPrice());
        dto.setEmpNum(empNum);
        dto.setIpgoNum(goodsIpgoNum);
        goodsIpgoMapper.goodsIpgoInsert(dto);
    }
}
