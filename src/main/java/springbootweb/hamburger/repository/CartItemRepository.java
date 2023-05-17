package springbootweb.hamburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootweb.hamburger.entity.Cart;
import springbootweb.hamburger.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndOrderId(Long cartId, Long orderId);
}
