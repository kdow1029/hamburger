package springbootweb.hamburger.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CartDto {

    @NotNull(message = "상품 아이디 필수 입력")
    private Long orderId;

    @Min(value = 1, message = "최소 1개 이상 구매")
    private int count;
}
