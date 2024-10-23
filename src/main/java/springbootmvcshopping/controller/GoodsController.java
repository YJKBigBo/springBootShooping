package springbootmvcshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootmvcshopping.service.goods.GoodsListService;

@Controller
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    GoodsListService goodsListService;

    @GetMapping("goodsList")
    public String goodsList(Model model) {
        goodsListService.execute(model);
        return "thymeleaf/goods/goodsList";
    }

    @GetMapping("goodsWrite")
    public String goodsWrite() {
        return "thymeleaf/goods/goodsWrite";
    }
}
