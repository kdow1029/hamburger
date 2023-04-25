package springbootweb.hamburger.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootweb.hamburger.domain.OrderRepository;

@RequiredArgsConstructor
@Service
public class OrderService {

    private OrderRepository orderRepository;
}
