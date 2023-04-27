package springbootweb.hamburger.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springbootweb.hamburger.domain.Order;

@Getter
@NoArgsConstructor
public class OrderSaveReqDto {

    private String menu;

    private String content;

    private int price;


    @Builder
    public OrderSaveReqDto(String menu, String content, int price){
        this.menu = menu;
        this.content = content;
        this.price = price;
    }

    public Order toEntity(){
        return Order.builder()
                .menu(menu)
                .content(content)
                .price(price)
                .build();

    }
}
