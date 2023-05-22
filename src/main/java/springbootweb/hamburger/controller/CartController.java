/*
package springbootweb.hamburger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import springbootweb.hamburger.dto.CartItemDto;
import springbootweb.hamburger.dto.CartListDto;
import springbootweb.hamburger.service.CartService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    @PostMapping("/cart")
    public @ResponseBody ResponseEntity order(@RequestBody @Valid CartItemDto cartItemDto, BindingResult bindingResult, Principal principal){

        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError: fieldErrors){
                sb.append(fieldError.getDefaultMessage());
            }
            return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        String email = principal.getName();
        Long cartItemId;

        try {
            cartItemId = cartService.addCart(cartItemDto, email);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Long>(cartItemId, HttpStatus.OK);
        }

        @GetMapping(value = "/cart")
        public String orderList(Principal principal, Model model){
            List<CartListDto> cartList = cartService.getCartList(principal.getName());
            model.addAttribute("cartItem", cartList);
            return "cart/shopping_basket";

        }

        @PatchMapping(value = "/cart/{cartItemId}")
        public @ResponseBody ResponseEntity updateCart(@PathVariable("cartItemId") Long cartItemId,
                                                       int count, Principal principal){

            if(count <= 0){
                return new ResponseEntity<String>("최소 1개 담아주세요.", HttpStatus.BAD_REQUEST);
            }else if(!cartService.validateCartItem(cartItemId, principal.getName())){
                return new ResponseEntity<String>("수정권한 없음", HttpStatus.FORBIDDEN);
            }

            cartService.updateCount(cartItemId, count);
            return new ResponseEntity<Long>(cartItemId, HttpStatus.OK);
        }

        @DeleteMapping(value = "/cart/{cartItemId}")
        public @ResponseBody ResponseEntity deleteCart(@PathVariable("cartItemId") Long cartItemId, Principal principal){

            if(!cartService.validateCartItem(cartItemId, principal.getName())){
                return new ResponseEntity<String>("수정권한 없음", HttpStatus.FORBIDDEN);
            }

            cartService.deleteCartItem(cartItemId);
            return new ResponseEntity<Long>(cartItemId, HttpStatus.OK);
        }
    }

*/
