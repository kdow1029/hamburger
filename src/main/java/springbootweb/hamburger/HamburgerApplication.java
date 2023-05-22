package springbootweb.hamburger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springbootweb.hamburger.dto.Member;

@SpringBootApplication
/*@ComponentScan(basePackageClasses = Member.class)*/
/*@MapperScan*/

public class HamburgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HamburgerApplication.class, args);
	}

}
