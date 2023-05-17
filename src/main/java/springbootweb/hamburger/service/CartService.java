package springbootweb.hamburger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootweb.hamburger.dto.CartDto;
import springbootweb.hamburger.entity.Cart;
import springbootweb.hamburger.entity.CartItem;
import springbootweb.hamburger.entity.Member;
import springbootweb.hamburger.entity.Order;
import springbootweb.hamburger.repository.CartItemRepository;
import springbootweb.hamburger.repository.CartRepository;
import springbootweb.hamburger.repository.MemberRepository;
import springbootweb.hamburger.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    public Long addCart(CartDto cartDto, String email){
        Order order = orderRepository.findById(cartDto.getOrderId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);

        Cart cart = cartRepository.findByMemberId(member.getId());
        if(cart == null){
            cart = Cart.createCart(member);
            cartRepository.save(cart);
        }

        CartItem saveCartItem = cartItemRepository.findByCartIdAndOrderId(cart.getId(), order.getId());

        if(saveCartItem != null){
            saveCartItem.addCount(cartDto.getCount());
            return saveCartItem.getId();
        }else {
            CartItem cartItem = CartItem.createItem(cart, order, cartDto.getCount());
            cartItemRepository.save(cartItem);
            return cartItem.getId();
        }




    }
}
