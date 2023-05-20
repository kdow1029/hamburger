package springbootweb.hamburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootweb.hamburger.dto.CartListDto;
import springbootweb.hamburger.entity.Cart;
import springbootweb.hamburger.entity.CartItem;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndOrderId(Long cartId, Long orderId);

    @Query("select new springbootweb.hamburger.dto.CartListDto(ci.id, o.menu, o.price, ci.count) " +
            "from CartItem ci " +
            "join ci.order o " +
            "where ci.cart.id = :cartId "
    )
    List<CartListDto> findCartListDto(@Param("cartId") Long cartId);

}
