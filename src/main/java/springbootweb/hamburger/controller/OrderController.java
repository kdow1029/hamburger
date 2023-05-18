package springbootweb.hamburger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springbootweb.hamburger.dto.OrderSaveDto;
import springbootweb.hamburger.service.OrderService;


@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;





    @GetMapping("/menu")
    public String getMenu(Model model, OrderSaveDto order){
        model.addAttribute("order", order);
        return "menu/menu";
    }

//    @GetMapping("/menu/hamburger1")
//    public String hamburger1(){
//
//        return "menu/hamburger1";
//    }

    @GetMapping(value = "/menu/{orderId}")
    public String orderDtl(Model model, @PathVariable("orderId") Long orderId){
        OrderSaveDto orderSaveDto = orderService.getOrderDtl(orderId);
        model.addAttribute("order", orderSaveDto);
        System.out.println(orderId);
        return "menu/hamburger1";
    }
}
