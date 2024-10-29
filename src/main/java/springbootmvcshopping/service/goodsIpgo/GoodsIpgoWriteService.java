package springbootmvcshopping.service.goodsIpgo;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.command.GoodsIpgoCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.GoodsIpgoDTO;
import springbootmvcshopping.mapper.GoodsIpgoMapper;
import springbootmvcshopping.mapper.GoodsMapper;
import springbootmvcshopping.service.AutoNumService;

import java.sql.Timestamp;

@Service
public class GoodsIpgoWriteService {
    @Autowired
    GoodsIpgoMapper goodsIpgoMapper;

    public void execute(GoodsIpgoCommand goodsIpgoCommand, HttpSession session, String goodsIpgoNum){
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String empNum = auth.getUserNum();
        GoodsIpgoDTO dto = new GoodsIpgoDTO();
//        dto.setGoodsNum(goodsIpgoCommand.getGoodsNum());
//        dto.setIpgoQty(goodsIpgoCommand.getIpgoQty());
//        dto.setIpgoDate(goodsIpgoCommand.getIpgoDate());
//        dto.setMadeDate(Timestamp.valueOf(goodsIpgoCommand.getMadeDate()));
//        dto.setIpgoPrice(goodsIpgoCommand.getIpgoPrice());
//        dto.setEmpNum(empNum);
//        dto.setIpgoNum(goodsIpgoNum);

        BeanUtils.copyProperties(goodsIpgoCommand, dto); //command와 DTO의 필드명이 같으면 setter를 사용하지 않고 바로 데이터를 넣음
        dto.setEmpNum(empNum);
        dto.setMadeDate(Timestamp.valueOf(goodsIpgoCommand.getMadeDate()));
        dto.setIpgoNum(goodsIpgoNum);
        goodsIpgoMapper.goodsIpgoInsert(dto);
    }
}
