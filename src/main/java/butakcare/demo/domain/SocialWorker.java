package butakcare.demo.domain;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class SocialWorker extends CommonUser {

    private String description;

    private String role;
}
