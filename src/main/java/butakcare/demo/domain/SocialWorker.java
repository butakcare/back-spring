package butakcare.demo.domain;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class SocialWorker extends User{

    private String phoneNumber;

    private String description;

    private String role;

    private String photo;
}
