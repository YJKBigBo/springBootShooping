package springbootmvcshopping.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.domain.StartEndPageDTO;
import springbootmvcshopping.mapper.GoodsMapper;
import springbootmvcshopping.service.StartEndPageService;

import java.util.List;

@Service
public class GoodsListService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    StartEndPageService startEndPageService;

    public void execute(String searchWord, Integer page, Model model){

        Integer limit = 3;

        StartEndPageDTO sepDTO = startEndPageService.execute(page,limit,searchWord);

        Integer count = goodsMapper.goodsCount();

        List<GoodsDTO> list = goodsMapper.goodsSelectAll(sepDTO);

        startEndPageService.execute(page, limit, count, searchWord, list, model);
    }
}
