package springbootweb.hamburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootweb.hamburger.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
