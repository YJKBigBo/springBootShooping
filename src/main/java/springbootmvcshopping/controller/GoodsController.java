package springbootmvcshopping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springbootmvcshopping.command.GoodsCommand;
import springbootmvcshopping.service.AutoNumService;
import springbootmvcshopping.service.goods.*;

@Controller
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    GoodsListService goodsListService;

    @Autowired
    AutoNumService autoNumService;

    @Autowired
    GoodsWriteService goodsWriteService;

    @Autowired
    GoodsDetailService goodsDetailService;

    @Autowired
    GoodsUpdateService goodsUpdateService;

    @Autowired
    GoodsDeleteService goodsDeleteService;

    @GetMapping("goodsList")
    public String goodsList(@RequestParam(value = "searchWord", required = false) String searchWord, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page, Model model) {
        goodsListService.execute(searchWord,page,model);
        return "thymeleaf/goods/goodsList";
    }

    @GetMapping("goodsForm")
    public String goodsForm() {
        return "thymeleaf/goods/goodsForm";
    }

    @PostMapping("goodsForm")
    public String goodsForm(GoodsCommand goodsCommand, HttpSession session, BindingResult result) {
        String goodsNum = autoNumService.execute("goods_", "goods_num", 7, "goods");
        if(result.hasErrors()){
            return "thymeleaf/goods/goodsForm";
        }
        goodsWriteService.execute(goodsCommand, goodsNum, session);
        return "thymeleaf/goods/goodsRedirect";
    }

    @GetMapping("goodsWrite")
    public String goodsWrite() {
        return "thymeleaf/goods/goodsWrite";
    }

    @GetMapping("goodsInfo/{goodsNum}")
    public String goodsInfo(@PathVariable("goodsNum") String goodsNum, Model model) {
        goodsDetailService.execute(goodsNum, model);
        return "thymeleaf/goods/goodsInfo";
    }

    @GetMapping("goodsUpdate/{goodsNum}")
    public String goodsUpdate(@PathVariable("goodsNum") String goodsNum, Model model) {
        goodsDetailService.execute(goodsNum, model);
        return "thymeleaf/goods/goodsUpdate";
    }

    @PostMapping("goodsUpdate")
    public String goodsUpdate(GoodsCommand goodsCommand, HttpSession session) {
        goodsUpdateService.execute(goodsCommand, session);
        return "redirect:goodsList";
    }

    @GetMapping("goodsDelete/{goodsNum}")
    public String goodsDelete(@PathVariable("goodsNum") String[] goodsNum){
        goodsDeleteService.execute(goodsNum);
        return "redirect:../goodsList";
    }

    @RequestMapping("goodsDelete")
    public String employeesDelete(@RequestParam("goodsNum") String goodsNum[]){
        goodsDeleteService.execute(goodsNum);
        return "redirect:../goodsList";
    }
}
