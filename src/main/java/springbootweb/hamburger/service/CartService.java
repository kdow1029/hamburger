package springbootweb.hamburger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootweb.hamburger.dto.CartItemDto;
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

    public Long addCart(CartItemDto cartItemDto, String email){
        Order order = orderRepository.findById(cartItemDto.getOrderId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);

        Cart cart = cartRepository.findByMemberId(member.getId());
        if(cart == null){
            cart = Cart.createCart(member);
            cartRepository.save(cart);
        }

        CartItem savedCartItem = cartItemRepository.findByCartIdAndOrderId(cart.getId(), order.getId());

        if(savedCartItem != null){
            savedCartItem.addCount(cartItemDto.getCount());
            return savedCartItem.getId();
        }else {
            CartItem cartItem = CartItem.createItem(cart, order, cartItemDto.getCount());
            cartItemRepository.save(cartItem);
            return cartItem.getId();
        }




    }
}
