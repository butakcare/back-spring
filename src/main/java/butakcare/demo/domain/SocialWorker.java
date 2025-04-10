package butakcare.demo.domain;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class SocialWorker extends User{

    private String description;

    private String role;
}
