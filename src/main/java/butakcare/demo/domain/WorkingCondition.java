package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class WorkingCondition {

    @Id @GeneratedValue
    private Long id;

    private Integer wage;

    @ManyToOne
    private Senior senior;

    @OneToMany(mappedBy = "workingCondition")
    private List<WorkingConditionTime> workingConditionTimeList = new ArrayList<>();
}
