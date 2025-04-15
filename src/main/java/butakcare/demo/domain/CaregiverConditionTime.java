package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class CaregiverConditionTime {

    @Id @GeneratedValue
    private Long id;

    private String weekday;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private CaregiverCondition caregiverCondition;

    public void setCaregiverCondition(CaregiverCondition caregiverCondition) {
        this.caregiverCondition = caregiverCondition;
    }
}
