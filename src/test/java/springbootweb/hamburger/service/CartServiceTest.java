package springbootweb.hamburger.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import springbootweb.hamburger.dto.CartItemDto;
import springbootweb.hamburger.entity.CartItem;
import springbootweb.hamburger.entity.Member;
import springbootweb.hamburger.entity.Order;
import springbootweb.hamburger.repository.CartItemRepository;
import springbootweb.hamburger.repository.MemberRepository;
import springbootweb.hamburger.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional
class CartServiceTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CartService cartService;

    @Autowired
    CartItemRepository cartItemRepository;

    public Order saveOrder(){
        Order item = new Order();
        item.setMenu("테스트 상품");
        item.setPrice(10000);
        item.setContent("테스트 상품 상세 설명");
        return orderRepository.save(item);
    }

    public Member saveMember(){
        Member member = new Member();
        member.setEmail("test@test.com");
        return memberRepository.save(member);
    }

    @Test
    @DisplayName("장바구니 담기 테스트")
    public void addCart(){
        Order item = saveOrder();
        Member member = saveMember();

        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setCount(5);
        cartItemDto.setOrderId(item.getId());

        Long cartItemId = cartService.addCart(cartItemDto, member.getEmail());

        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(EntityNotFoundException::new);

        assertEquals(item.getId(), cartItem.getOrder().getId());
        assertEquals(cartItemDto.getCount(), cartItem.getCount());
    }

}