package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class WorkingConditionTime {

    @Id @GeneratedValue
    private Long id;

    private String weekday;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private WorkingCondition workingCondition;

    public void setWorkingCondition(WorkingCondition workingCondition){
        this.workingCondition = workingCondition;
    }
}
