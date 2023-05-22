package springbootweb.hamburger.dto;

import lombok.Data;

@Data
public class Member {
    private String id;
    private String name;
    private int age;
    private String pw;
    private int phone;
    private String add;
}
