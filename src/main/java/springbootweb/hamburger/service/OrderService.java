package springbootweb.hamburger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springbootweb.hamburger.dto.OrderSaveDto;
import springbootweb.hamburger.entity.Order;
import springbootweb.hamburger.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Long save(OrderSaveDto orderSaveDto){
        return orderRepository.save(orderSaveDto.toEntity()).getId();

    }
    @Transactional(readOnly = true)
    public OrderSaveDto getOrderDtl(Long orderId){

        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        OrderSaveDto orderSaveDto = OrderSaveDto.of(order);
        return orderSaveDto;
    }


    public List<Order> getList() {
        return orderRepository.findAll();
    }
}
