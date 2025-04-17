package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class CaregiverConditionTime {

    @Id @GeneratedValue
    private Long id;

    private String weekday;

    @Column(nullable = true)
    private LocalTime startTime;

    @Column(nullable = true)
    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private CaregiverCondition caregiverCondition;

    public void setCaregiverCondition(CaregiverCondition caregiverCondition) {
        this.caregiverCondition = caregiverCondition;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
