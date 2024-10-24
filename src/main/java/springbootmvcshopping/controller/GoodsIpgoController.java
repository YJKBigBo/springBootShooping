package springbootmvcshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootmvcshopping.service.goodsIpgo.GoodsIpgoListService;

@Controller
@RequestMapping("goodsIpgo")
public class GoodsIpgoController {

    @Autowired
    GoodsIpgoListService goodsIpgoListService;

    @GetMapping("goodsIpgoList")
    public String goodsIpgo(Model model) {
        goodsIpgoListService.execute(model);
        return "thymeleaf/goodsIpgo/goodsIpgoList";
    }

}
