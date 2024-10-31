package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springbootmvcshopping.domain.WishDTO;
import springbootmvcshopping.service.item.GoodsCartService;
import springbootmvcshopping.service.item.GoodsDetailViewService;
import springbootmvcshopping.service.item.GoodsWishService;
import springbootmvcshopping.service.item.WishListService;

import java.util.List;
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

    @Autowired
    WishListService wishListService;

    @GetMapping("detailView/{goodsNum}")
    public String goodsInfo(@PathVariable("goodsNum") String goodsNum, Model model)  {
        goodsDetailViewService.execute(goodsNum, model);
        return "thymeleaf/item/detailView";
    }

    @RequestMapping("wishItem")
    public @ResponseBody void wish(@RequestBody String goodsNum, HttpSession session) {
        goodsWishService.execute(goodsNum, session);
    }

    @GetMapping("wishList")
    public String wishList(){
        return "thymeleaf/item/wishList";
    }

    @RequestMapping("wish")
    public @ResponseBody List<WishDTO> wish(Model model, HttpSession session) {
        List<WishDTO> list = wishListService.execute(model, session);
        return list;
    }

    @RequestMapping("cart")
    public @ResponseBody void cart(@RequestBody Map<String, Object> map, HttpSession session) {
        String goodsNum = (String) map.get("goodsNum");
        String cartQty = (String) map.get("cartQty");
        goodsCartService.execute(goodsNum, cartQty, session);
    }

    @GetMapping("bucketList")
    public String bucketList(){
        return "thymeleaf/item/bucketList";
    }



}
