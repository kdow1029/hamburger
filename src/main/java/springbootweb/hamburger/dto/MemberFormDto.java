package springbootweb.hamburger.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberFormDto {

    @NotBlank(message = "필수 값")
    private String name;

    @NotEmpty(message = "필수 값")
    @Email(message = "이메일 형식")
    private String email;

    @NotEmpty(message = "필수 값")
    @Length(min = 4, max = 16, message = "4 이상 16이하")
    private String password;
}
