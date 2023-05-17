package springbootweb.hamburger.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import springbootweb.hamburger.entity.Order;

@Getter
@Setter
@NoArgsConstructor
public class OrderSaveDto {

    private Long id;

    private String menu;

    private String content;

    private int price;

    private int count;

    private static ModelMapper modelMapper = new ModelMapper();


    @Builder
    public OrderSaveDto(Long id, String menu, String content, int price, int count){
        this.id = id;
        this.menu = menu;
        this.content = content;
        this.price = price;
        this.count = count;
    }

    public Order toEntity(){
        return Order.builder()
                .id(id)
                .menu(menu)
                .content(content)
                .price(price)
                .count(count)
                .build();

    }

    public static OrderSaveDto of(Order order){
        return modelMapper.map(order, OrderSaveDto.class);
    }
}
