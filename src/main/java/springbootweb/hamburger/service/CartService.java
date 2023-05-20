package springbootweb.hamburger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import springbootweb.hamburger.dto.CartItemDto;
import springbootweb.hamburger.dto.CartListDto;
import springbootweb.hamburger.entity.Cart;
import springbootweb.hamburger.entity.CartItem;
import springbootweb.hamburger.entity.Member;
import springbootweb.hamburger.entity.Order;
import springbootweb.hamburger.repository.CartItemRepository;
import springbootweb.hamburger.repository.CartRepository;
import springbootweb.hamburger.repository.MemberRepository;
import springbootweb.hamburger.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
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

    public void deleteCartItem(Long cartItemId){
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(EntityNotFoundException::new);
        cartItemRepository.delete(cartItem);
    }

    @Transactional(readOnly = true)
    public List<CartListDto> getCartList(String email){

        List<CartListDto> cartListDtos = new ArrayList<>();

        Member member = memberRepository.findByEmail(email);
        Cart cart =cartRepository.findByMemberId(member.getId());
        if(cart == null){
            return cartListDtos;
        }

        cartListDtos = cartItemRepository.findCartListDto(cart.getId());
        return cartListDtos;
    }

    @Transactional(readOnly = true)
    public boolean validateCartItem(Long cartItemId, String email){
        Member curMember = memberRepository.findByEmail(email);
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(EntityNotFoundException::new);

        Member savedMember = cartItem.getCart().getMember();

        if(!StringUtils.equals(curMember.getEmail(),savedMember.getEmail())){
            return false;
        }
        return true;
    }

    public void updateCount(Long cartItemId, int count){
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(EntityNotFoundException::new);
        cartItem.updateCount(count);
    }
}
