package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootmvcshopping.command.GoodsIpgoCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.service.AutoNumService;
import springbootmvcshopping.service.goodsIpgo.GoodsIpgoListService;
import springbootmvcshopping.service.goodsIpgo.GoodsIpgoWriteService;

@Controller
@RequestMapping("goodsIpgo")
public class GoodsIpgoController {

    @Autowired
    GoodsIpgoListService goodsIpgoListService;

    @Autowired
    GoodsIpgoWriteService goodsIpgoWriteService;

    @Autowired
    AutoNumService autoNumService;

    @GetMapping("goodsIpgoList")
    public String goodsIpgoList(Model model) {
        goodsIpgoListService.execute(model);
        return "thymeleaf/goodsIpgo/goodsIpgoList";
    }

    @GetMapping("goodsIpgo/{goodsNum}")
    public String goodsIpgo(@PathVariable("goodsNum") String goodsNum, Model model) {
        model.addAttribute("goodsNum", goodsNum);
        return "thymeleaf/goodsIpgo/goodsIpgo";
    }

    @PostMapping("ipgoRegist")
    public String ipgoRegist(GoodsIpgoCommand goodsIpgoCommand, HttpSession session) {
        String goodsIpgoNum = autoNumService.execute("goodsIpgo_", "IPGO_NUM", 11, "goods_ipgo");
        goodsIpgoWriteService.execute(goodsIpgoCommand,  session, goodsIpgoNum);
        return "redirect:goodsIpgoList";
    }

}
