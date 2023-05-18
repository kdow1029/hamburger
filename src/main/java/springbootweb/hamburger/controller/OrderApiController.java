package springbootweb.hamburger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springbootweb.hamburger.dto.OrderSaveDto;
import springbootweb.hamburger.entity.Order;
import springbootweb.hamburger.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class
OrderApiController {


    private final OrderService orderService;

    @GetMapping("/api/get")
    public List<Order> getAll(){
        return orderService.getList();
    }

    @PostMapping("/api/add")
    public Long save(@RequestBody OrderSaveDto reqDto){
        return orderService.save(reqDto);
    }
}
