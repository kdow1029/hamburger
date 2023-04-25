package springbootweb.hamburger.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_Id;

    @Column(length = 100, nullable = false)
    private String menu;

    @Column(length = 100, nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private int price;

    @Builder
    public Order(String menu, String content, int price){
        this.menu = menu;
        this.content = content;
        this.price = price;
    }

}
