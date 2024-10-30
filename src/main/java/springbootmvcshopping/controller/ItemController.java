package springbootmvcshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootmvcshopping.service.item.GoodsDetailViewService;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    GoodsDetailViewService goodsDetailViewService;

    @GetMapping("detailView/{goodsNum}")
    public String goodsInfo(@PathVariable("goodsNum") String goodsNum, Model model)  {
        goodsDetailViewService.execute(goodsNum, model);
        return "thymeleaf/corner/detailView";
    }


}
