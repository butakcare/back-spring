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

    private String schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

    @OneToOne(fetch = FetchType.LAZY)
    private Senior senior;

    @OneToMany(mappedBy = "workingCondition", cascade = CascadeType.ALL)
    private List<WorkingConditionTime> times = new ArrayList<>();

    public void setSenior(Senior senior){
        this.senior = senior;
    }

    public void addTimes(WorkingConditionTime time){
        this.times.add(time);
        time.setWorkingCondition(this);
    }
}
