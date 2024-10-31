package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springbootmvcshopping.service.item.GoodsCartService;
import springbootmvcshopping.service.item.GoodsDetailViewService;
import springbootmvcshopping.service.item.GoodsWishService;

import java.util.Map;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    GoodsDetailViewService goodsDetailViewService;

    @Autowired
    GoodsWishService goodsWishService;

    @Autowired
    GoodsCartService goodsCartService;

    @GetMapping("detailView/{goodsNum}")
    public String goodsInfo(@PathVariable("goodsNum") String goodsNum, Model model)  {
        goodsDetailViewService.execute(goodsNum, model);
        return "thymeleaf/item/detailView";
    }

    @RequestMapping("wishItem")
    public @ResponseBody void wish(@RequestBody String goodsNum, HttpSession session) {
        goodsWishService.execute(goodsNum, session);
    }

    @RequestMapping("cart")
    public @ResponseBody void cart(@RequestBody Map<String, Object> map, HttpSession session) {
        String goodsNum = (String) map.get("goodsNum");
        String cartQty = (String) map.get("cartQty");
        goodsCartService.execute(goodsNum, cartQty, session);
    }



}
