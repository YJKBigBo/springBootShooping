package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("goodsIpgo/{goodsIpgoNum}")
    public String goodsIpgo(@PathVariable("goodsIpgoNum") String goodsIpgoNum) {
        return "thymeleaf/goodsIpgo/goodsIpgo";
    }

    @PostMapping("ipgoRegist")
    public String ipgoRegist(GoodsIpgoCommand goodsIpgoCommand, @PathVariable("goodsNum") String goodsNum, HttpSession session) {
        String goodsIpgoNum = autoNumService.execute("goodsIpgo_", "IPGO_NUM", 11, "goods_ipgo");
        goodsIpgoWriteService.execute(goodsIpgoCommand, goodsNum, session, goodsIpgoNum);
        return "redirect:goodsIpgoList";
    }

}
