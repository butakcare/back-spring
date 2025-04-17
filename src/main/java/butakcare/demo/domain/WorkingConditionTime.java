package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setWorkingCondition(WorkingCondition workingCondition){
        this.workingCondition = workingCondition;
    }
}
