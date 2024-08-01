package ro.itschool.testcontroller.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private String name;
    private int age;
    private String email;
    private String address;
    private IdentityCardDto identityCard;
}
