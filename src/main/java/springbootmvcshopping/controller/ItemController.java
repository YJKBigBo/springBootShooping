package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootmvcshopping.service.item.GoodsDetailViewService;
import springbootmvcshopping.service.item.GoodsWishService;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    GoodsDetailViewService goodsDetailViewService;

    @Autowired
    GoodsWishService goodsWishService;

    @GetMapping("detailView/{goodsNum}")
    public String goodsInfo(@PathVariable("goodsNum") String goodsNum, Model model)  {
        goodsDetailViewService.execute(goodsNum, model);
        return "thymeleaf/item/detailView";
    }

    @RequestMapping("wishItem")
    public @ResponseBody void wish(String goodsNum, HttpSession session) {
        goodsWishService.execute(goodsNum, session);
    }


}
