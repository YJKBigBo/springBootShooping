package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootmvcshopping.command.GoodsCommand;
import springbootmvcshopping.service.AutoNumService;
import springbootmvcshopping.service.goods.GoodsListService;
import springbootmvcshopping.service.goods.GoodsWriteService;

@Controller
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    GoodsListService goodsListService;

    @Autowired
    AutoNumService autoNumService;
    
    @Autowired
    GoodsWriteService goodsWriteService;

    @GetMapping("goodsList")
    public String goodsList(Model model) {
        goodsListService.execute(model);
        return "thymeleaf/goods/goodsList";
    }

    @GetMapping("goodsWrite")
    public String goodsWrite() {
        return "thymeleaf/goods/goodsWrite";
    }

    @PostMapping("goodsRegist")
    public String goodsWrite(GoodsCommand goodsCommand, HttpSession session) {
        String goodsNum = autoNumService.execute("goods_", "goods_num", 7, "goods");
        goodsWriteService.execute(goodsCommand, goodsNum, session);
        return "redirect:goodsList";
    }
}
