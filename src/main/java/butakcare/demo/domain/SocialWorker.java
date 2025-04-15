package butakcare.demo.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class SocialWorker extends CommonUser {

    private String description;

    private String role;
}
