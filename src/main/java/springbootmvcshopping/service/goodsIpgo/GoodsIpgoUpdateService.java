package springbootmvcshopping.service.goodsIpgo;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootmvcshopping.command.GoodsIpgoCommand;
import springbootmvcshopping.domain.GoodsIpgoDTO;
import springbootmvcshopping.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoUpdateService {
    @Autowired
    GoodsIpgoMapper goodsIpgoMapper;
    public void execute(GoodsIpgoCommand goodsIpgoCommand) {
        GoodsIpgoDTO dto = new GoodsIpgoDTO();
		/*
		dto.setGoodsNum(goodsIpgoCommand.getGoodsNum());
		dto.setIpgoDate(goodsIpgoCommand.getIpgoDate());
		dto.setGoodsIpgoNum(goodsIpgoCommand.getGoodsIpgoNum());
		dto.setIpgoPrice(goodsIpgoCommand.getIpgoPrice());
		dto.setIpgoQty(goodsIpgoCommand.getIpgoQty());
		*/
        BeanUtils.copyProperties(goodsIpgoCommand, dto);
        dto.setMadeDate(Timestamp.valueOf(goodsIpgoCommand.getMadeDate()));
        goodsIpgoMapper.goodsIpgoUpdate(dto);
    }
}
