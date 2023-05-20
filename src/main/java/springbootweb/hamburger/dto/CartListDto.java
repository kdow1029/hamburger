package springbootweb.hamburger.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartListDto {

    private Long cartItemId;

    private String menu;

    private int price;

    private int count;

    @Builder
    public CartListDto(Long cartItemId, String menu, int price, int count){
        this.cartItemId = cartItemId;
        this.menu = menu;
        this.price = price;
        this.count = count;
    }
}
