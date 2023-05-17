package springbootweb.hamburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootweb.hamburger.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

  Cart findByMemberId(Long memberId);

}
