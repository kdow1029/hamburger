package springbootweb.hamburger.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter
@Setter
@ToString
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;

//   @OneToOne(fetch = FetchType.LAZY)
//   @JoinColumn(name = "member_id")
//   private Member member;


//    public static Cart createCart(Member member){
//        Cart cart = new Cart();
//        cart.setMember(member);
//        return cart;
//    }


}
