package springbootweb.hamburger.dto;

import lombok.Getter;
import springbootweb.hamburger.domain.Order;


@Getter
public class OrderResDto {

    private final Long order_Id;

    private final String menu;

    private final String content;

    private final int price;

    public OrderResDto(Order entity){
        this.order_Id = entity.getId();
        this.menu = entity.getMenu();
        this.content = entity.getContent();
        this.price =entity.getPrice();
    }

    }

