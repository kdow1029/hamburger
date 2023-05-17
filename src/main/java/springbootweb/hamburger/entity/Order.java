package springbootweb.hamburger.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String menu;

    @Column(nullable = false)
    private String content;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "count", nullable = false)
    private int count;

    @Builder
    public Order(Long id, String menu, String content, int price, int count){
        this.id = id;
        this.menu = menu;
        this.content = content;
        this.price = price;
        this.count = count;
    }
}
