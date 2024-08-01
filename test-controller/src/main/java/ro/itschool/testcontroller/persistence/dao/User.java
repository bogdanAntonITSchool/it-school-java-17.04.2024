package ro.itschool.testcontroller.persistence.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String name;

    @NotNull
    @Column(unique = true)
    private String address;

    @NotNull
    private String email;

    @NotNull
    private int age;

    @Transient
    private String ignoreMe;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private IdentityCard identityCard;
}
