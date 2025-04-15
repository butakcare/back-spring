package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class WorkingCondition {

    @Id @GeneratedValue
    private Long id;

    private Integer wage;

    @OneToOne
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    private Senior senior;

    @OneToMany(mappedBy = "workingCondition")
    private List<WorkingConditionTime> workingConditionTimeList = new ArrayList<>();
}
