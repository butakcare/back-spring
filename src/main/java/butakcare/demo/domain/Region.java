package butakcare.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Region {

    @Id
    private String regionId;

    private String sido;

    private String sigungu;

    private String eupmyeondong;
}
