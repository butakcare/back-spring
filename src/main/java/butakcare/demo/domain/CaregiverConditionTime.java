package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalTime;

@Entity
@Getter
public class CaregiverConditionTime {

    @Id @GeneratedValue
    private Long id;

    private String weekday;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private CaregiverCondition caregiverCondition;
}
