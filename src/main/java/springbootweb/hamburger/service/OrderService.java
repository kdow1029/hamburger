package springbootweb.hamburger.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springbootweb.hamburger.domain.Order;
import springbootweb.hamburger.domain.OrderRepository;
import springbootweb.hamburger.dto.OrderSaveReqDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Order save(OrderSaveReqDto reqDto){
        return orderRepository.save(reqDto.toEntity());
    }

    public List<Order> getList(){
        return orderRepository.findAll();
    }
}
