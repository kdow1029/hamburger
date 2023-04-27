package springbootweb.hamburger.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String menu;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private int price;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<ShoppingBasket> baskets = new ArrayList<>();

    @Builder
    public Order(String menu, String content, int price){
        this.menu = menu;
        this.content = content;
        this.price = price;
    }

}
