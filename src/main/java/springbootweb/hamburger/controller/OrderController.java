package springbootweb.hamburger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springbootweb.hamburger.service.OrderService;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping("/menu")
    public String getMenu(){

        return "menu/menu";
    }

    @GetMapping("/menu/hamburger1")
    public String hamburger1(){

        return "menu/hamburger1";
    }


}
