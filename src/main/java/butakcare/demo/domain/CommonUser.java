package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class CommonUser {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String name;

    private String password;

    private String phoneNumber;

    private String photo;
}
