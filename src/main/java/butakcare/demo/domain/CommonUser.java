package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor
public class CommonUser {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String password;

    private String phoneNumber;

    private String photo;
}
