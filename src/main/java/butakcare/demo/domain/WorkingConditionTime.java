package butakcare.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalTime;

@Entity
@Getter
public class WorkingConditionTime {

    @Id @GeneratedValue
    private Long id;

    private String day;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne
    private WorkingCondition workingCondition;
}
