package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootmvcshopping.command.GoodsIpgoCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.service.AutoNumService;
import springbootmvcshopping.service.goodsIpgo.GoodsIpgoDetailService;
import springbootmvcshopping.service.goodsIpgo.GoodsIpgoListService;
import springbootmvcshopping.service.goodsIpgo.GoodsIpgoUpdateService;
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

    @Autowired
    GoodsIpgoDetailService goodsIpgoDetailService;

    @Autowired
    GoodsIpgoUpdateService goodsIpgoUpdateService;

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

    @GetMapping("goodsIpgoDetail/{goodsIpgoNum}")
    public String goodsIpgoDetail(@PathVariable("goodsIpgoNum") String goodsIpgoNum, Model model) {
        goodsIpgoDetailService.execute(goodsIpgoNum, model);
        return "thymeleaf/goodsIpgo/goodsIpgoDetail";
    }

    @GetMapping("ipgoUpdate/{goodsIpgoNum}")
    public String goodsIpgoUpdate(@PathVariable("goodsIpgoNum") String goodsIpgoNum, Model model) {
        goodsIpgoDetailService.execute(goodsIpgoNum, model);
        return "thymeleaf/goodsIpgo/goodsIpgoUpdate";
    }

    @PostMapping("goodsIpgoModify")
    public String goodsIpgoModify(GoodsIpgoCommand goodsIpgoCommand, HttpSession session) {
        goodsIpgoUpdateService.execute(goodsIpgoCommand, session);
        return "redirect:goodsIpgoList";
    }

}
