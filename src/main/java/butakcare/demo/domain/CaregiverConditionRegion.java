package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CaregiverConditionRegion {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private CaregiverCondition caregiverCondition;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;
}
