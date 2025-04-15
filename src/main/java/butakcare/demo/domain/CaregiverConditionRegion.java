package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CaregiverConditionRegion {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private CaregiverCondition caregiverCondition;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setCaregiverCondition(CaregiverCondition caregiverCondition) {
        this.caregiverCondition = caregiverCondition;
    }
}
